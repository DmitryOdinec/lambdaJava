package lamdaJava.exercises.chapter3;

import java.util.stream.Stream;

public class Question31 {

	/*
	 * Функция сложения чисел
	 */
	public int addUp(Stream<Integer> numbers) {
		int result = numbers.reduce(0, (acc, x) -> acc+x);
		
		return result;
	}
}
