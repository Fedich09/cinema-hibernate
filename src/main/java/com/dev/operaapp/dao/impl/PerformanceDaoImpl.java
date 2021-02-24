package com.dev.operaapp.dao.impl;

import com.dev.operaapp.dao.PerformanceDao;
import com.dev.operaapp.exception.DataProcessingException;
import com.dev.operaapp.model.Performance;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceDaoImpl implements PerformanceDao {
    private final SessionFactory sessionFactory;

    public PerformanceDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Performance add(Performance performance) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(performance);
            transaction.commit();
            return performance;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert performance entity " + performance, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Performance> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Performance> movieQuery = session
                    .createQuery("from Performance", Performance.class);
            return movieQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get list of all performance ", e);
        }
    }

    @Override
    public Performance get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Performance.class, id);
        } catch (Exception e) {
            throw new DataProcessingException("Can't get performance by id" + id, e);
        }
    }
}
