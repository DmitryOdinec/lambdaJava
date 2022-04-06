package lamdaJava.exercises.chapter3;

import java.util.stream.Stream;

public class Question11ch3 {

	/**
	 * Функция сложения чисел
	 * @param numbers
	 * @return
	 */
	public int addUp(Stream<Integer> numbers) {
		int result = numbers.reduce(0, (acc, x) -> acc+x);
		
		return result;
	}
}
