package com.dev.operaapp.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "performance")
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", description='" + description + '\''
                + '}';
    }

    @Override
    public boolean equals(Object movieComp) {
        if (this == movieComp) {
            return true;
        }
        if (movieComp == null || getClass() != movieComp.getClass()) {
            return false;
        }
        Performance performance = (Performance) movieComp;
        return Objects.equals(id, performance.id) && Objects.equals(title, performance.title)
                && Objects.equals(description, performance.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }
}
