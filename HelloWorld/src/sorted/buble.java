package sorted;

import java.util.Arrays;

/*
 * 1.冒泡排序算法
 * 实现降序排列
 * 
 */
public class buble {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {8,1,4,9,6,0,7};
		process(arr);
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void process(int[] arr) {
		int len = arr.length;
		// 0 1 2 3 4 5
		
		for(int i = len-1; i >= 0; i--) {
//			System.out.println(i+"====");
//			System.out.println(Arrays.toString(arr) );
			boolean exchFlag = true;
			for(int j = 1 ;j <= i; ++ j) {
				if(compare(arr, j, j-1)) {
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
					exchFlag = false;
				}
			}
//			System.out.println(Arrays.toString(arr) + " " + exchFlag);
			if(exchFlag) {
				break;
			}
		}
	}

	private static boolean compare(int[] arr, int pre, int next) {
		return arr[pre] > arr[next];
	}

}
