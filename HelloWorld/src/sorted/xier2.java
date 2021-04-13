package sorted;

import java.util.Arrays;

public class xier2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 4, 2, 1, 7, 5, 9, 8, 0, 10, 19, 15, 11, 6 };
		int[] step = new int[] { 5, 3, 1 };
		for (int i = 0; i < step.length; ++i) {
			for (int j = 0; j < step[i]; ++j) {
				insert(arr, j, step[i]);
			}
		}

		System.out.println(Arrays.toString(arr));
	}

	public static void insert(int[] arr, int index, int step) {
		int len = arr.length;
		for (int i = index + step; i < len; i = i + step) {
			int tmp = arr[i];
			int j = i - step;
			for (; j >= 0 && arr[j] > tmp; j -= step) {
				arr[j + step] = arr[j];
			}
			arr[j + step] = tmp;
			
//			int j = i - step;
//			while (j >= 0) {
//				if (arr[j] > tmp) {
//					arr[j + step] = arr[j];
//					j = j - step;
//				} else {
//					break;
//				}
//			}
//			arr[j + step] = tmp;
		}
	}

}
