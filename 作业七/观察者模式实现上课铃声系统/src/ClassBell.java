
//被观察者，发出指令
public class ClassBell extends Observable {
    private String bellState;

    public String getBellState() {
        return bellState;
    }

    public void setBellState(String bellState) {
        this.bellState = bellState;
        notifyObservers(bellState); // 发生状态变化后通知所有观察者
    }
}