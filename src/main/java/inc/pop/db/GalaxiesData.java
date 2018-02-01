package inc.pop.db;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import inc.pop.domain.Galaxy;

public class GalaxiesData {
	List<Galaxy> galaxies = new ArrayList<Galaxy>();

	public GalaxiesData() {
		galaxies.add(new Galaxy(0, "NGC 1300", "SBbc", "Eridanus"));
		galaxies.add(new Galaxy(1, "NGC 2787", "SB0", "Ursa Major"));
		galaxies.add(new Galaxy(2, "NGC 4314", "SBa", "Coma Berenices"));
		galaxies.add(new Galaxy(3, "NGC 4921", "SBab", "Coma Berenices"));
		galaxies.add(new Galaxy(4, "Messier 95", "SBb", "Leo"));
		galaxies.add(new Galaxy(5, "NGC 3953", "SBbc", "Ursa Major"));
		galaxies.add(new Galaxy(6, "NGC 1073", "SBc", "Cetus"));
		galaxies.add(new Galaxy(7, "Messier 108", "SBcd", "Ursa Major"));
		galaxies.add(new Galaxy(8, "NGC 2903", "SBd", "Leo"));
		galaxies.add(new Galaxy(9, "NGC 5398", "SBdm", "Centaurus"));
		galaxies.add(new Galaxy(10, "NGC 55", "SBm", "Sculptor"));
		galaxies.add(new Galaxy(11, "M58", "SBc", "Virgo"));
		galaxies.add(new Galaxy(12, "M91", "SBb", "Coma Berenices"));
		galaxies.add(new Galaxy(13, "M95", "SBb", "Leo"));
		galaxies.add(new Galaxy(14, "M109", "SBb", "Ursa Major"));
		galaxies.add(new Galaxy(15, "NGC 1300", "SBbc", "Eridanus"));
		galaxies.add(new Galaxy(16, "NGC 1365", "SBc", "Fornax"));
		galaxies.add(new Galaxy(17, "NGC 2217", "SBa", "Canis Major"));
		galaxies.add(new Galaxy(18, "Magellanic Clouds", "SBm", "Dorado, Tucana"));
		galaxies.add(new Galaxy(19, "UGC 12158", "SB", "Pegasus"));
		galaxies.add(new Galaxy(20, "NGC 1512", "SB(r)ab", "Horologium"));
		galaxies.add(new Galaxy(21, "IC 5201", "SB", "Grus"));
	}
	
	public List<Galaxy> getAllGalaxies() {
		return galaxies;
	}
	
	public List<Galaxy> find(String searchCriteria) {
		Stream.of(galaxies).flatMap(g->g.stream()).filter(findByName(searchCriteria)).collect(Collectors.toList());
		return null;
	}
	
	private Predicate<? super Galaxy> findByName(String searchCriteria) {
		return (Galaxy galaxy) -> galaxy.getName().contains(searchCriteria);
	}
}
