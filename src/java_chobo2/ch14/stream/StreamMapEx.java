package java_chobo2.ch14.stream;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMapEx {

	public static void main(String[] args) {
		extracted();
//		extracted01();
		
		IntStream intStream = new Random().ints(1,46);
		Stream<Integer> integerStream = intStream.boxed();//1~45사이의 정수(46은 포함안됨)
		integerStream.forEach(System.out::println);//IntStream -> Stream
		
		Stream<String> lottoStream = intStream
									.distinct().limit(6).sorted()
									.mapToObj(i -> i + ","); // intStream -> Stream
		lottoStream.forEach(System.out::println); // 12,14,20,23,26,29
		
	}//end of main

	public static void extracted01() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("이자바", 3, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("안자바", 2, 100));
		list.add(new Student("박자바", 2, 150));
		list.add(new Student("소자바", 1, 200));
		list.add(new Student("나자바", 3, 290));
		list.add(new Student("김자바", 3, 180));
		
		Stream<Student> stdStream = list.stream();
		

				
		//스트림을 기본 스트림으로 변환
		Stream<Integer> stdScoreStream = stdStream.map(Student::getTotalScore);
//		studentStream.forEach(System.out::println);
		int total = stdScoreStream.reduce(0, (a, b) -> a+b);
		System.out.println(total);
		
		stdStream = list.stream();
		IntStream stdScoreIntStream = stdStream.mapToInt(Student::getTotalScore);
		total = stdScoreIntStream.max().getAsInt();
		System.out.println(total);
	}

	public static void extracted() {
		List<File> list = new ArrayList<>();
		list.add(new File("Ex1.java"));
		list.add(new File("Ex1.bak"));
		list.add(new File("Ex2.java"));
		list.add(new File("Ex1"));
		list.add(new File("Ex1.txt"));

		// map()으로 Stream<File>을 Stream<String>으로 변환
		Stream<File> fileStream = list.stream();
		Stream<String> fileNameStream = fileStream.map(File::getName);
//		fileNameStream.forEach(System.out::println);

		System.out.println();

		fileStream = list.stream();
		list.stream().map(File::getName)
		.filter(s -> s.indexOf('.') != -1)
		.peek(System.out::println)
		.map(s -> s.substring(s.indexOf('.') + 1))
		.peek(s->System.out.printf("extends %s%n", s))
		.map(String::toUpperCase)
		.peek(s->System.out.printf("upper %s%n", s))
		.distinct()
		.forEach(System.out::print);
		System.out.println();
/*
		Set<String> s = new HashSet<>();
		for (File f : list) {
			String ext = f.getName();
			if (ext.indexOf(',') != -1) {
				s.add(ext.substring(ext.indexOf(',') + 1).toUpperCase());
			}

		}
		System.out.println(s);
		
		File file = new File("test.java");
		String fileName = file.getName(); //"test.java"
		int idx = fileName.indexOf("."); //4
		System.out.println(fileName + " : " + idx);
		System.out.println(fileName.substring(idx+1));
		*/
	}

}
