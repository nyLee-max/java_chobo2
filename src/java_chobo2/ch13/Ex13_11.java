package java_chobo2.ch13;

public class Ex13_11 {
	static long startTime = 0;

	public static void main(String[] args) {
		ThreadEx11_1 th1 = new ThreadEx11_1();
		ThreadEx11_2 th2 = new ThreadEx11_2();
		th1.start();
		th2.start();
		startTime = System.currentTimeMillis();

		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {

			System.out.print("소요시간:" + (System.currentTimeMillis() - Ex13_11.startTime));
			e.printStackTrace();
		}

	}

}
