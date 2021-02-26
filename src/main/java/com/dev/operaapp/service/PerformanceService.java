package com.dev.operaapp.service;

import com.dev.operaapp.model.Performance;
import java.util.List;

public interface PerformanceService {
    Performance add(Performance performance);

    List<Performance> getAll();

    Performance get(Long id);
}
