package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoList {
    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public int add(String description) {
        Task t = new Task(nextId, description);
        tasks.add(t);
        return nextId++;
    }

    public boolean complete(int id) {
        Task t = findById(id);
        if (t == null) return false;
        t.markCompleted();
        return true;
    }

    public List<Task> all() {
        return Collections.unmodifiableList(tasks);
    }

    public List<Task> complete() {
        List<Task> out = new ArrayList<>();
        for (Task t : tasks) {
            if (t.isCompleted()) out.add(t);
        }
        return out;
    }

    public List<Task> incomplete() {
        List<Task> out = new ArrayList<>();
        for (Task t : tasks) {
            if (!t.isCompleted()) out.add(t);
        }
        return out;
    }

    public void clear() {
        tasks.clear();
        nextId = 1;
    }

    private Task findById(int id) {
        for (Task t : tasks) {
            if (t.getId() == id) return t;
        }
        return null;
    }
}
