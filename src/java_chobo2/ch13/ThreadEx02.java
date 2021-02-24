package java_chobo2.ch13;

public class ThreadEx02 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		for(int i=0; i<300; i++) {
			System.out.printf("%s", "-");
		}
		
		System.out.println();
		System.out.printf("%s %d 초 %n", "첫번째 작업", System.currentTimeMillis() - startTime);
		
		for(int i=0; i<300; i++) {
			System.out.printf("%s", "|");
		}
		System.out.println();
		System.out.printf("%s %d 초 %n", "두번째 작업", System.currentTimeMillis() - startTime);
	}

}
