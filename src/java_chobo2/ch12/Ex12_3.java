package java_chobo2.ch12;

import java.util.ArrayList;

import java_chobo2.ch12.Fruit.Apple;
import java_chobo2.ch12.Fruit.Apple.Grape;

interface Eatable {
}

class Fruit implements Eatable {

	@Override
	public String toString() {
		return "Fruit";
	}

	class Apple extends Fruit {

		@Override
		public String toString() {
			return "Apple";
		}

		class Grape extends Fruit {

			@Override
			public String toString() {
				return "Grape";

			}

			class Toy {

				@Override
				public String toString() {
					return "Toy";
				}

			}

			class FruitBox<T extends Fruit & Eatable> extends Box<T> {
			}
		}

	}

}

public class Ex12_3 {

	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		FruitBox<Grape> grapeBox = new FruitBox<Grape>();
//		FruitBox<Grape> grapeBox = new FruitBox<Apple>();
//		FruitBox<Toy> toyBox = new FruitBox<Toy>();
		
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		
	}

}

class FruitBox<T extends Fruit&Eatable> extends Box<T>{}

class Box<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {list.add(item);}
	T get(int i) {return list.get(i);}
	int size() {return list.size();}
	@Override
	public String toString() {
		return list.toString();
	}
	
}
