import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(123,"Купить Хлеб");

        boolean actual = task.matches("Хлеб");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask task = new SimpleTask(123,"Купить Хлеб");

        boolean actual = task.matches("Колбаса");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testShouldMatchQueryCaseInsensitive() {
        SimpleTask task = new SimpleTask(123,"Купить Хлеб");

        boolean actual = task.matches("хлеб");

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldReturnTitle() {

        SimpleTask simpleTask = new SimpleTask(1, "Купить Хлеб");

        Assertions.assertEquals("Купить Хлеб", simpleTask.getTitle());
    }

    @Test
    public void testTheMatchingOfAQueryInSubtasks() {

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(123, subtasks);

        boolean actual = epic.matches("Яйца");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicNotNormal() {

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(123, subtasks);

        boolean actual = epic.matches("Колбаса");

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldReturnSubtasks() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(1, subtasks);

        Assertions.assertArrayEquals(subtasks, epic.getSubtasks());
    }

    @Test
    public void TestTheComplianceOfAQueryByTopic() {

        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Выкатка");

        Assertions.assertTrue(actual);
    }

    @Test
    public void TestTheComplianceOfTheProjectRequest() {

        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Приложение");

        Assertions.assertTrue(actual);
    }

    @Test
    public void TestTheLackOfComplianceWithTheRequest() {

        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Книга");

        Assertions.assertFalse(actual);
    }
    @Test
    public void shouldReturnTopic() {

        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        assertEquals("Выкатка 3й версии приложения", meeting.getTopic());
    }

    @Test
    public void shouldReturnProject() {

        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        assertEquals("Приложение НетоБанка", meeting.getProject());
    }

    @Test
    public void shouldReturnStart() {

        Meeting meeting = new Meeting(555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        assertEquals("Во вторник после обеда", meeting.getStart());
    }

    @Test
    public void shouldEqualTasksWithSameId() {
        Task task1 = new Task(1);
        Task task2 = new Task(1);

        assertEquals(task1, task2);
    }

    @Test
    public void shouldNotEqualTasksWithDifferentId() {
        Task task1 = new Task(1);
        Task task2 = new Task(2);

        assertNotEquals(task1, task2);
    }

    @Test
    public void shouldReturnHashCode() {
        Task task = new Task(1);

        assertEquals(Objects.hash(1), task.hashCode());
    }

    @Test
    public void shouldReturnId() {
        Task task = new Task(1);

        assertEquals(1, task.getId());
    }

    @Test
    public void shouldNotMatchAnyQuery() {
        Task task = new Task(1);

        assertFalse(task.matches("anyQuery"));
    }

    @Test
    public void shouldReturnTrueForEqualObjects() {
        Task task1 = new Task(1);
        Task task2 = new Task(1);

        assertTrue(task1.equals(task2));
    }

    @Test
    public void shouldReturnFalseForDifferentObjects() {
        Task task1 = new Task(1);
        Task task2 = new Task(2);

        assertFalse(task1.equals(task2));
    }

    @Test
    public void shouldReturnFalseForObjectAndNull() {
        Task task = new Task(1);

        assertFalse(task.equals(null));
    }

    @Test
    public void shouldReturnFalseForDifferentClasses() {
        Task task = new Task(1);

        assertFalse(task.equals("Not a Task"));
    }

    @Test
    public void shouldReturnConsistentHashCode() {
        Task task = new Task(1);

        assertEquals(task.hashCode(), task.hashCode());
    }

    @Test
    public void shouldReturnFalseForNullObject() {
        Task task = new Task(1);

        assertFalse(task.equals(null));
    }

    @Test
    public void shouldReturnTrueForSameObject() {
        Task task = new Task(1);

        assertTrue(task.equals(task));
    }

    @Test
    public void shouldReturnTrueForEqualObjects2() {
        Task task1 = new Task(1);
        Task task2 = new Task(1);
        
        assertTrue(task1.equals(task2));
    }
}