package BeaconTowerObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class BeaconTower extends Observable {
	private String state;
	private List<Observer> observers = new ArrayList<Observer>();// 范围的军队
	public void attach(Observer tp) {
		observers.add(tp);
	}
	public void detach(Observer tp) {
		observers.remove(tp);
	}
	public void sendNotification() { // 通知军队
		System.out.println("\n烽火台状态改变，开始新一轮的通知：");
		for (Observer o : observers) {
			o.update();
		}
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
		sendNotification();
	}
}
