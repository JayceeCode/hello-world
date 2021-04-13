package sorted;

import java.util.Arrays;

public class insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {2,6,4,8,0,1};
		new insert().insert(arr);
		System.out.println(Arrays.toString(arr));
	}
	// 1 2 3 3
	public void insert(int[] arr) {
		int len = arr.length;
		for(int i = 1 ; i < len;++i) {
			int tmp = arr[i];
			int j = i-1;
			while( j >= 0 ) {
				if(arr[j] > tmp) {
					arr[j+1] = arr[j];
					--j;
				}else {
					break;
				}
				
			}
			arr[j+1] = tmp;
		}
	}

}
