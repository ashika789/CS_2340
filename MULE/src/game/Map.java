package game; /**
 * Created by yamininambiar on 9/22/15.
 */

import java.util.ArrayList;

public class Map {

    Location[][] grid;
    ArrayList<Player> players;

    public Map() {
        new Map(new Location[5][9],new ArrayList<Player>());
//        this.grid = new game.Location[5][9];
//        this.players = new ArrayList<game.Player>();
    }

    public Map(Location[][] grid, ArrayList<Player> players ) {
        this.grid = grid;
        this.players = players;

    }
}
