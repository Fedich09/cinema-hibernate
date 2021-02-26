package com.dev.operaapp.service;

import com.dev.operaapp.model.Stage;
import java.util.List;

public interface StageService {
    Stage add(Stage stage);

    List<Stage> getAll();

    Stage get(Long id);
}
