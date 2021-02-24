package com.dev.cinema.service;

import com.dev.cinema.model.Stage;
import java.util.List;

public interface StageService {
    Stage add(Stage stage);

    List<Stage> getAll();

    Stage get(Long id);
}
