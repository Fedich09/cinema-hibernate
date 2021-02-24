package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.PerformanceSessionDao;
import com.dev.cinema.exception.DataProcessingException;
import com.dev.cinema.model.PerformanceSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class PerformanceSessionDaoImpl implements PerformanceSessionDao {
    private final SessionFactory sessionFactory;

    public PerformanceSessionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            LocalDateTime startOfDay = date.atStartOfDay();
            LocalDateTime endOfDay = date.atTime(LocalTime.MAX);
            Query<PerformanceSession> movieQuery = session.createQuery("from PerformanceSession ms "
                    + "where ms.performance.id = :id "
                    + "and ms.showTime >= :start "
                    + "and ms.showTime <= :end", PerformanceSession.class);
            movieQuery.setParameter("id", movieId);
            movieQuery.setParameter("start", startOfDay);
            movieQuery.setParameter("end", endOfDay);
            return movieQuery.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find available sessions on this movie id "
                    + movieId + " and on this date " + date, e);
        }
    }

    @Override
    public PerformanceSession add(PerformanceSession performanceSession) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(performanceSession);
            transaction.commit();
            return performanceSession;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add movie session " + performanceSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            PerformanceSession performanceSession = session.load(PerformanceSession.class, id);
            session.delete(performanceSession);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't delete movie session by id " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(PerformanceSession performanceSession) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(performanceSession);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't update movie session " + performanceSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public PerformanceSession get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(PerformanceSession.class, id);
        } catch (Exception e) {
            throw new DataProcessingException("Can't get performance session by id " + id, e);
        }
    }
}
