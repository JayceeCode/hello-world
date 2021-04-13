/**
 * 
 */
package sorted;

import java.util.Arrays;

/**
 * @author Jaycee
 *
 */
public class QuickSort {

	/**
	 * 
	 */
	public QuickSort() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 7, 3, 1, 9, 5, 6, 0, 10 };
		// processIndex1(arr, 0, arr.length - 1);
		processOne(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void processIndex(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if (start > end)
			return;
		int i = start, j = end;
		int index = i;
		while (i < j) {
			while (arr[j] >= arr[index] && i < j) {
				--j;
			}
			while (arr[i] <= arr[index] && i < j) {
				++i;
			}
			if (i < j) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}

		if (i == j) {
			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}

		processIndex(arr, start, i - 1);
		processIndex(arr, i + 1, end);
	}

	private static void processIndex1(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		if (start > end)
			return;
		int i = start, j = end;
		int index = arr[i];
		while (i < j) {
			while (arr[j] >= index && i < j) {
				--j;
			}
			if (i < j) {
				arr[i] = arr[j];
			}
			while (arr[i] <= index && i < j) {
				++i;
			}

			if (i < j) {
				arr[j] = arr[i];
			}

		}

		if (i == j) {
			arr[i] = index;
		}

		processIndex(arr, start, i - 1);
		processIndex(arr, i + 1, end);
	}

	public static void processOne(int[] arr, int start, int end) {
		// [start, i] < tmp
		// (i, j] >= tmp
		// j 用于遍历数组的
		// tmp: 使用第一个左右tmp
		// 2,4,1,3
		// tmp: 3
		// i=0,j=1 2,4,1,3
		// i=0,j=2 2,1,4,3
		// i=1,j=3 2,1,4,3
		// i=1,j=4

		if (start >= end)
			return;
		int tmp = arr[start];
		int i = start, j = start + 1;
		for (; j <= end; ++j) {
			if (arr[j] >= tmp) {
				;
			} else {
				++i;
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
		}
		int t = arr[i];
		arr[i] = arr[start];
		arr[start] = t;

		processOne(arr, start, i - 1);
		processOne(arr, i + 1, end);
	}

}
