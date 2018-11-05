public class Hit implements Cloneable{

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

    public double getX() {
        return x;
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