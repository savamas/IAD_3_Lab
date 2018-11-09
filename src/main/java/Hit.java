import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hit implements Cloneable{
    @Id @GeneratedValue
    private int Id;
    private double x, y, r;
    private boolean isInArea;
    private String hitTime;

    public Hit(double x, double y, double r, boolean isInArea, String hitTime) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isInArea = isInArea;
        this.hitTime = hitTime;
    }

    public Hit() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setInArea(boolean inArea) {
        isInArea = inArea;
    }

    public void setHitTime(String hitTime) {
        this.hitTime = hitTime;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean isInArea() {
        return isInArea;
    }

    public String getHitTime() {
        return hitTime;
    }
}