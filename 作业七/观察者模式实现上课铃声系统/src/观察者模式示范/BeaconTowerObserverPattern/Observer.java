package BeaconTowerObserverPattern;;


public interface Observer {
	abstract public void enterBeaconTower(Observable beaconTower);
	abstract public void leaveBeaconTower(Observable beaconTower);
	abstract public void update();
}
