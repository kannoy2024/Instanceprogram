public class CargoBoat {
    int realContent;
    int maxContent;
    public void setMaxContent(int maxContent) {
        this.maxContent = maxContent;
    }
    public void loading(int m ) throws DangerException{
        realContent += m;
        if(realContent > maxContent)
            throw new DangerException();
    }
}
