package com.dev.operaapp.service.impl;

import com.dev.operaapp.dao.PerformanceSessionDao;
import com.dev.operaapp.model.PerformanceSession;
import com.dev.operaapp.service.PerformanceSessionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PerformanceSessionServiceImpl implements PerformanceSessionService {
    private final PerformanceSessionDao performanceSessionDao;

    public PerformanceSessionServiceImpl(PerformanceSessionDao performanceSessionDao) {
        this.performanceSessionDao = performanceSessionDao;
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date) {
        return performanceSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public PerformanceSession add(PerformanceSession session) {
        return performanceSessionDao.add(session);
    }

    @Override
    public void delete(Long id) {
        performanceSessionDao.delete(id);
    }

    @Override
    public void update(PerformanceSession performanceSession) {
        performanceSessionDao.update(performanceSession);
    }

    @Override
    public PerformanceSession get(Long id) {
        return performanceSessionDao.get(id);
    }
}
