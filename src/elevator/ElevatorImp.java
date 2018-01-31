package elevator;

import java.util.ArrayList;

import elevatorsystem.ElevatorPanel;
import elevatorsystem.ElevatorSystemImp;

public class ElevatorImp implements Elevator {

	private final int POWER_START_STOP = 2;
	private final int CONTINUOUS = 1;
	private final long SLEEP_START_STOP = 50;
	private final long SLEEP_CONTINUOUS = 25;
	private double powerUsed;
	private double MAX_CAPACITY_PERSONS;
	private int currentFloor, capacity;
	private MovingState state;
	private ElevatorPanel panel;

	public ElevatorImp(double capactiy, ElevatorPanel system) {
		this.MAX_CAPACITY_PERSONS = capactiy;
		this.panel = system;
	}

	@Override
	public int getCapacity() {
		return capacity;
	}

	@Override
	public boolean isFull() {
		if (getCapacity() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return getCapacity() == 0;
	}

	@Override
	public MovingState getState() {
		return state;
	}

	@Override
	public double getPowerConsumed() {
		return powerUsed;
	}

	@Override
	public void moveTo(int floor) {
		int floorDelta = Math.abs(floor - currentFloor);
		powerUsed = calcPower(floorDelta);
		if (getState() == MovingState.Idle) {
			state = MovingState.SlowUp;
			floorDelta--;
			currentFloor = (floor > currentFloor) ? currentFloor++ : currentFloor--;
			state = MovingState.Up;
			while (floorDelta > 1) {
				currentFloor = (floor > currentFloor) ? currentFloor++ : currentFloor--;
			}
			state = MovingState.SlowDown;
			currentFloor = (floor > currentFloor) ? currentFloor++ : currentFloor--;
		} else {
			state = MovingState.Up;
			while (floorDelta > 1) {
				currentFloor = (floor > currentFloor) ? currentFloor++ : currentFloor--;

			}
			state = MovingState.SlowDown;
			currentFloor = (floor > currentFloor) ? currentFloor++ : currentFloor--;

		}
	}

	private double calcPower(int floorDelt) {
		double pUsed;
		if (getState() == MovingState.Idle) {
			pUsed += 2;
			while (floorDelt > 1) {
				pUsed++;
			}
			pUsedd += 2;
		} else {
			while (floorDelt > 1) {
				pUsed++;
			}
			pUsed += 2;
		}
		return pUsed;
	}

	@Override
	public int getFloor() {
		return currentFloor;
	}

	@Override
	public void addPersons(int persons) {
		capacity += persons;
	}

	@Override
	public void requestStop(int floor) {
		if (currentFloor == floor) {
			state = MovingState.Idle;
		}
	}

}
