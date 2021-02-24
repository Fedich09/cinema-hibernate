package com.dev.cinema.service;

import com.dev.cinema.model.Performance;
import java.util.List;

public interface PerformanceService {
    Performance add(Performance performance);

    List<Performance> getAll();

    Performance get(Long id);
}
