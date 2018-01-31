package elevator;

import java.util.ArrayList;

import elevatorsystem.ElevatorPanel;
import elevatorsystem.ElevatorSystemImp;

public class ElevatorImp implements Elevator {

	private ArrayList<Integer> passengers;
	private int currFloor,destFloor;
	private int maxCapacity;
	private ElevatorSystemImp panel;
	private MovingState state;
	
	public ElevatorImp(int capactiy, ElevatorPanel system) {
		this.maxCapacity = capactiy;
		this.panel = (ElevatorSystemImp) system;
	}

	@Override
	public int getCapacity() {
		return maxCapacity;
	}

	@Override
	public boolean isFull() {
		if(passengers.size() == getCapacity()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		return passengers.isEmpty();
	}

	@Override
	public MovingState getState() {
		return state;
	}

	@Override
	public double getPowerConsumed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void moveTo(int floor) {
		this.currFloor = floor;
	}

	@Override
	public int getFloor() {
		return currFloor;
	}

	@Override
	public void addPersons(int persons) {
		for(int i =0; i < persons; i++) {
			passengers.add(i);
		}
	}

	@Override
	public void requestStop(int floor) {
		if(floor < panel.getMaxFloor() || floor > panel.getMaxFloor()) {
			destFloor = floor;
		}
		
	}

}
