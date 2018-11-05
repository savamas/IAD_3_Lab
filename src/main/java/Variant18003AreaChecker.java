public class Variant18003AreaChecker implements Checkable{
    public boolean Check(double x, double y, double r) {
        if (x > 0 && y > 0) return false;
        if (x <= 0 && y <= 0 && x*x + y*y <= r*r/4) return true;
        if (x <= 0 && y >= 0 && x >= -r && y <= r/2) return true;
        if (x >= 0 && y <= 0 && y >= 2*x - r) return true;
        return false;
    }
}