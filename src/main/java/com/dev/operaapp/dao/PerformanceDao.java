package com.dev.operaapp.dao;

import com.dev.operaapp.model.Performance;
import java.util.List;

public interface PerformanceDao {
    Performance add(Performance performance);

    List<Performance> getAll();

    Performance get(Long id);
}
