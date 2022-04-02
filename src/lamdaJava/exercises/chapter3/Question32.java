package lamdaJava.exercises.chapter3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import chapter1.Artist;

public class Question32 {

	/*
	 * на вход - исполнители, на выход строки - имя + место происхождения
	 */
	public List<String> getNamesAndOrigins(List<Artist> artists) {
		List<String> result = artists.stream()
									 .flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
									 .collect(Collectors.toList());
		return result;
	}
}
