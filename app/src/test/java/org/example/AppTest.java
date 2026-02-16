package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


class AppTest {

    @Test
    void add_validTask_increasesList() {
        TodoList todo = new TodoList();
        int id1 = todo.add("Study Java");
        int id2 = todo.add("Go to gym");

        assertEquals(2, todo.all().size());
        assertEquals(1, id1);
        assertEquals(2, id2);
    }

    @Test
    void add_blankTask_throws() {
        TodoList todo = new TodoList();
        assertThrows(IllegalArgumentException.class, () -> todo.add("   "));
        assertThrows(IllegalArgumentException.class, () -> todo.add(null));
    }

    @Test
    void complete_validId_marksTaskCompleted() {
        TodoList todo = new TodoList();
        int id = todo.add("Do homework");

        assertTrue(todo.complete(id));
        assertEquals(1, todo.complete().size());
        assertEquals(0, todo.incomplete().size());
    }

    @Test
    void complete_invalidId_returnsFalse_noCrash() {
        TodoList todo = new TodoList();
        todo.add("Task 1");

        assertFalse(todo.complete(999));
        assertEquals(0, todo.complete().size());
        assertEquals(1, todo.incomplete().size());
    }

    @Test
    void clear_removesEverything_andResetsIds() {
        TodoList todo = new TodoList();
        todo.add("A");
        todo.add("B");
        todo.clear();

        assertEquals(0, todo.all().size());

        int newId = todo.add("C");
        assertEquals(1, newId);
    }

    @Test
    void all_complete_incomplete_returnCorrectItems() {
        TodoList todo = new TodoList();
        int a = todo.add("A");
        int b = todo.add("B");
        todo.complete(b);

        List<Task> all = todo.all();
        List<Task> complete = todo.complete();
        List<Task> incomplete = todo.incomplete();

        assertEquals(2, all.size());
        assertEquals(1, complete.size());
        assertEquals(1, incomplete.size());

        assertEquals(b, complete.get(0).getId());
        assertEquals(a, incomplete.get(0).getId());
    }
}
