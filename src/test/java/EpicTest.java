import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpicTest {

    @Test
    public void testEpicNormal() {
        SimpleTask epic = new SimpleTask(123,"Купить Яйца");

        boolean actual = epic.matches("Яйца");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicNotNormal() {
        SimpleTask epic = new SimpleTask(123,"Купить Яйца");

        boolean actual = epic.matches("Колбаса");

        Assertions.assertFalse(actual);
    }

}