package com.dev.operaapp.dao.impl;

import com.dev.operaapp.dao.TicketDao;
import com.dev.operaapp.exception.DataProcessingException;
import com.dev.operaapp.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl implements TicketDao {
    private final SessionFactory sessionFactory;

    public TicketDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Ticket add(Ticket ticket) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
            return ticket;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't create tickete " + ticket, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
