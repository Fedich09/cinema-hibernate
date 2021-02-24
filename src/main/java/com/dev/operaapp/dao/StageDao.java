package com.dev.operaapp.dao;

import com.dev.operaapp.model.Stage;
import java.util.List;

public interface StageDao {
    Stage add(Stage stage);

    List<Stage> getAll();

    Stage get(Long id);
}
