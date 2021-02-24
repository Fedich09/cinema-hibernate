package com.dev.cinema.model;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "performance_session")
public class PerformanceSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Performance performance;
    @ManyToOne
    @JoinColumn(name = "stage_id")
    private Stage stage;
    @JoinColumn(name = "show_time")
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "PerformanceSession{"
                + "id=" + id
                + ", performance=" + performance
                + ", stage=" + stage
                + ", showTime=" + showTime
                + '}';
    }

    @Override
    public boolean equals(Object first) {
        if (this == first) {
            return true;
        }
        if (first == null || getClass() != first.getClass()) {
            return false;
        }
        PerformanceSession that = (PerformanceSession) first;
        return Objects.equals(id, that.id) && Objects.equals(performance, that.performance)
                && Objects.equals(stage, that.stage)
                && Objects.equals(showTime, that.showTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, performance, stage, showTime);
    }
}
