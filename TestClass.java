import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.security.SecureRandom;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

public class TestClass {

    private LinkedList<String> list;
    private final static Logger logger = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());

    @Before
    public void setup() {
        list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Integer.toString(i));
        }
        logger.setLevel(java.util.logging.Level.ALL);
    }

    @Test
    public void pop() {
        list.pop();
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null", list.toString());
    }

    @Test
    public void get() {
        assertEquals("2", list.get(2));
    }

    @Test
    public void add() {
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> null", list.add("10").toString());
    }

    @Test
    public void remove() {
        assertEquals("1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null", list.remove("0").toString());
    }

    @Test
    public void addMultiple() {
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11 -> 12 -> 13 -> null",
                list.add("10", "11", "12", "13").toString());
    }

    @Test
    public void toStringBackwards() {
        assertEquals("9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> 0 -> null", list.toStringBackwards());
    }

    @Test
    public void reverse() {
        assertEquals("9 -> 8 -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> 0 -> null", list.reverse().toString());
    }

    @Test
    public void print() {
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null", list.toString());
    }

    @Test
    public void reverseAndToStringBackwards() {
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null", list.reverse().toStringBackwards());
    }

    @Test
    public void addFront() {
        assertEquals("11 -> 10 -> 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null",
                list.addFront("10", "11").toString());
    }

    @Test
    public void addDuplicate() {
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null", list.add("1", "0").toString());
    }

    @Test
    public void sort() {
        list.remove("5", "6", "7", "8").add("8", "7", "6", "5");
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null", list.sort().toString());
    }

    @Test
    public void clear() {
        assertEquals("", list.clear().toString());
    }

    @Test
    public void randomToSorted() {
        list.clear();
        for (int i = 0; i < 10; i++) {
            list.add(Integer.toString(new SecureRandom().nextInt(10)));
        }
        list = list.sort();
        assertTrue(list.isSorted(list.getTail()));
    }
}