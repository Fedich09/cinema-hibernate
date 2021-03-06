package com.dev.operaapp.service.impl;

import com.dev.operaapp.dao.PerformanceDao;
import com.dev.operaapp.model.Performance;
import com.dev.operaapp.service.PerformanceService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PerformanceServiceImpl implements PerformanceService {
    private final PerformanceDao performanceDao;

    public PerformanceServiceImpl(PerformanceDao performanceDao) {
        this.performanceDao = performanceDao;
    }

    @Override
    public Performance add(Performance performance) {
        return performanceDao.add(performance);
    }

    @Override
    public List<Performance> getAll() {
        return performanceDao.getAll();
    }

    @Override
    public Performance get(Long id) {
        return performanceDao.get(id);
    }
}
