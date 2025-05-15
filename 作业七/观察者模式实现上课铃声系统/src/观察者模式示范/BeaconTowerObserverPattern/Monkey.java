package BeaconTowerObserverPattern;;

public class Monkey implements Observer{
	private String name;
	private Observable observable;
	public Monkey(String name, Observable observable) {
		super();
		this.name = name;
		this.observable = observable;
		this.observable.attach(this);
	}
	public Monkey(String name) {
		super();
		this.name = name;
	}
	@Override
	public void enterBeaconTower(Observable beaconTower) {
	
		beaconTower.attach(this);
	}
	@Override
	public void leaveBeaconTower(Observable beaconTower) {
		beaconTower.detach(this);
	}
	@Override
	public void update() {
	
		System.out.println("吱吱吱");
	}
}
