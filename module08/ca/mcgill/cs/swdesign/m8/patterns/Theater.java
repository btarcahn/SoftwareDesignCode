package ca.mcgill.cs.swdesign.m8.patterns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Theater implements Iterable<Performance>
{
	List<Performance> aPerformances;
	PerformanceFactory aFactory;
	protected Theater(PerformanceFactory pFactory) {
		aFactory = pFactory;
		aPerformances = new ArrayList<>();
	}
	
	public void addPerformance(String pName) {
		Performance p = aFactory.createPerformance(pName);
		aPerformances.add(p);
	}
	
	public Iterator<Performance> iterator() {
		return new ArrayList<>(aPerformances).iterator(); 
	}

	public static void main(String[] args) {
		Theater movieTheater = new Theater(new MovieFactory());
		movieTheater.addPerformance("Big Fish");
		movieTheater.addPerformance("Eternal Sunshine of the Spotless Mind");
		
		for(Performance movie:movieTheater) {
			System.out.println(movie.getTitle());
			movie.startPerformance();
		}
	}
	

}
