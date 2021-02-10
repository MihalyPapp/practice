package com.mihalypapp.data_structures;

public class DynamicArrayApp {

	public static void main(String[] args) {
		DynamicArray<Integer> myIntegerArray = new DynamicArray<>();
		testIntegerArray(myIntegerArray);

		System.out.println("\n\n--------------\n");

		DynamicArray<String> myStringArray = new DynamicArray<>();
		testStringArray(myStringArray);

		System.out.println("\n\n--------------\n");

		DynamicArray<Character> myCharacterArray = new DynamicArray<>();
		testCharacterArray(myCharacterArray);
	}

	private static void testIntegerArray(DynamicArray<Integer> myArray) {
		myArray.add(1);
		myArray.add(2);
		myArray.add(2);
		myArray.add(3);
		myArray.add(0);
		System.out.println("size: " + myArray.size());
		System.out.println("allocated size: " + myArray.getAllocatedSize());

		myArray.add(4);
		myArray.add(-1);
		printArrayWithIterator(myArray);

		System.out.println();

		myArray.remove();
		myArray.removeAt(3);
		myArray.add(8);
		myArray.shrinkTheArraySize();
		printArray(myArray);

		myArray.clear();
		System.out.println("\nsize after clear: " + myArray.size());

		myArray.add(3);
		myArray.add(20);
		myArray.add(-4);
		myArray.add(1, 2);
		printArray(myArray);
	}

	private static void testStringArray(DynamicArray<String> myArray) {
		myArray.add("1");
		myArray.add("135");
		myArray.add("2 Something");
		myArray.add("Apple");
		myArray.add("0");
		System.out.println("size: " + myArray.size());
		System.out.println("allocated size: " + myArray.getAllocatedSize());

		myArray.add("4");
		myArray.add("String");
		printArrayWithIterator(myArray);

		System.out.println();

		myArray.remove();
		myArray.removeAt(3);
		myArray.add("8");
		myArray.shrinkTheArraySize();
		printArray(myArray);

		myArray.clear();
		System.out.println("\nsize after clear: " + myArray.size());

		myArray.add("3");
		myArray.add("Some text");
		myArray.add("-4");
		myArray.add(1, "2");
		printArray(myArray);
	}

	private static void testCharacterArray(DynamicArray<Character> myArray) {
		myArray.add('a');
		myArray.add('W');
		myArray.add('&');
		myArray.add('3');
		myArray.add('_');
		System.out.println("size: " + myArray.size());
		System.out.println("allocated size: " + myArray.getAllocatedSize());

		myArray.add('d');
		myArray.add('-');
		printArrayWithIterator(myArray);

		System.out.println();

		myArray.remove();
		myArray.removeAt(3);
		myArray.add('Q');
		myArray.shrinkTheArraySize();
		printArray(myArray);

		myArray.clear();
		System.out.println("\nsize after clear: " + myArray.size());

		myArray.add('3');
		myArray.add('@');
		myArray.add('4');
		myArray.add(1, 'É');
		printArray(myArray);
	}

	private static <T> void printArrayWithIterator(DynamicArray<T> myArray) {
		System.out.print("  Elements: ");
		for (T num : myArray) {
			System.out.print(num + ", ");
		}
	}

	private static <T> void printArray(DynamicArray<T> myArray) {
		System.out.print("  Elements: ");
		for (int i = 0; i < myArray.size(); i++) {
			System.out.print(myArray.get(i) + ", ");
		}
	}
	
}
