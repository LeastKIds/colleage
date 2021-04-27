package ch09;

public class AutoCar implements OperateCar{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("start()");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("stop()");
	}

	@Override
	public void setSpeed(int speed) {
		// TODO Auto-generated method stub
		System.out.println("setSpeed : " + speed);
	}

	@Override
	public void turn(int degree) {
		// TODO Auto-generated method stub
		System.out.println("degree : " + degree);
	}
	
}
