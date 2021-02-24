package com.dev.cinema.service.impl;

import com.dev.cinema.dao.StageDao;
import com.dev.cinema.model.Stage;
import com.dev.cinema.service.StageService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StageServiceImpl implements StageService {
    private final StageDao stageDao;

    public StageServiceImpl(StageDao stageDao) {
        this.stageDao = stageDao;
    }

    @Override
    public Stage add(Stage stage) {
        return stageDao.add(stage);
    }

    @Override
    public List<Stage> getAll() {
        return stageDao.getAll();
    }

    @Override
    public Stage get(Long id) {
        return stageDao.get(id);
    }
}
