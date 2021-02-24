package com.dev.operaapp.service;

import com.dev.operaapp.model.PerformanceSession;
import java.time.LocalDate;
import java.util.List;

public interface PerformanceSessionService {
    List<PerformanceSession> findAvailableSessions(Long movieId, LocalDate date);

    PerformanceSession add(PerformanceSession session);

    void delete(Long id);

    void update(PerformanceSession performanceSession);

    PerformanceSession get(Long id);
}
