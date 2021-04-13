package sorted;

import java.util.Arrays;

public class TwoSort {
	static int num = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 6, 5, 4, 3, 2, 1};
//		processSort(arr, 0, arr.length - 1);
		processSort2(arr, arr.length);
		System.out.println(Arrays.toString(arr));
		System.out.println(num);
		
		// 6 5 4
		// 		6 5 -> 1
		//				6 ->0
		//				5 ->0
		//		4		->0
		
		//      5 6 4
		//      i   j
		//      mid - i + 1 = 1 - 0 + 1 = 2
		
		// 3 2 1
	}

	// 0 1 4 3
	public static void processSort(int arr[], int start, int end) {
		if (start == end) {
			return;
		}
		int mid = (start + end) / 2;
		processSort(arr, start, mid);
		processSort(arr, mid + 1, end);
		merge2(arr, start, mid, end);
		// 4 -> 2 ->1
	}
	
	public static void processSort2(int[] arr, int len) {
		// step: 1 -> 2 -> 4 -> 8
		// len: 6 / 2 = 3
		for (int step = 1; step < len; step *= 2) {
			int idx = 0;
			while (idx < len) {
				// step : 2, idx : 0
				// [[0, 1], [2, 3]] 
				// [4, 5,] [6,7]
				// start: idx
				// mid: idx + step - 1
				// end: idx + step * 2 - 1
				int start = idx;
				int mid = idx + step - 1;
				int end = idx + step * 2 - 1;
				if (end >= len) {
					end = len - 1;
				}
				merge2(arr, start, mid, end);
				idx = end + 1;
			}
		}
	}
	
	private static void merge2(int[] arr, int start, int mid, int end) {
		int len = end - start + 1;
		int[] temp = new int[len];
		int i = start, j = mid + 1;
		int k = 0;
		
		// 4, 5
		// 2, 3
		
		// 2 3 4 5
		while (i <= mid && j <= end) {
			if (arr[i] > arr[j]) {
				temp[k] = arr[j];
				++j;
				num += (mid - i + 1);
			} else {
				temp[k] = arr[i];
				++i;
			}
			++k;
		}
		while (i <= mid) {
			temp[k] = arr[i];
			++i;
			++k;
			
//			num += (end - mid + 1);
		}
		
		while (j <= end) {
			temp[k] = arr[j];
			++j;
			++k;
		}
		for (i = 0; i < len; ++i) {
			arr[start + i] = temp[i];
		}

	}

	private static void merge(int[] arr, int start, int mid, int end) {
		//System.out.println("arr" + Arrays.toString(arr) + "start:" + start + "mid:" + mid + "end:" + end); 
		// start:0 mid:2 end:4
		int len = end - start + 1;
		int[] temp = new int[len];
		int i = start, j = mid + 1;
		int k = 0;
		while (i <= mid && j <= end) {
			if (arr[i] > arr[j]) {
				temp[k] = arr[j];
				++j;
			} else {
				temp[k] = arr[i];
				++i;
			}
			++k;
		}
		while (i <= mid) {
			temp[k] = arr[i];
			++i;
			++k;
		}
		while (j <= end) {
			temp[k] = arr[j];
			++j;
			++k;
		}
		System.out.println("===" + Arrays.toString(temp));
//		System.out.println("---" + Arrays.toString(arr));

//		for (i = 0; i < len; ++i) {
//			arr[start + i] = temp[i];
//		}
//		
		arr = temp;

	}

}
