package ohtuesimerkki;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchFindsPlayer() {
        Player player = new Player("Semenko", "EDM", 4, 12);
        Player searched = stats.search("Semenko");
        assertEquals(player.toString(), searched.toString());
    }

    @Test
    public void searchDoesntFindPlayer() {
        assertNull(stats.search("Jonne"));
    }

    @Test
    public void teamReturnsWantedTeam() {
        ArrayList<Player> teamSearched = (ArrayList) stats.team("PIT");
        Player player = stats.search("Lemieux");

        assertTrue(teamSearched.contains(player));
    }

    @Test
    public void topScorersReturnsRightAmount() {
        ArrayList<Player> topScorers = (ArrayList) stats.topScorers(3);
        Player player1 = stats.search("Gretzky");
        Player player2 = stats.search("Lemieux");
        Player player3 = stats.search("Yzerman");
        assertTrue(topScorers.contains(player1));
        assertTrue(topScorers.contains(player2));
        assertTrue(topScorers.contains(player3));
    }
}

