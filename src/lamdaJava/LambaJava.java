//https://github.com/RichardWarburton/java-8-lambdas-exercises/tree/master/src/main/java/com/insightfullogic/java8/examples
//
//функциональный интерфейс - интерфейс с единственным абстрактным методом, который является типом лямбда-выражения
//
//stream - это средство конструирования сложных операций над коллекциями с применением функционального подхода
//
//отложенные и энергичные методы stream
//
//collect(toList()) - энергичная операция, порождающая список из значений в объекте Stream
//
//map() - перобразует значения одного типа в другой, в объекте Stream
//
//filter() - 
//
//flatMap() - заменяет значение объектом Stream, конкатенирует потоки
//
//min()
//
//reduce() - из коллекции значений получить одно значение
//
//


package lamdaJava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import chapter1.Album;
import chapter1.Artist;
import chapter1.Track;
import lamdaJava.exercises.chapter3.Question31;
import lamdaJava.exercises.chapter3.Question32;
import lamdaJava.exercises.chapter3.Question33;

import static chapter1.SampleData.membersOfTheBeatles;
import static chapter1.SampleData.sampleShortAlbum2;
import static chapter1.SampleData.albumsForTest;

import static java.util.Arrays.asList;


public class LambaJava {

	public static void main(String[] args) {
		//Objects.requireNonNull(null);
		System.out.println("hello");
		
		List<Artist> allArtist = membersOfTheBeatles;
		int count = 0;
		for(Artist artist : allArtist) {
			if(artist.isFrom("UK")) {
				System.out.println("name::" + artist.getName());
				count++;
			}
		}
		System.out.println("count::" + count);
		
		allArtist.stream()
				.filter(artist -> {
					System.out.println("1 name stream::" + artist.getName());
					return artist.isFrom("UK");
				});
		
		long countStream = allArtist.stream()
									.filter(artist -> {
										System.out.println("2 name stream::" + artist.getName());
										return artist.isFrom("UK");
									})
									.count();
		System.out.println("countStream::"+ countStream);
		
		//collect(toList())
		System.out.println("====collect(toList())====");
		List<String> collected = Stream.of("a","b","c")
									   .collect(Collectors.toList());
		for(String el : collected) {
			System.out.println(el);
		}
		
		//map()
		System.out.println("====map()====");
		List<String> collectedM = new ArrayList<>();
		for(String str : asList("a","b","c")) {
			String upperStr = str.toUpperCase();
			collectedM.add(upperStr);
		}
		for(String el : collectedM) {
			System.out.println(el);
		}
		List<String> collectedMM = Stream.of("a","b","c")
										 .map(str -> str.toUpperCase())
										 .collect(Collectors.toList());
		for(String el : collectedMM) {
			System.out.println(el);
		}
		
		//filter()
		System.out.println("====filter()====");
		List<String> begWithNumb = new ArrayList<>();
		for(String el : asList("aa", "2aa", "aa2")) {
			if(Character.isDigit(el.charAt(0))) {
				begWithNumb.add(el);
			}
		}
		for(String el : begWithNumb) {
			System.out.println("begWithNumb::" + el);
		}
		List<String> begWithNumbF = Stream.of("aa", "2aa", "aa2")
										  .filter(strValue -> Character.isDigit(strValue.charAt(0)))
										  .collect(Collectors.toList());
		for(String el : begWithNumbF) {
			System.out.println("begWithNumbF::" + el);
		}
		
		//flatMap()
		System.out.println("====flatMap()====");
		List<Integer> together = Stream.of(asList(2, 4), asList(5, 8))
									   .flatMap(numb -> numb.stream())
									   .collect(Collectors.toList());
		System.out.println("together::" + together);
		
		//min()
		System.out.println("====min()====");
		List<Track> tracks = asList(new Track("AA", 33), new Track("QQ", 44), new Track("DD", 35));
		Track shortesTrackT = tracks.get(0);
		for(Track el : tracks) {
			if(el.getLength() < shortesTrackT.getLength()) {
				shortesTrackT = el;
			}
		}
		System.out.println("shortesTrackT:: " + shortesTrackT.getName() + " :: " + shortesTrackT.getLength());
		Track shortesTrack = tracks.stream()
									.min(Comparator.comparing(track -> track.getLength()))
									.get();
		System.out.println("schortesTrack:: " + shortesTrack.getName() + " :: " + shortesTrack.getLength());
		
		//reduce()
		System.out.println("====reduce()====");
		int acc = 0;
		for(Integer elem : asList(1, 3, 5)) {
			acc = acc + elem;
		}
		System.out.println("acc::" + acc);
		int sum = Stream.of(1, 3, 5)
				        .reduce(0, (accC, elem) -> accC + elem);
		System.out.println("sum::" + sum);
		
		//для альбома определить все национальности групп исполнителей
		System.out.println("====task1 origins====");
		Album album = sampleShortAlbum2;
		Set<String> origins = album.getMusicians()
									.filter(artists -> artists.getName().startsWith("The"))
									.map(artist -> artist.getNationality())
									.collect( Collectors.toSet());
		for(String orig : origins) {
			System.out.println("orig::" + orig);
		}
				
		//Найти названия произведений в альбомах, который дольше минуты
		System.out.println("====task1 names====");
		Set<String> names = findLongTrack1(albumsForTest);
		for(String name : names) {
			System.out.println("name1::" + name);
		}
		names.clear();
		names = findLongTrack2(albumsForTest);
		for(String name : names) {
			System.out.println("name2::" + name);
		}
		names.clear();
		names = findLongTrack3(albumsForTest);
		for(String name : names) {
			System.out.println("name3::" + name);
		}
		names.clear();
		names = findLongTrack4(albumsForTest);
		for(String name : names) {
			System.out.println("name4::" + name);
		}
		
		/*
		 * quest31
		 */
		Question31 quest31 = new Question31();
		Stream<Integer> st = Stream.of(2, 4, 6);
		int result31 = quest31.addUp(st);
		System.out.println("Question31: result31: " + result31);
		
		/*
		 * quest32
		 */
		Question32 quest32 = new Question32();
		List<Artist> artists = membersOfTheBeatles;
		List<String> result32 = quest32.getNamesAndOrigins(artists);
		for(String el : result32) {
			System.out.println("Question32: result32: " + el);
		}
		
		/*
		 * quest33
		 */
		Question33 quest33 = new Question33();
		List<Album> albums = albumsForTest;
		List<Album> albumsRes = quest33.getAlbumsWithAtMostThreeTracks(albums);
		for(Album el : albumsRes) {
			System.out.println("Question33: albumRes: " + el.toString());
		}
	}
	
	/*
	 * firts variant
	 */
	public static Set<String> findLongTrack1(List<Album> albums) {
		Set<String> result = new HashSet<String>();
		for(Album album : albums) {
			for(Track track : album.getTrackList()) {
				if(track.getLength() > 60) {
					String name = track.getName();
					result.add(name);
				}
			}
		}
		return result;
	}
	
	/*
	 * seconde variant
	 */
	public static Set<String> findLongTrack2(List<Album> albums) {
		Set<String> result = new HashSet<String>();
		albums.stream()
				.forEach(album -> {
					album.getTracks()
						.forEach(track -> {
							if(track.getLength() > 60) {
								result.add(track.getName());
							}
						});
				});
		return result;
	}
	
	/*
	 * third variant
	 */
	public static Set<String> findLongTrack3(List<Album> albums) {
		Set<String> result = new HashSet<String>();
		albums.stream()
				.forEach(album -> {
					album.getTracks()
						.filter(track -> track.getLength() > 60)
						.map(track -> track.getName())
						.forEach(name -> result.add(name)); 
				});
		return result;
	}
	
	/*
	 * fourth variant
	 */
	public static Set<String> findLongTrack4(List<Album> albums) {
		Set<String> result = new HashSet<String>();
		albums.stream()
				.flatMap(album -> album.getTracks())
				.filter(track -> track.getLength() > 60)
				.map(track -> track.getName())
				.forEach(name -> result.add(name)); 
				
		return result;
	}
	
	
	
}
