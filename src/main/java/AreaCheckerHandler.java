public class AreaCheckerHandler {
    private Checkable areaChecker;

    public AreaCheckerHandler() {
        areaChecker = new Variant18003AreaChecker();
    }

    public Checkable getAreaChecker() {
        return areaChecker;
    }

    public void setAreaChecker(Checkable areaChecker) {
        this.areaChecker = areaChecker;
    }
}
