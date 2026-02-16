package org.example;


import java.util.Objects;

public class Task {
    private final int id;
    private final String description;
    private boolean completed;

    public Task(int id, String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be null or blank.");
        }
        this.id = id;
        this.description = description.trim();
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return String.format("[%s] (%d) %s", completed ? "X" : " ", id, description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
