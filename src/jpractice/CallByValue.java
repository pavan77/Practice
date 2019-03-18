package jpractice;

import java.util.ArrayList;
import java.util.List;

public class CallByValue {

	int i = 100;

	CallByValue(String s) {

	}

	private void swap(Object o1, Object o2) {
		System.out.println("Swapping  " + o1 + "   " + o2);
		Object temp = o1;
		o1 = o2;
		o2 = temp;
	}

	private void makeNull(Object o1) {
		o1 = null;
	}

	class Box {
		String color;

		Box(String color) {
			this.color = color;
		}

		void changeColor(String newColor) {
			this.color = newColor;
		}
	}

	void test() {
		Box redBox = new Box("red");
		Box blueBox = new Box("blue");
		System.out.println("red box is" + redBox);
		/*
		 * System.out.println("blue box is" + blueBox); swap(redBox, blueBox);
		 */
		makeNull(redBox);
		System.out.println("red box after swap is" + redBox);
		// System.out.println("blue after swap is" + blueBox);
	}
}

interface Human {
	Object returnMe();
}

abstract class Human2 {
	abstract Object returnMe(Object a);
}

class Person extends Human2 {

	public String returnMe(Object a) {
		return "";
	}

	public String returnMe(String a) {
		return "";
	}
}

interface Movable {
	void move();

	void move2();
}

abstract class MovingAnimal implements Movable {
	public void move2() {
		System.out.println("MovingAnimal");
	}
}

class Leopard implements Movable {
	public void move() {

	}

	public void move2() {

	}
}

class Tiger extends MovingAnimal implements Movable {
	public void move() {
		move2();
	}

	void test() {
		List<Movable> l = new ArrayList<Movable>();

		l.add(this);
		l.add(new Leopard());

		List<Tiger> tigers = new ArrayList<Tiger>();

		WildCardTest w = new WildCardTest();
		w.print(l);

		w.print(tigers);
		
		List<?> l2 = new ArrayList<>();
//		l2.add(new Integer(1));

	}

	class WildCardTest {

		<T extends Movable> void print(List<T> l) {

		}

	}
}
