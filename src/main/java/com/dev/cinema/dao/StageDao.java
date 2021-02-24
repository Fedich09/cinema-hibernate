package com.dev.cinema.dao;

import com.dev.cinema.model.Stage;
import java.util.List;

public interface StageDao {
    Stage add(Stage stage);

    List<Stage> getAll();

    Stage get(Long id);
}
