package test_pkg;

import java.util.Collections;

public class Order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0, 1, 2,};
		f(arr, 0, 2);
	}
	
	static void f(int[] arr, int b, int e) {
		if (b == e) {
			for(int i = 0; i <= e; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println("1111");
			return;
		}
		for (int i = b; i <= e; i++) {
			int c = arr[b];
			arr[b] = arr[i];
			arr[i] = c;
			
			f(arr, b+1, e);
//			
//			System.out.println("====");
//			for(int j = 0; j < arr.length; ++j) {
//				System.out.print(arr[j] + " ");
//			}
//			System.out.println("-----");
			
			c = arr[b];
			arr[b] = arr[i];
			arr[i] = c;
		}
	}
}
