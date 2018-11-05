import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class HitsHandler implements Serializable {

    private double currentX = 0, currentY = 0, currentR = 1;
    private  Checkable areaChecker;
    private ArrayList<Hit> history;
    private double hiddenX = -10;
    private double tempHiddenX = 0;

    public HitsHandler() {
        areaChecker = new Variant18003AreaChecker();
        history = new ArrayList<Hit>();
    }

    public double getCurrentX() {
        return currentX;
    }

    public void setCurrentX(double currentX) {
        this.currentX = currentX;
    }

    public double getCurrentY() {
        return currentY;
    }

    public void setCurrentY(double currentY) {
        this.currentY = currentY;
    }

    public double getCurrentR() {
        return currentR;
    }

    public void setCurrentR(double currentR) {
        if (tempHiddenX != -10) {
            history.add(new Hit(tempHiddenX,
                    currentY,
                    currentR,
                    areaChecker.Check(tempHiddenX, currentY, currentR),
                    new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(Calendar.getInstance().getTime())));
        }
        this.currentR = currentR;
    }

    public double getHiddenX() {
        return hiddenX;
    }

    public void setHiddenX(double hiddenX) {
        tempHiddenX = hiddenX;
        this.hiddenX = -10;
    }

    public ArrayList<Hit> getHistory() {
        return (ArrayList<Hit>) history.clone();
    }

    public String updateMainPage(){
        history.add(new Hit(currentX,
                            currentY,
                            currentR,
                            areaChecker.Check(currentX, currentY, currentR),
                            new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(Calendar.getInstance().getTime())));
        return "mainPage";
    }
}