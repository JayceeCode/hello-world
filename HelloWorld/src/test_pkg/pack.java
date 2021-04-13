package test_pkg;

import java.util.HashMap;
//零一背包问题
//W背包剩余重量， b：放入背包的第b个物品 w[]:物品重量组数 v[]物品价值数组

//求解：背包最大可装W重量的物品价值最大化。
//第i个物品有两种情况：放入背包内与不放入背包内
public class pack {
	static HashMap<String, Integer> m = new HashMap();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int w[] = {2, 5, 5, 2, 1, 1};
		int v[] = {3, 12, 8, 5, 2,2};
		int n = v.length;
		int W = 8;
		
		System.out.println(f1(w, v, W, 0, n-1));
		System.out.println(f2(w, v, W, 0, n-1));
		System.out.println(f3(w, v, W, n));
	}

	// 递归
	private static int f1(int[] w, int[] v, int W, int b, int e) {
		if (b > e || W == 0)
			return 0;
		int v1 = f1(w, v, W, b+1, e); // b位置的商品不放
		int v2 = 0;
		if (W >= w[b]) {             // b位置的商品放
			v2 = v[b] + f1(w, v, W - w[b], b+1, e);
		}
		
		int res = v1;
		if (res < v2) {
			res = v2;
		}
		return res;
	}
	// 递归 + 备忘录
	private static int f2(int[] w, int[] v, int W, int b, int e) {
		if (b > e || W == 0)
			return 0;
		String key = "" + W + "_____" + b;
		if (m.containsKey(key)) {
			System.out.println("hit");
			return m.get(key);
		}
		
		int v1 = f2(w, v, W, b+1, e); // b位置的商品不放
		int v2 = 0;
		if (W >= w[b]) {             // b位置的商品放
			v2 = v[b] + f2(w, v, W - w[b], b+1, e);
		}
		
		int res = v1;
		if (res < v2) {
			res = v2;
		}
		
		m.put(key, res);
		return res;
	}
	// 非递归
	private static int f3(int[] w, int[] v, int W, int n) {
		// M[wb]    => M[n] 
		// A[w][b]  => A[n]
		// A[W+1][n] 含义：
		// W: 5, n: 4
		// 5: 0 0 0 0
		// 4: 0 0 0 0
		// 3: 0 0 0 0
		// 2: 0 0 0 0
		// 1: 0 0 0 0
		// 0: 0 0 0 0
		//    0 1 2 3
		// A[0][0] 的含义是W为0，商品(0,1,2,3)，最大的价值
		// A[5][2] 的含义是W为5，商品(2,3)，最大的价值
		// A[5][0] 的含义即为问题的解
		// A[0][:] = 0
		// 初始值数组
		// W: 5, n: 4
		// 5: X ? ? ?
		// 4: ? ? ? ?
		// 3: ? ? ? ?
		// 2: ? ? ? ?
		// 1: ? ? ? 3
		// 0: 0 0 0 0
		//    0 1 2 3	
		// A[1][3] 的含义是W为1，商品(3)，最大的价值
		// W = 5; n = 1, w[0] = 1, v[0] = 3 ==>3
		// W = 5; n = 1, w[0] = 6, v[0] = 3 ==>0

		int A[][] = new int[W+1][n+1];
		for (int i = 0; i <= n; ++i)
			A[0][i] = 0;
		// n: 3->0
		for (int j = 0; j <= W; j++) {
			// W: 0->5
			for (int i = n-1; i >= 0; i--) {
				int v1 = A[j][i+1]; // qu
				int v2 = 0;
				if (j >= w[i]) {
					v2 = v[i] + A[j-w[i]][i+1];
				}
				int r = v1 > v2 ? v1 : v2;
				A[j][i] = r;
			}
		}
		return A[W][0];
	}
}
