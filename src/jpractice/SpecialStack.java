package jpractice;

public class SpecialStack {
	
	int[] arr;
	int maxIndex;
	int lastIndex = -1;
	
	SpecialStack(){
		arr = new int[10];
	}
	
	void push(int i) {
		arr[++lastIndex] = i;
		if(i > arr[maxIndex]) {
			maxIndex = lastIndex;
		}
	}
	
/*	int pop() {
		int val =  arr[lastIndex];
		if(maxIndex == lastIndex) {
			//
		}
	}*/
	
	private int getMax()  {
			return arr[maxIndex];
	}

}
