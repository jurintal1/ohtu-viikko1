/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author o
 */
public class StatisticsTest {
    
     Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
     
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  
    
    public StatisticsTest() {
    }
    
    
    
    @Test
    public void searchName() {
        assertEquals(90, stats.search("rri").getPoints());        
    }
    
    @Test
    public void noNamesFound() {
        assertEquals(null, stats.search("rintala"));        
    }
    
    
    
    @Test
    public void searchTeam() {
        List<Player> players = stats.team("EDM");
        assertEquals(3, players.size());        
    }
    
    @Test
    public void topScorers() {
        List<Player> players = stats.topScorers(2);
        assertEquals(54, players.get(1).getAssists());        
    }
    
       
    
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
