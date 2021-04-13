package sorted;

import java.util.Arrays;

public class select_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {8,1,4,9,6,0,7};
		new select_sort().process(arr);
		
		System.out.println(Arrays.toString(arr));
	}
	
	public void process(int arr[]) {
		int len = arr.length;
		for(int i = 0; i < len; ++i) {
			System.out.println(Arrays.toString(arr) );
			int min_id  = i;
			for (int j = i+1; j < len; ++j) {
				if(arr[j] < arr[min_id]) {
					min_id = j;
				}
			}
//			if(min_id == i)
//				continue;
			int tmp = arr[i];
			arr[i] = arr[min_id];
			arr[min_id] = tmp;
			System.out.println(Arrays.toString(arr) + " "  + min_id);
		}
	}
}
