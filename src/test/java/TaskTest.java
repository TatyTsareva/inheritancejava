import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertTrue(actual);

    }

    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Написать");
        Assertions.assertFalse(actual);

    }

    @Test
    public void testEpicMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("Яйца");
        Assertions.assertTrue(actual);

    }

    @Test
    public void testEpicNotMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("Курица");
        Assertions.assertFalse(actual);

    }

    @Test
    public void testMeetingMatches() {
        String[] subtasks = {"Выкатка 3й версии приложения"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("приложения");
        Assertions.assertTrue(actual);

    }

    @Test
    public void testMeetingMatches2() {
        String[] subtasks = {"Приложение НетоБанка"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("НетоБанка");
        Assertions.assertTrue(actual);

    }

    @Test
    public void testMeetingNotMatches() {
        String[] subtasks = {"Во вторник после обеда"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("ужина");
        Assertions.assertFalse(actual);

    }
}