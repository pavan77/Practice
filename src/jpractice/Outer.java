package jpractice;

public class Outer {

	int i = 0;

	class Inner {
		Inner() {
			i = i + 1;
		}
	}

	int get() {
		Inner inner = new Inner();

		return i;
	}

}
