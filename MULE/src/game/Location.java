package game;
import java.util.Random;

/**
 * Created by yamininambiar on 9/22/15.
 */
public class Location {

    int x;
    int y;
    int buyingPrice;
    int sellingPrice;
    boolean available;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(int buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        Random r = new Random();
        buyingPrice = 300 + Driver.getRoundNumber() * r.nextInt(100); //300 + round * random(0-100)
        sellingPrice = 400 + r.nextInt(200); // 400 + random(0-200)
        available = true;
    }
}
