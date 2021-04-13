package sorted;

public class SingleTon {

	private static SingleTon singleTon = null;
	static int idx = 0;
	
	private SingleTon() {
	}

	public static SingleTon getInstance() {
		if (singleTon == null) {
			synchronized (SingleTon.class) {
				if (singleTon == null) {
					singleTon = new SingleTon();
					idx += 1;
				}
			}
		}
		return singleTon;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread[] workers = new Thread[5000];
		for (int i = 0; i < 5000; i++) {
			Thread worker = new Thread(SingleTon::getInstance);
			workers[i] = worker;
		}
		for (int i = 0; i < 5000; i++) {
			workers[i].start();
		}
		System.out.println(idx);
		for (int i = 0; i < 1000; i++) {
			workers[i].join();
		}
	}

}
