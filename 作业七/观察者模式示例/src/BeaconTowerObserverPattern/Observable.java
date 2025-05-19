package BeaconTowerObserverPattern;;


public abstract class Observable {
	private String state;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	abstract public void attach(Observer ob);
	abstract public void detach(Observer ob);
	abstract public void sendNotification();
}
