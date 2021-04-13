package sorted;

import java.util.Arrays;

public class xier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 2, 6, 4, 8, 0, 1 };
		new xier().process(arr);
		System.out.println(Arrays.toString(arr));
	}

	public void process(int[] arr) {
		int len = arr.length;
		int step = len / 2;
		while (step >= 1) {
			this.innerSort(arr, step);
			step /= 2;
		}
	}

	private void innerSort(int[] arr, int step) {
		int len = arr.length;
		for (int i = step; i < len; i += step) {
			int j = i - step;
			int tmp = arr[i];
			while (j >= 0) {
				if (arr[j] > tmp) {
					arr[j + step] = arr[j];
					j -= step;
				} else {
					break;
				}
			}
			arr[j + step] = tmp;
		}
	}

}
