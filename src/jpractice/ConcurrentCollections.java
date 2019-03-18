package jpractice;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentCollections {

	void testCopyOnWriteAList() {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		Iterator<Integer> i = a.iterator();
		while (i.hasNext()) {
			int val = i.next();
			System.out.println(val);
			if (val % 3 == 0) {
				a.add(9);
			}
		}
	}

	<T> void copyArray(Object[] arr) {
		
		
		Object[] newArray = new Object[arr.length];
		for (int i = 0; i < arr.length - 1; i++) {
			newArray[i] = arr[i];
		}

	}

}
