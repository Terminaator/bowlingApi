package bowling.bowlingMechanic.frame;

import bowling.bowlingMechanic.frame.chance.roll.Roll;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FramesTest {
    private Frames frames;

    @Before
    public void setUp() throws Exception {
        frames = new Frames();
    }

    @Test
    public void addRoll() {
        for (int x = 0; x < 12; x++) {
            assertFalse(frames.isOver());
            assertTrue(frames.addRoll(new Roll(10)));
        }
        assertTrue(frames.isOver());
        assertFalse(frames.addRoll(new Roll(10)));
        assertEquals(300, frames.score());
    }

    @Test
    public void addRoll1() {
        for (int x = 0, y = 0; x < 10; x++) {
            assertFalse(frames.isOver());
            assertTrue(frames.addRoll(new Roll(0)));
            assertTrue(frames.addRoll(new Roll(y++)));
        }
        assertEquals(45, frames.score());
        assertTrue(frames.isOver());


    }

    @Test
    public void addRoll2() {
        for (int x = 0, y = 0; x < 8; x++) {
            assertFalse(frames.isOver());
            assertTrue(frames.addRoll(new Roll(0)));
            assertTrue(frames.addRoll(new Roll(y++)));
        }
        assertTrue(frames.addRoll(new Roll(4)));
        assertTrue(frames.addRoll(new Roll(6)));
        assertTrue(frames.addRoll(new Roll(2)));
        assertTrue(frames.addRoll(new Roll(3)));
        assertEquals(45, frames.score());
        assertTrue(frames.isOver());


    }

    @Test
    public void addRoll3() {
        int[] arr = new int[]{10, 7, 3, 7, 2, 9, 1, 10, 10, 10, 2, 3, 6, 4, 7, 3, 3};
        for (int x : arr) {
            assertTrue(frames.addRoll(new Roll(x)));
        }
        assertEquals(168, frames.score());
        assertTrue(frames.isOver());

    }

}