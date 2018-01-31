package elevatorsystem;

import elevator.Elevator;

public class ElevatorSystemImp implements ElevatorSystem {
	private int minFloor, maxFloor;
	
	public ElevatorSystemImp(int minFloor, int maxFloor) {
		this.minFloor = minFloor;
		this.maxFloor= maxFloor;
	}

	@Override
	public int getFloorCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxFloor() {
		return maxFloor;
	}

	@Override
	public int getMinFloor() {
		return minFloor;
	}

	@Override
	public Elevator callUp(int floor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Elevator callDown(int floor) {
		return null;
	}

	@Override
	public int getCurrentFloor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPowerConsumed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addElevator(Elevator elevator) {
		// TODO Auto-generated method stub

	}


}
