package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.PerformanceDao;
import com.dev.cinema.exception.DataProcessingException;
import com.dev.cinema.model.Performance;
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
            throw new DataProcessingException("Can't insert Movie entity " + performance, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Performance> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Performance> movieQuery = session.createQuery("from Performance", Performance.class);
            return movieQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get list of all movies ", e);
        }
    }

    @Override
    public Performance get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Performance.class, id);
        } catch (Exception e) {
            throw new DataProcessingException("Can't get movie by id" + id, e);
        }
    }
}
