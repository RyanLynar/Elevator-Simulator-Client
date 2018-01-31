package elevatorsystem;

import elevator.Elevator;
import elevator.MovingState;

public class ElevatorSystemImp implements ElevatorSystem,ElevatorPanel {
	private int MAX_FLOOR;
	private int MIN_FLOOR;
	private Elevator elevator;
	public ElevatorSystemImp(int min,int max) {
		MAX_FLOOR = max;
		MIN_FLOOR = min;
	}
	
	@Override
	public int getFloorCount() {
		return MAX_FLOOR - MIN_FLOOR;
	}

	@Override
	public int getMaxFloor() {
		return MAX_FLOOR;
	}

	@Override
	public int getMinFloor() {
		return MIN_FLOOR;
	}
	@Override
	public Elevator callUp(int floor) {
		elevator.moveTo(floor);
		return elevator;
	}
	@Override
	public Elevator callDown(int floor) {
		elevator.moveTo(floor);
		return elevator;
	}
	@Override
	public int getCurrentFloor() {
		return elevator.getFloor();
	}

	@Override
	public double getPowerConsumed() {
		return elevator.getPowerConsumed();
	}

	@Override
	public void addElevator(Elevator elevator) {
		this.elevator = elevator;
	}

	@Override
	public void requestStop(int floor, Elevator elevator) {
		elevator.requestStop(floor);
	}


}
