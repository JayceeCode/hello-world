package test_pkg;

public class Square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* 
		 * 1 0 0 0 0 x 
		 * 1 0 0 0 0 0 
		 * 1 0 0 0 0 0 
		 * 1 0 0 0 0 0 
		 * 1 4 10 20 0 0 
		 * 1 3 6 10 15 21 
		 * 1 2 3 4 5 6 
		 * x 1 1 1 1 1
		 * 0 -> n
		 * x:8
		 * f(i, j) = f(i-1, j) + f(i, j-1)
		 */
		System.out.println(f(0, 0, 4, 4));
		
	}

	private static int f(int i1, int j1, int i2, int j2) {
		int[][] arr = new int[i2][j2];
		for (int i = 0; i < i2;++i) {
			arr[i][0] = 1; 
		}
		for (int j = 0; j < j2;++j) {
			arr[0][j] = 1; 
		}
		
		for(int i = 1; i < i2; ++i) {
			for (int j = 1; j < j2; ++j) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}
		
		return arr[i2-1][j2-1];
	}

}
