package bowling;

import bowling.bowlingMechanic.frame.chance.roll.Roll;
import bowling.bowlingMechanic.player.Player;
import bowling.bowlingMechanic.table.Table;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingTest {
    private Bowling bowling;

    @Before
    public void setUp() throws Exception {
        bowling = new Bowling();
    }

    @Test
    public void addPlayer() {
        assertTrue(bowling.addPlayer(new Player(1, "paul")));
        assertFalse(bowling.addPlayer(new Player(1, "paul")));

    }

    @Test
    public void addRoll() {
        Player player = new Player(1, "paul");
        assertFalse(bowling.addRoll(player, new Roll(2)));
        assertTrue(bowling.addPlayer(player));
        assertEquals(player, bowling.getPlayer(1));
    }

    @Test
    public void addRoll1() {
        Player player = new Player(1, "paul");
        bowling.addPlayer(player);
        int[] arr = new int[]{10, 7, 3, 7, 2, 9, 1, 10, 10, 10, 2, 3, 6, 4, 7, 3, 3};
        for (int x : arr) {
            assertTrue(bowling.addRoll(player, new Roll(x)));
        }
        assertFalse(bowling.addRoll(player, new Roll(2)));
        Table table = bowling.gameStatus().get(0);
        assertEquals(168, table.getTotal());
    }
}