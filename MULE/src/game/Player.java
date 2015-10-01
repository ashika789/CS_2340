package game;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by yamininambiar on 9/21/15.
 */
public class Player {

    private Location loc;
    private ArrayList<Location> properties;
    private String name;
    private String type; //"Human", "AI", "Not playing"
    private String race; //"Human", "Flapper", "Bonzoid", "Ugaite", "Buzzite"

    private double food;
    private double energy;
    private double crystite;
    private double smithore;
    private int mule;
    private int playerNumber;
    private int money;



    private int score;

    //default ctor
    //default ctor's playerNumber is 0. Not sure why we even need a default character
    public Player() {
        new Player(new Location(0,0), new ArrayList<>(),"Colonel Robert Waters", "Human", "Human", 0);
    }

    //all variables assigned ctor
    public Player(Location loc, ArrayList<Location> properties, String name, String type, String race, int playerNumber) {
        if (type == "Not playing") {
            return;
        }
        this.loc = loc;
        this.properties = properties;
        this.name = name;
        this.type = type;
        this.race = race;
        this.playerNumber = playerNumber;
        food = 0;
        energy = 0;
        crystite = 0;
        smithore = 0;
        mule = 0;
        money = 1000;
        if (race == "Flapper") {
            money = 1600;
        } else if (race == "Human") {
            money = 600;
        }


    }

    //this should be the only the ctor we really need
    public Player(String name, String type, String race, int playerNumber) {
        this.name = name;
        this.type = type;
        this.race = race;
        this.playerNumber = playerNumber;
        properties = new ArrayList<>();
        loc = new Location(0,0);
        food = 0;
        energy = 0;
        crystite = 0;
        smithore = 0;
        mule = 0;
        if (race == "Flapper") {
            money = 1600;
        } else if (race == "Human") {
            money = 600;
        }

        score = 0;
    }

    /* PlayerComparator class definition*/
    public static class PlayerComparator<Object> implements Comparator<Player> {
        @Override
        //sorts based on money, from greatest to least
        public int compare(Player a, Player b) {
            return a.getScore() - b.getScore();
        }
    }



    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getRace() {
        return race;
    }

    public void addFood(double x) {
        food += x;
    }

    public double getFood() {
        return food;
    }

    public void addEnergy(double x) {
        energy += x;
    }

    public double getEnergy() {
        return energy;
    }

    public void addCrystite(double x) {
        crystite += x;
    }

    public double getCrystite() {
        return crystite;
    }

    public void addMule(int x) {
        mule += x;
    }

    public double getMule() {
        return mule;
    }

    public void addSmithore(double x) {
        smithore += x;
    }

    public double getSmithore() {
        return smithore;
    }

    public int getPlayerNumber() {return playerNumber;}

    public void addProperty(Location loc) {
        properties.add(loc);
    }

    public int getMoney() { return money; }

    public void addMoney(int m) { money += m; }

    public int getScore() {;
        score += getMoney() + properties.size() * 1500 + getEnergy() * 25 + getFood() *30 + getSmithore() * 50 + getMule() * 100 ;
        return score;
    }

    public void setScore(int score) { this.score = score; }


    /*1 point per dollar of money
    500 points for each plot of land owned
    1 point per dollar value of goods (energy, food, ore)*/

}
