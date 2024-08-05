package practiceCar;

public class CarTest {
	public static void main(String[] args) {
		// 객체생성
		Car hudson = new Car(300);
		Car carrena = new Car(200);
		Car mater = new Car(80);
		// 각 객체의 이름과 스피드 출력
		hudson.setName("Hudson");
		carrena.setName("Carrena");
		mater.setName("Mater");
		System.out.println("> Car 1 : " + hudson.name + " | " + hudson.getSpeed() + "km/h");
		System.out.println("> Car 2 : " + carrena.name + " | " + carrena.getSpeed() + "km/h");
		System.out.println("> Car 3 : " + mater.name + " | " + mater.getSpeed() + "km/h");
	} //main
} //end

class Car {
	String name;
	int speed;

	Car(int speed) {
		this.speed = speed;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
} //Car