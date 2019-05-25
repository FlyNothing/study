package com.yzy.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Ignore;
import org.junit.Test;

import com.yzy.model.Person;

public class StreamTest {
	@Test
	@Ignore
	public void map() {
		List<String> wordList = Arrays.asList("a", "b", "C");
		List<String> output = wordList.stream().map(s -> s.toUpperCase())
				.collect(Collectors.toList());
		output.forEach(System.out::println);
	}

	@Test
	@Ignore
	public void flatMap() {
		Stream<List<Integer>> inputStream = Stream.of(Arrays.asList(1),
				Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
		Stream<Integer> outputStream = inputStream
				.flatMap(childList -> childList.stream());
		List<Integer> output = outputStream.collect(Collectors.toList());
		output.forEach(System.out::println);
	}

	@Test
	@Ignore
	public void filter() {
		IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6);
		int[] array = stream.filter(s -> s % 2 == 0).toArray();
		for (int i : array) {
			System.out.println(i);
		}
	}

	@Test
	@Ignore
	public void forEach() {
		IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6);
		stream.forEach(System.out::println);
	}

	@Test
	@Ignore
	public void peek() {
		IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6);
		int[] array = stream.peek(s -> System.out.println("P1:" + s))
				.filter(s -> s % 2 == 0)
				.peek(s -> System.out.println("P2:" + s)).toArray();
		System.out.println(array.length);
	}

	@Test
	@Ignore
	public void Optional() {
		String strA = " abcd ", strB = null;
		print(strA);
		print("");
		print(strB);
		getLength(strA);
		getLength("");
		getLength(strB);
	}

	private static void print(String text) {
		Optional.ofNullable(text).ifPresent(System.out::println);
		if (text != null) {
			System.out.println(text);
		}
	}

	private static int getLength(String text) {
		return Optional.ofNullable(text).map(String::length).orElse(-1);
	};

	@Test
	@Ignore
	public void limitAndSort() {
		List<Person> persons = new ArrayList<>();
		while (true) {
			int i = new Random().nextInt(10);
			Person person = new Person(i, "name" + i);
			persons.add(person);
			if (i == 5) {
				break;
			}
		}
		persons.forEach(System.out::println);

		List<Person> personList2 = persons.stream().limit(2)
				.sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
				.collect(Collectors.toList());
		System.out.println(personList2);
	}

	@Test
	@Ignore
	public void reduce() {
		String concat = Stream.of("A", "B", "C", "D")
				.reduce("", String::concat);
		System.out.println(concat);
		double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(
				Double.MAX_VALUE, Double::min);
		System.out.println(minValue);
		int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
		sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
		System.out.println(sumValue);
		concat = Stream.of("a", "B", "c", "D", "e", "F")
				.filter(x -> x.compareTo("Z") > 0).reduce("", String::concat);
		System.out.println(concat);
	}

	@Test
	@Ignore
	public void limitAndSkip() {
		List<Person> persons = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			Person person = new Person(i, "name" + i);
			persons.add(person);
		}
		List<String> personList2 = persons.stream().map(Person::getName)
				.limit(10).skip(3).collect(Collectors.toList());
		System.out.println(personList2);
	}

	@Test
	@Ignore
	public void StreamGenerate() {
		/*
		 * Random seed = new Random(); Supplier<Integer> random = seed::nextInt;
		 * Stream.generate(random).limit(10).forEach(System.out::println);
		 */
		IntStream.generate(() -> (int) (System.nanoTime() % 100)).limit(10)
				.forEach(System.out::println);

	}

	@Test
	public void StreamIterate() {
		Stream.iterate(0, n -> n + 3).limit(10)
				.forEach(x -> System.out.print(x + " "));
	}

}
