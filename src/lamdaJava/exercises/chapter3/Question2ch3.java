package lamdaJava.exercises.chapter3;

import java.util.List;
import java.util.stream.Stream;

import chapter1.Artist;

public class Question2ch3 {

	/**
	 * итерирование внешнее и внутренее
	 * @param artists
	 * @return
	 */
	public int countMembers(List<Artist> artists) {
		int result = 0;
		for(Artist artist : artists) {
			Stream<Artist> members = artist.getMembers();
			System.out.println("artist.getName(): " + artist.getName());
			result += members.count();
		}
		
		int result2 = artists.stream()
							 .map(artist -> artist.getMembers().count())
							 .reduce(0L, Long::sum)
							 .intValue();
		
		return result2;
	}
}
