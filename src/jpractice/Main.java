package jpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import guice.GuiceTest;
import scala.collection.immutable.HashSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * GFG helper = new GFG(); int newNumber = new GFG().replaceZeros(10209, 5);
		 * System.out.println(newNumber); int[] priceArray = { 2, 3, 5, 1, 4 }; int
		 * maxSellPrice = helper.maxSellPrice(priceArray, 0, 4, 1);
		 * 
		 * System.out.println(maxSellPrice);
		 * 
		 * int[] a = { 0, 10, 1, 2, 0, 4, 3, 0, 5, 0 }; helper.moveZerosToEnd(a); int[]
		 * a2 = { 2, 2, 2, 2, 3, 4, 5, 5 }; int index = helper.getFirstIndex(a2, 5);
		 * System.out.println("first index " + index);
		 * 
		 * CallByValue cbv = new CallByValue();
		 * 
		 * cbv.test();
		 * 
		 * HashMap<Integer, String> map = new HashMap<>();
		 * 
		 * map.put(1, "pavan"); map.put(2, "pavan"); ImmutableObject iObj = new
		 * ImmutableObject(10, map);
		 * 
		 * System.out.println("ImmutableObject map is " + iObj.getMap()); map.put(3,
		 * "pavan"); System.out.println("ImmutableObject map after modification is " +
		 * iObj.getMap());
		 */

		// testCollections();

		// testDP();

		// testCloning();
		// testCollections();
		// testHashMap();

		GFG helper = new GFG();
		/*
		 * ArrayList<String> l = helper.waysToClimb(5, 3, 0, ""); for(String s : l) {
		 * System.out.println(s); } System.out.println(l.size());
		 * System.out.println(helper.solve(5, 3));
		 * System.out.println(helper.countWaysUtil(5, 3));
		 */

		// helper.getUnlimitedCombinations2("abcd", "", 3, 0);
		// helper.getLimitedCombinations("abcd", "", 3, 0);

		/*ArrayList<ArrayList<Integer>> caps = new ArrayList<>();

		Integer[] zeroCaps = { 5, 100, 1 };
		Integer[] oneCaps = { 2 };
		Integer[] twoCaps = { 5, 100 };

		caps.add(new ArrayList<Integer>((Arrays.asList(zeroCaps))));
		caps.add(new ArrayList<Integer>((Arrays.asList(oneCaps))));
		caps.add(new ArrayList<Integer>((Arrays.asList(twoCaps))));
		// System.out.println(helper.getCapCombinations(caps, 0, new
		// ArrayList<Integer>()));

		int[] a = { 8, 1, 9, 3, 4 };

		System.out.println(helper.totCount(a, 0));

		// System.out.println(helper.lis(a, 0, new ArrayList<Integer>()));

		String[] colors = { "c1", "c2", "c3", "c4" };

		// int[] a2 = { 3000, 2000, 1000, 3, 10 };
		//
		// System.out.println(helper.maxSubSequenceSum(-1, -1, 0, a2));

		int[] arr = { 1, 2, 3, 4 };
		// System.out.println("arr " + helper.sumOfMaxDifference(arr));

		System.out.println("nthPermutation " + helper.nthPermutation("abcd", 23));*/

		// System.out.println(helper.paintPosts(colors, 3, 0, new ArrayList()));

		/*
		 * int[] a = { 2, 3, 5 }; int amount = 15; int[][] mem = new
		 * int[a.length][amount]; for (int i = 0; i < a.length; i++) { for (int j = 0; j
		 * < amount; j++) { mem[i][j] = -1; } } System.out.println(helper.coinChange(a,
		 * amount, 0, 0, "", mem));
		 * 
		 * for (int i = 0; i < a.length; i++) { for (int j = 0; j < amount; j++) {
		 * System.out.print(mem[i][j]+"   "); } System.out.println(); }
		 */

		// testConsole();

		/*
		 * int i = (int) Double.POSITIVE_INFINITY;
		 * 
		 * System.out.println(i + 1); System.out.println(Double.POSITIVE_INFINITY);
		 */

		// System.out.println(helper.seqCount(1, 1, 5, 2));

		// testHashMap();

		// testConsole();

		/*int[] histograms = { 6, 2, 5, 4, 5, 1, 600 };
		System.out.println(helper.maxArea(histograms));*/
		
		//testReflection();
		
		testGuice();

	}

	static void testCollections() {

		ConcurrentCollections c = new ConcurrentCollections();

		c.testCopyOnWriteAList();

	}

	static void testHashMap() {
		HashMap<Object, Integer> m = new HashMap<>();

		Car c1 = new Car("red");
		Car c2 = new Car("red");
		m.put(c1, 1);
		m.put(c2, 2);

		HashMap<Integer, Integer> newmap = new HashMap<>();

		// populate hash map
		newmap.put(1, 5);
		newmap.put(2, 2);
		newmap.put(3, 3);

		// create set view for the map
		Iterator<Entry<Integer, Integer>> it = newmap.entrySet().iterator();

		while (it.hasNext()) {
			Entry<Integer, Integer> en = it.next();
			int value = en.getValue();
			if (value % 2 == 1)
				System.out.println("Set values: " + en.getKey());
		}

		// System.out.println(m.keySet().size());

	}

	static void testDP() {

		GFG helper = new GFG();

		String[][] arr = new String[8][7];

		String lcs = helper.lcs(0, 0, arr, "ABCDGH", "AEDFHR");

		System.out.println("LCS is " + lcs);

	}

	static void test() {

		List<Integer> l = new ArrayList<>();
	}

	static void testCloning() {
		ImmutableObject obj = new ImmutableObject();
		obj.testCloning();
	}

	static void testConsole() {
		Scanner s = new Scanner(System.in);

		int cases = s.nextInt();
		System.out.print("cases " + cases);
		while (cases > 0) {
			int length = s.nextInt();
			int[] arr = new int[length];
			for (int i = 0; i < length; i++) {
				arr[i] = s.nextInt();
			}

			for (int i : arr) {
				System.out.print(i + "  ");
			}
			System.out.println();

			cases = cases - 1;
		}
	}

	class A {
		int f() {
			return 2;
		}
	}

	class B extends A {
		public int f() {
			return 3;
		}
	}

	static class Car {
		String color;

		Car(String c) {
			this.color = c;
		}

		public int hashCode() {
			return 1;
		}

		public boolean equals(Object o) {
			Car c = (Car) o;
			return this.color == c.color;
		}

	}

	static void testReflection() {
		try {
			CallByValue c = (CallByValue) Class.forName("jpractice.CallByValue").newInstance();
			Class<CallByValue> c2 = CallByValue.class;
			System.out.println("i is " + c.i);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	static void testGuice(){
		GuiceTest test = new GuiceTest();
		test.test();
	}

}
