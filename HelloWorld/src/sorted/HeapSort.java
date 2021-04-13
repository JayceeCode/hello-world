package sorted;

import java.util.Arrays;

public class HeapSort {

	public HeapSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {10,2,3,5,8,6,0};
		createHeap(arr,arr.length);
		int len  = arr.length;
		while(len > 0) {
			len =  deleteNode(arr, len);
			siftdown(arr,0,len);
		}
		
		System.out.println(Arrays.toString(arr));

	}
	
	

	private static int deleteNode(int[] arr,int len) {
		// TODO Auto-generated method stub
		int temp = arr[0];
		arr[0] = arr[len-1];
		arr[len-1] = temp;
		
		return --len;
		
	}

	//创建堆
	public static void createHeap(int[] arr,int len) {
		int i;
	    //从最后一个非叶结点到第1个结点依次进行向上调整
	    for(i=len/2;i>=0;i--)
	    {
	        siftdown(arr,i,len);
	    }  
	    System.out.println("----"+Arrays.toString(arr));
	}
	//   0 i
	//t 1  2 i  

	private static void siftdown(int[] arr,int i,int len) {
		// TODO Auto-generated method stub
		//exchangeFlag 记录当前节点是否交换
		//t 记录当前节点为根结点的最小值的位置
		int t = 0 ;
		while(2*i+1 < len ) {
			if(arr[i] > arr[2*i+1]) {
				t = 2*i+1;
			}else {
				t =i;
			}
			//存在右子树
			if(i*2+2 < len) {
				if( arr[t] > arr[2*i+2]) {
					t = 2*i+2;
				}
			}
			
			
			if(t != i) {
				swap(arr,i,t);
				i = t;
			}else {
				break;
			}
			
		}
		
	}

	private static void swap(int[] arr, int i, int t) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i] = arr[t];
		arr[t] = temp;
	}
	
	
	
    
/*
 * | 排序算法        | 时间复杂度   |  空间复杂度  | 是否稳定| 基本原理|
| --------   | -----:  | :----:  |  :-----:  | :----:  |
| 冒泡排序      | O(n*n)  |  O(1)      |是 | 两两比较和交换，将当前无序列中选择最大值（最小值）|
| 选择排序      | $1600   |   5     |2 | 3|
| 插入排序      | $1600   |   5     |2 | 3|
| 希尔排序      | $1600   |   5     |2 | 3|
| 快速排序      | $1600   |   5     |2 | 3|
| 归并排序      | $1600   |   5     |2 | 3|
| 堆排序      | O(nlogn) |  O(1)   |否 |  利用堆结构将无序数组构建小顶堆（大顶堆），然后将堆顶元素放在有序部门，将堆结构最后的元素放在堆顶再构建小顶堆（大顶堆）|
 * */
}
