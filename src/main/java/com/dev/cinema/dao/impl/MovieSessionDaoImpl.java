package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.MovieSessionDao;
import com.dev.cinema.exception.DataProcessingException;
import com.dev.cinema.lib.Dao;
import com.dev.cinema.model.MovieSession;
import com.dev.cinema.util.HibernateUtil;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class MovieSessionDaoImpl implements MovieSessionDao {
    public static final int HOUR = 23;
    public static final int MINUTE = 59;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            LocalDateTime startOfDay = date.atStartOfDay();
            LocalDateTime endOfDay = date.atTime(HOUR, MINUTE);
            Query<MovieSession> movieQuery = session.createQuery("from MovieSession ms "
                    + "join fetch ms.movie "
                    + "where ms.movie.id = :id "
                    + "and ms.showTime >= :start "
                    + "and ms.showTime <= :end", MovieSession.class);
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
    public MovieSession add(MovieSession movieSession) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(movieSession);
            transaction.commit();
            return movieSession;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add movie session " + movieSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
