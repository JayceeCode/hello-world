package test_pkg;

public class testDemo20210202 {

	public testDemo20210202() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
//		for(int i = 0; i<100;++i) {
//			if((i&1) == 0) {
//				System.out.println(i);
//			}
//		}
		
		int a = 3;

		System.out.println(~a);
		
		testDemo20210202 t = new testDemo20210202();
		int helper[] = {0, 0, 0, 0, 0};
		t.add(87, helper);
		System.out.println(t.in(87, helper));
		System.out.println(t.in(86, helper));
	    // 012	
		// 000   0
		// 001   1
		// 010   2
		// 011   3
		// 100   4
		// 101   5
		// 110   6
		// 111   7
	}

	public void add(int num, int helper[]) {
		int idx = num / 32;
		int offset = num % 32;
		helper[idx] |= (1 << offset);
		
		// 2 = 87 / 32
		// 23 = 87 % 32
		// helper[2]的第23位设置为1
		
		// 10000000 00000000 00000000 00000000 
		
		// 保持其他位置不变  x | 0 = x
		// 第23位设置位1    x | 1 = 1
		// 10000000 00000000 00000010 00000000    <==   1 << 23
	}
	
	public boolean in(int num, int helper[]) {
		int idx = num / 32;
		int offset = num % 32;
		return (helper[idx] & (1 << offset)) != 0; 
		
		// 10000000 00000000 00000010 00000000 
		
		// 不能受其他位影响      x & 0 = 0
		// 只读取第23位的信息    x & 1 = x
		// 00000000 00000000 00000000 00000000   <==   1 << 23
		
		//获取结果
		// 00000000 00000000 00000x00 00000000
		// 00000000 00000000 00000100 00000000 != 0  --> true
		// 00000000 00000000 00000000 00000000  --> false
		
	}
}
