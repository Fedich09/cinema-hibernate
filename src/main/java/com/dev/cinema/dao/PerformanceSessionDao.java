package com.dev.cinema.dao;

import com.dev.cinema.model.PerformanceSession;
import java.time.LocalDate;
import java.util.List;

public interface PerformanceSessionDao {
    List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date);

    PerformanceSession add(PerformanceSession session);

    void delete(Long id);

    void update(PerformanceSession performanceSession);

    PerformanceSession get(Long id);
}
