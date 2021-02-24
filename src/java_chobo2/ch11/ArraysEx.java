package java_chobo2.ch11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntUnaryOperator;

public class ArraysEx {

	public static void main(String[] args) {
//		arrayToString();
//		arrayDeepToString();
//		arrayToEquals();
//		arrayToFill();
//		arrayToList();	
//		arrayToBinarySearchSort();
		
		Student[] stdArr = {
				new Student(1),
				new Student(5),
				new Student(3),
				new Student(4)};
		
		Comparator<Student> comp = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getStdNo() - o2.getStdNo();
			}
			
		};
		Comparator<Student> revComp = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o2.getStdNo() - o1.getStdNo();
			}
			
		};
		Arrays.sort(stdArr, comp);
		System.out.println(Arrays.toString(stdArr));
		
		Arrays.parallelSort(stdArr, revComp);
		System.out.println(Arrays.deepToString(stdArr));
		}


	public static void arrayToBinarySearchSort() {
		int[] arr = {10, 9, 5, 6 , 7, 8, 1};
		System.out.println(Arrays.binarySearch(arr, 8));
		System.out.println(Arrays.binarySearch(arr, 1));
		
		long start = System.nanoTime();
		System.out.println("start ");
		Arrays.sort(arr);
//		Arrays.parallelSort(arr);
		long end = System.nanoTime() - start;
		System.out.println("end - "+ end);

		System.out.println(Arrays.toString(arr));
		
		System.out.println(Arrays.binarySearch(arr, 8));
		System.out.println(Arrays.binarySearch(arr, 1));
	}


	public static void arrayToList() {
		Integer[] intArr = new Integer[] {1,2,3,4};
		
		List<Integer> arList = Arrays.asList(intArr);
		for(int a: arList) {
			System.out.println(a);
		}
		arList.set(1, 6);
		System.out.println(arList);
		
		ArrayList<Integer> al = new ArrayList<Integer>(arList);
		al.add(10);
		System.out.println(al);
//		arList.add(10);
//		System.out.println(arList);
	}


	public static void arrayToFill() {
		int[] intArr1 = {1, 2, 3, 4, 5, 6};
		int[] copyArr1 = Arrays.copyOf(intArr1, intArr1.length);
		System.out.println(Arrays.toString(copyArr1));
		System.out.println(Arrays.equals(intArr1, copyArr1));
		
		
		int[] copyArr2 = Arrays.copyOf(intArr1, 3);
		System.out.println(Arrays.toString(copyArr2));
		
		int[] newArr = new int[10];
		Arrays.fill(newArr, 10);
		System.out.println(Arrays.toString(newArr));
		Arrays.setAll(newArr, (i)->(int) (Math.random()*100)+1);
		
/*		Arrays.setAll(newArr,new IntUnaryOperator() {
			
			@Override
			public int applyAsInt(int operand) {
				return (int)(Math.random()*100)+1;
			}
		}); 
*/		
		System.out.println(Arrays.toString(newArr));
	}
	

	public static void arrayToEquals() {
		int[] intArr1 = {1, 2, 3};
		int[] intArr2 = {1, 2, 4};
		System.out.println(Arrays.equals(intArr2, intArr1));
		
		int[][] intTwoDimen1 = {{1, 2}, {3, 4}};
		int[][] intTwoDimen2 = {{1, 2}, {3, 4}};
		System.out.println(Arrays.deepEquals(intTwoDimen1, intTwoDimen2));
	}

	public static void arrayDeepToString() {
		int[][] twoArr = { {1,2,3}, {4,5,6}, {7,8,9} };
		System.out.println(Arrays.toString(twoArr));
		System.out.println(Arrays.deepToString(twoArr));
	}

	public static void arrayToString() {
		// List -> array
		ArrayList<String> arList = new ArrayList<String>();
		arList.add("abc");
		arList.add("def");
		arList.add("ghi");

		Object[] objArr = arList.toArray();
		String str = Arrays.toString(objArr);
		System.out.println("objArr to String > " + str);

		String[] strArr = new String[arList.size()];
		arList.toArray(strArr);
		System.out.println(Arrays.toString(strArr));
	}

}
