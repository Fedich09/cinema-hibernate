package com.dev.operaapp.dao;

import com.dev.operaapp.model.PerformanceSession;
import java.time.LocalDate;
import java.util.List;

public interface PerformanceSessionDao {
    List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date);

    PerformanceSession add(PerformanceSession session);

    void delete(Long id);

    void update(PerformanceSession performanceSession);

    PerformanceSession get(Long id);
}
