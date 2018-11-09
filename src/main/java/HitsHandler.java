import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class HitsHandler implements Serializable {

    private double currentX = 0, currentY = 0, currentR = 1, hiddenX = 0;
    private EntityManagerHandler entityManagerHandler;
    private AreaCheckerHandler areaCheckerHandler;
    private ArrayList<Hit> history;

    public HitsHandler() {
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
        Hit currentHit = new Hit(hiddenX,
                                 currentY,
                                 currentR,
                                 areaCheckerHandler.getAreaChecker().Check(hiddenX, currentY, currentR),
                                 new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss").format(Calendar.getInstance().getTime()));
        entityManagerHandler.getEntityManager().getTransaction().begin();
        entityManagerHandler.getEntityManager().persist(currentHit);
        entityManagerHandler.getEntityManager().getTransaction().commit();
        history.add(currentHit);
        this.currentR = currentR;
    }

    public double getHiddenX() {
        return hiddenX;
    }

    public void setHiddenX(double hiddenX) {
        this.hiddenX = hiddenX;
    }

    public void setEntityManagerHandler(EntityManagerHandler entityManagerHandler) {
        this.entityManagerHandler = entityManagerHandler;
    }

    public void setAreaCheckerHandler(AreaCheckerHandler areaCheckerHandler) {
        this.areaCheckerHandler = areaCheckerHandler;
    }

    public ArrayList<Hit> getHistory() {
        return (ArrayList<Hit>) history.clone();
    }

    public String updateMainPage(){
        return "mainPage";
    }
}