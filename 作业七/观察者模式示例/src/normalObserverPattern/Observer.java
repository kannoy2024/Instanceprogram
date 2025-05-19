package normalObserverPattern;

public abstract class Observer {
	public abstract void register(Observable ob);
	public abstract void unregister(Observable ob);
    public abstract void update();
}
