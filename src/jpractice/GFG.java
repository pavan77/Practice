package jpractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GFG {

	ArrayList<Integer> a = new ArrayList<>();

	ArrayList<?> wa = new ArrayList<>();

	Class<?> c = a.getClass();

	StringFilterable s = new StringFilterable();
	boolean b = s.filter("a");

	TypeFilterable<String> t = new TypeFilterable<>();
	boolean b2 = t.filter("a");

	TypeFilterable<Integer> t2 = new TypeFilterable<>();
	boolean b3 = t2.filter(100);

	GFG() {
		// wa.add(new Integer(1));
	}

	int replaceZeros(int number, int substitutor) {
		int n = number;
		int p = 0;
		int newNumber = 0;

		while (n > 0) {
			int r = n % 10;
			if (r == 0)
				newNumber = newNumber + (int) (substitutor * Math.pow(10, p));
			else
				newNumber = newNumber + (int) (r * Math.pow(10, p));
			n = n / 10;
			p = p + 1;
		}

		return newNumber;
	}

	int differentWays(int n) {
		if (n < 0)
			return 0;
		else if (n == 0)
			return 1;
		else
			return differentWays(n - 1) + differentWays(n - 3) + differentWays(n - 4);

	}

	int maxSellPrice(int[] p, int s, int e, int y) {

		if (s > e)
			return 0;
		else if (s == e)
			return y * p[s];
		else {
			return Math.max(y * p[s] + maxSellPrice(p, s + 1, e, y + 1), maxSellPrice(p, s, e - 1, y + 1) + y * p[e]);
		}

	}

	void moveZerosToEnd(int[] a) {
		int i = 0;
		int j = 0;
		while (true) {
			while (i <= a.length - 1 && a[i] == 0) {
				i = i + 1;
			}
			while (j <= a.length - 1 && a[j] != 0) {
				j = j + 1;
			}
			if (i > a.length - 1 || j > a.length - 1) {
				break;
			} else {
				if (i > j) {
					int temp = a[j];
					a[j] = a[i];
					a[i] = temp;
					j++;
					i++;
				} else {
					i = j + 1;
				}
			}

		}
		for (int k = 0; k < a.length; k++)
			System.out.print(a[k] + " ");
	}

	int getFirstIndex(int[] a, int key) {
		int l = 0;
		int r = a.length - 1;
		int index = -1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (a[mid] == key) {
				index = mid;
				r = mid - 1;
				if (r < 0 || a[r] < a[mid]) {
					break;
				}
			} else if (a[mid] < key) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return index;
	}

	String lcs(int i, int j, String[][] arr, String s1, String s2) {
		if (i > s1.length() - 1 || j > s2.length() - 1)
			return "";
		if (arr[i][j] != null)
			return arr[i][j];
		char curChar = s1.charAt(i);
		int p = s2.substring(j).indexOf(curChar);
		if (p == -1) {
			arr[i][j] = lcs(i + 1, j, arr, s1, s2);
		} else {
			String v1 = lcs(i + 1, j, arr, s1, s2);
			String v2 = curChar + lcs(i + 1, p + 1, arr, s1, s2);
			if (v1.length() > v2.length()) {
				arr[i][j] = v1;
			} else {
				arr[i][j] = v2;
			}
		}
		return arr[i][j];

	}

	/*
	 * int sqrt(int num) { int result = -1; int i = 1; while (i * i <= num) { result
	 * = i; i++; }
	 * 
	 * }
	 */

	/*
	 * int mthRoot(int num, int m) { int result = -1;
	 * 
	 * int i = 1; int ans = 1;
	 * 
	 * for()
	 * 
	 * int k }
	 */

	int power(int a, int p) {
		int i = 1;
		int result = 1;
		while (i <= p) {
			result = result * a;
			i++;
		}

		return result;

	}
	// (())()((()))
	/*
	 * int longestBalancedParantheses(String s) { int result = -1; int prevZeroEnd =
	 * -1; int prevZeroSize = 0; int curStart = 0; int curSum = 0;
	 * 
	 * for (int i = 0; i < s.length() && curStart < s.length(); i++) { if
	 * (s.charAt(i) == '(') { curSum++;
	 * 
	 * } else { curSum--; }
	 * 
	 * if (curSum == 0) { int newSize = i - curStart + 1; if (prevZeroEnd != -1 &&
	 * curStart == prevZeroEnd + 1) { newSize = prevZeroSize + newSize; } if
	 * (newSize > result) { result = newSize; } prevZeroEnd = i; prevZeroSize =
	 * newSize; curStart = i + 1; } else if (curSum < 0) { { prevZeroEnd = -1;
	 * prevZeroSize = 0; curStart = i + 1; curSum=0; }
	 * 
	 * }
	 * 
	 * } return result;
	 * 
	 * }
	 */

	// 1222335
	int getMinSum(int[] a) {

		int prev = a[0];
		int sum = prev;
		for (int i = 1; i < a.length; i++) {
			if (a[i] <= prev) {
				a[i] = prev + 1;
			}
			prev = a[i];
			sum += prev;
		}
		return sum;
	}

	ArrayList<String> waysToClimb(int total, int maxLeap, int i, String path) {
		if (total == i) {
			ArrayList<String> l = new ArrayList<>();
			l.add(path);
			return l;
		} else if (i > total) {
			return new ArrayList<>();
		} else {
			ArrayList<String> list = new ArrayList<>();
			for (int k = 1; k <= maxLeap; k++) {
				// count += waysToClimb(total, maxLeap, k + i);
				ArrayList<String> sub = waysToClimb(total, maxLeap, k + i, path + k + ",");
				for (String s : sub) {
					list.add(s);
				}
			}
			return list;

		}
	}

	static int solve(int N, int K) {

		// elements of combo[] stores
		// the no. of possible ways
		// to reach it by all combinations
		// of k leaps or less
		int[] combo;
		combo = new int[50];

		// assuming leap 0 exist
		// and assigning its value
		// to 1 for calculation
		combo[0] = 1;

		// loop to iterate over all
		// possible leaps upto k;
		for (int i = 1; i <= K; i++) {

			// in this loop we count all
			// possible leaps to reach
			// the jth stair with the
			// help of ith leap or less
			for (int j = 0; j <= N; j++) {

				// if the leap is not
				// more than the i-j
				if (j >= i) {

					// calculate the value and
					// store in combo[j] to
					// reuse it for next leap
					// calculation for the
					// jth stair
					combo[j] += combo[j - i];
				}
			}
		}

		// returns the no of possible
		// number of leaps to reach
		// the top of building of
		// n stairs
		return combo[N];
	}

	static int countWaysUtil(int n, int m) {
		int res[] = new int[n];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i < n; i++) {
			res[i] = 0;
			for (int j = 1; j <= m && j <= i; j++)
				res[i] += res[i - j];
		}
		return res[n - 1];
	}

	/*
	 * int minProdSubset(int[] a) { int[] subA = new int[a.length +1]; int prod =
	 * a[0]; subA[0] = 1; for(int i=1;i<=a.length;i++) { prod = prod*a[i]; subA[i] =
	 * prod; }
	 * 
	 * }
	 */

	/*
	 * int getUnlimitedCombinations(String members, String path, int k, int pos) {
	 * if (path.length() == k) { System.out.println(path); return 1; } else if
	 * (path.length() > k || pos >= members.length()) return 0; else { int t = 0;
	 * String p = ""; for (int i = 0; i <= k - path.length(); i++) { if (i != 0) { p
	 * = p + members.charAt(pos); } else p = ""; t = t +
	 * getUnlimitedCombinations(members, path + p, k, pos + 1); } return t; }
	 * 
	 * }
	 */

	int getUnlimitedCombinations2(String members, String path, int k, int pos) {
		if (path.length() == k) {
			System.out.println(path);
			return 1;
		} else if (path.length() > k || pos >= members.length())
			return 0;
		else {
			int t = 0;
			t = getUnlimitedCombinations2(members, path, k, pos + 1)
					+ getUnlimitedCombinations2(members, path + members.charAt(pos), k, pos);
			return t;
		}

	}

	int getLimitedCombinations(String members, String path, int k, int pos) {
		if (path.length() == k) {
			System.out.println(path);
			return 1;
		} else if (path.length() > k || pos >= members.length())
			return 0;
		else {
			int t = 0;
			t = getLimitedCombinations(members, path, k, pos + 1)
					+ getLimitedCombinations(members, path + members.charAt(pos), k, pos + 1);
			return t;
		}

	}

	// order doesnt matter
	int coinChange(int[] a, int amount, int collection, int i, String path, int[][] mem) {
		if (amount == collection) {
			System.out.println(path);
			return 1;
		} else if (collection > amount || i >= a.length) {
			return 0;
		} else if (mem[i][collection] != -1) {
			return mem[i][collection];
		} else {
			int ways = 0;
			boolean isFirst = true;
			int count = 0;
			while (count < amount) {
				if (isFirst) {
					isFirst = false;
				} else {
					count += a[i];
					path = path + "," + a[i];
				}
				ways = ways + coinChange(a, amount, collection + count, i + 1, path, mem);
			}
			mem[i][collection] = ways;

			return ways;
		}

	}

	int getCapCombinations(ArrayList<ArrayList<Integer>> capCollection, int person, ArrayList<Integer> capsTaken) {
		System.out.println(person + "     ");
		for (int p : capsTaken) {
			System.out.print(p + ",");
		}
		System.out.println();
		if (capsTaken.size() == capCollection.size()) {
			return 1;
		} else if (person >= capCollection.size()) {
			return 0;
		} else {
			int ways = 0;
			for (int i = 0; i < capCollection.get(person).size(); i++) {
				int cap = capCollection.get(person).get(i);
				if (!capsTaken.contains(cap)) {
					ArrayList<Integer> a = (ArrayList<Integer>) capsTaken.clone();
					a.add(cap);
					ways += getCapCombinations(capCollection, person + 1, a);
				}
			}
			return ways;
		}

	}

	/*
	 * int maxSurvivalTime(int[] x,int[]y,int[]z,int aPower,int bPower) {
	 * 
	 * }
	 */

	int powersetSum(int[] ele, int sum, int i) {
		if (i >= ele.length)
			return sum;
		else
			return powersetSum(ele, sum + ele[i], i + 1) + powersetSum(ele, sum, i + 1);
	}

	int powersetSum2(int[] ele, int i) {
		if (i >= ele.length)
			return 0;
		else
			return ele[i] + powersetSum2(ele, i + 1) + powersetSum2(ele, i + 1);
	}

	int paintPosts(String[] paints, int postCount, int post, ArrayList<String> paintedColors) {

		System.out.print("Painting post  " + post + "   ");
		for (String s : paintedColors) {
			System.out.print(s + ",");
		}
		System.out.println();

		if (paintedColors.size() == postCount) {
			// for (String s : paintedColors) {
			// System.out.print(s + ",");
			// }
			// System.out.println();
			return 1;
		} else if (post > postCount) {
			return 0;
		} else {

			int ways = 0;
			for (int i = 0; i < paints.length; i++) {

				ArrayList<String> clone = (ArrayList<String>) paintedColors.clone();

				if (clone.size() < 2 || !clone.get(clone.size() - 1).contentEquals(clone.get(clone.size() - 2))
						|| !clone.get(clone.size() - 1).contentEquals(paints[i])) {
					clone.add(paints[i]);
					ways = ways + paintPosts(paints, postCount, post + 1, clone);
				}
			}
			return ways;
		}

	}

	int lis(int[] a, int pos, ArrayList<Integer> arr, int[] mem) {
		if (arr.size() >= 2 && arr.get(arr.size() - 1) < arr.get(arr.size() - 2)) {
			return 0;
		} else if (pos >= a.length) {
			for (Integer s : arr) {
				System.out.print(s + ",");
			}
			System.out.println();
			return arr.size();
		} else if (mem[pos] != -1) {
			return mem[pos];
		}
		ArrayList<Integer> clone = (ArrayList<Integer>) arr.clone();
		clone.add(a[pos]);
		mem[pos] = Math.max(lis(a, pos + 1, clone, mem), lis(a, pos + 1, arr, mem));
		return mem[pos];
	}

	int allAPs(int[] arr, int pos, Integer cd, Integer le) {

		if (pos > arr.length)
			return 0;
		if (pos == arr.length)
			return 1;
		if (cd == null && le == null) {
			return allAPs(arr, pos + 1, cd, arr[pos]) + allAPs(arr, pos + 1, cd, le);
		} else {
			if (le == null) {
				return 0;
			} else if (cd == null) {
				return allAPs(arr, pos + 1, arr[pos] - le, arr[pos]) + allAPs(arr, pos + 1, cd, le);
			} else {
				if (arr[pos] - le == cd) {
					return allAPs(arr, pos + 1, cd, arr[pos]) + allAPs(arr, pos + 1, null, arr[pos]);
				} else {
					return allAPs(arr, pos + 1, cd, le);
				}

			}

		}

	}

	int seqCount(int le, int c, int m, int n) {
		if (le > m)
			return 0;
		if (c == n) {
			return 1;
		}
		int k = 0;
		int temp = 0;
		while (le * 2 + k <= m) {
			temp = temp + seqCount(le * 2 + k, c + 1, m, n);
			k++;
		}
		return temp;
	}

	// increasing subsequence count
	int totCount(int[] a, int curIndex) {
		if (curIndex == a.length - 1)
			return 1;
		int count = 1;
		for (int i = curIndex + 1; i < a.length; i++) {
			if (a[i] > a[curIndex]) {
				count = count + totCount(a, i);
			}
		}
		return count;
	}

	int maxSubSequenceSum(int lastTwo, int lastOne, int current, int[] a) {

		if (lastOne - lastTwo == 1 && current - lastOne == 1)
			return 0;
		if (current == a.length - 1)
			return a[current];
		int sum = 0;
		int max = -1;
		for (int i = current + 1; i < a.length; i++) {
			sum = a[current] + maxSubSequenceSum(lastOne, current, i, a);
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

	int sequenceWithZeroOneDiff(int[] a, int index) {

		if (index == a.length - 1)
			return 1;
		int max = 0;
		int len = 1;
		for (int i = index + 1; i < a.length; i++) {
			if (Math.abs(a[i] - a[index]) <= 1)
				len = 1 + sequenceWithZeroOneDiff(a, i);
			if (len > max) {
				max = len;
			}
		}

		return max;
	}

	int maxDivisibleSequence(int[] a, int index, int maxIndex) {

		if (index == 0)
			return 1;
		int max = 0;
		int len = 1;
		for (int i = index - 1; i >= 0; i--) {
			if (a[i] % a[maxIndex] == 0 || a[maxIndex] % a[i] == 0) {
				int newIndex = 0;
				if (a[i] > a[maxIndex]) {
					newIndex = i;
				} else {
					newIndex = maxIndex;
				}
				len = 1 + maxDivisibleSequence(a, i, newIndex);
			}
			if (len > max) {
				max = len;
			}
		}

		return max;
	}

	int sumOfMaxDifference(int[] a) {

		int total = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				total += Math.pow(2, j - i - 1) * (a[j] - a[i]);
			}
		}

		return total;

	}

	private String reverse(String ori) {
		String res = "";
		for (int i = ori.length() - 1; i >= 0; i--) {
			res = res + ori.charAt(i);
		}
		return res;
	}

	private int factorial(int n) {

		int answer = 1;

		while (n >= 2) {
			answer = answer * n;
			n--;
		}
		return answer;
	}

	// lexicographical permutation
	String nthPermutation(String ori, int n) {
		System.out.println("nthPermutation " + ori + "  " + n);
		if (ori.length() == 1 || n == 0)
			return reverse(ori);

		int charPos = 0;
		int factorial = factorial(ori.length() - 1);
		if (n % factorial == 0) {
			charPos = n / factorial;
		} else {
			charPos = (int) Math.ceil((n + 0.0) / factorial);
		}
		String character = ori.charAt(charPos - 1) + "";
		return character + "" + nthPermutation(ori.replace(character, ""), n % factorial);

	}

	long maxArea(int[] a) {

		Stack<Integer> prevSmallStack = new Stack<>();
		int[] iArr = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			while (!prevSmallStack.isEmpty() && a[prevSmallStack.peek()] >= a[i]) {
				prevSmallStack.pop();

			}
			if (prevSmallStack.isEmpty()) {
				iArr[i] = -1;
			} else {
				iArr[i] = prevSmallStack.peek();
			}
			prevSmallStack.push(i);

		}
		Stack<Integer> nextSmallStack = new Stack<>();
		int[] jArr = new int[a.length];
		for (int j = a.length - 1; j >= 0; j--) {
			while (!nextSmallStack.isEmpty() && a[nextSmallStack.peek()] >= a[j]) {
				nextSmallStack.pop();

			}
			if (nextSmallStack.isEmpty()) {
				jArr[j] = -1;
			} else {
				jArr[j] = nextSmallStack.peek();
			}
			nextSmallStack.push(j);

		}
		long result = 0;
		for (int i = 0; i < a.length; i++) {
			long width = 0;
			if (iArr[i] < 0 && jArr[i] < 0) {
				width = a.length;
			} else if (iArr[i] < 0) {
				width = jArr[i];
			} else if (jArr[i] < 0) {
				width = a.length - iArr[i] - 1;
			} else {
				width = (jArr[i] - iArr[i] - 1);
			}
			result = Math.max(result, a[i] * width);
		}
		return result;

	}

	// 1 5 6 7 10 --4
	int getInsertPosition(int[] a, int key) {

		int l = 0;
		int r = a.length - 1;
		while (true) {
			int mid = (l + r) / 2;
			if (a[mid] > key) {
				if (mid == 0 || key >= a[mid - 1]) {
					return mid;
				}
				r = mid;

			} else if (a[mid] < key) {
				if (mid == a.length - 1) {
					return mid + 1;
				} else if (key <= a[mid + 1]) {
					return mid;
				}
				l = mid;

			} else {
				return mid;
			}

		}
	}

	/*
	 * int findPosition(int[] a, int key) { int l = 0; int r = a.length - 1; while
	 * (l <= r) { int mid = (l + r) / 2; if (key > a[mid]) { if (key > a[r]) { r =
	 * mid - 1; } else { l = mid + 1; }
	 * 
	 * } else if (key < a[mid]) { if (key > a[l]) { r = mid - 1; } else { l = mid +
	 * 1; }
	 * 
	 * } else { return mid; }
	 * 
	 * }
	 * 
	 * return -1; }
	 */

	int findPivot(int[] a, int key) {
		int l = 0;
		int r = a.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (a[mid] > a[r]) {
				l = mid;

			} else {
				r = mid;
			}

		}

		return l;
	}

	int findPosition(int[] a, int key) {
		int l = 0;
		int r = a.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (key > a[mid]) {
				if (key > a[r]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			} else if (key < a[mid]) {
				if (key > a[l]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}

			} else {
				return mid;
			}

		}

		return -1;
	}

}

interface Filterable<E> {

	boolean filter(E e);
}

class StringFilterable implements Filterable<String> {

	@Override
	public boolean filter(String e) {
		// TODO Auto-generated method stub
		return false;
	}

}

class TypeFilterable<T> implements Filterable<T> {

	static int i = 0;
	// static T t;

	@Override
	public boolean filter(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	String f(Object s) {
		return "object";
	}

	String f(String s) {
		return "string";
	}

	void generic(T t) {
		f(t);
	}

}



















/*
 * class GenericException<T> extends Exception { }
 */
