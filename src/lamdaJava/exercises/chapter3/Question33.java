package lamdaJava.exercises.chapter3;

import java.util.List;
import java.util.stream.Collectors;

import chapter1.Album;

public class Question33 {

	/*
	 * на вход - альбомы, на выход - альбомы с не более тремя произведениями
	 */
	public List<Album> getAlbumsWithAtMostThreeTracks(List<Album> albumIn) {
		List<Album> result = albumIn.stream()
									.filter(album -> album.getTrackList().size() <= 3)
									.collect(Collectors.toList());
		return result;
	}
}
