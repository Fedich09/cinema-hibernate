package com.dev.cinema.dao;

import com.dev.cinema.model.Performance;
import java.util.List;

public interface PerformanceDao {
    Performance add(Performance performance);

    List<Performance> getAll();

    Performance get(Long id);
}
