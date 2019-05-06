package bowling.bowlingMechanic.frame;

import bowling.bowlingMechanic.frame.chance.roll.Roll;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrameTest {

    private Frame frame;

    @Before
    public void setUp() throws Exception {
        frame = new Frame();
    }

    @Test
    public void addRoll() {
        assertFalse(frame.isOver());
        assertEquals(-1, frame.type());
        assertTrue(frame.addRoll(new Roll(10)));
        assertEquals(10, frame.getScore());
        assertEquals(0, frame.type());
        assertTrue(frame.isOver());
    }

    @Test
    public void addRoll1() {
        assertFalse(frame.isOver());
        assertTrue(frame.addRoll(new Roll(3)));
        assertEquals(3, frame.type());
        assertEquals(3, frame.getScore());
        assertTrue(frame.addRoll(new Roll(7)));
        assertEquals(10, frame.getScore());
        assertEquals(1, frame.type());
        assertTrue(frame.isOver());
    }

    @Test
    public void addRoll2() {
        assertFalse(frame.isOver());
        assertTrue(frame.addRoll(new Roll(3)));
        assertTrue(frame.addRoll(new Roll(3)));
        assertEquals(6, frame.getScore());
        assertEquals(2, frame.type());
        assertTrue(frame.isOver());
    }

    @Test
    public void addRoll3() {
        frame = new Frame(true);
        assertFalse(frame.isOver());
        assertTrue(frame.addRoll(new Roll(3)));
        assertTrue(frame.addRoll(new Roll(3)));
        assertEquals(6, frame.getScore());

        assertTrue(frame.isOver());
    }

    @Test
    public void addRoll4() {
        frame = new Frame(true);
        assertFalse(frame.isOver());
        assertTrue(frame.addRoll(new Roll(3)));
        assertTrue(frame.addRoll(new Roll(7)));
        assertTrue(frame.addRoll(new Roll(7)));
        assertEquals(17, frame.getScore());

        assertTrue(frame.isOver());
    }

    @Test
    public void addRoll5() {
        frame = new Frame(true);
        assertFalse(frame.isOver());
        assertTrue(frame.addRoll(new Roll(10)));
        assertTrue(frame.addRoll(new Roll(10)));
        assertTrue(frame.addRoll(new Roll(10)));
        assertEquals(30, frame.getScore());
        assertTrue(frame.isOver());
    }

    @Test
    public void addRoll6() {
        frame = new Frame(true);
        assertFalse(frame.isOver());
        assertTrue(frame.addRoll(new Roll(10)));
        assertTrue(frame.addRoll(new Roll(3)));
        assertTrue(frame.addRoll(new Roll(7)));
        assertEquals(20, frame.getScore());
        assertTrue(frame.isOver());
    }

    @Test
    public void addRoll7() {
        frame = new Frame(true);
        assertFalse(frame.isOver());
        assertTrue(frame.addRoll(new Roll(10)));
        assertTrue(frame.addRoll(new Roll(3)));
        assertTrue(frame.addRoll(new Roll(3)));
        assertEquals(16, frame.getScore());
        assertTrue(frame.isOver());
    }

}