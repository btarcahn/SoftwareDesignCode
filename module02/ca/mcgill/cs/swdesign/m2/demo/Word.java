package ca.mcgill.cs.swdesign.m2.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Word implements Comparable<Word>{
	final private String orignialForm; // Representation of a word in its original form as in one sentence. 

	
	public Word(String pOriginalWord) {
		orignialForm = pOriginalWord;
	}

	
	public String getOrignialForm() {
		return orignialForm;
	}

	/*
	 * Compare the word lexicographically, ignoring case differences
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Word pWord) {
		return this.orignialForm.compareToIgnoreCase(pWord.orignialForm);
	} 
	
	public String toString() {
		return orignialForm.toLowerCase();
		
	}
	
	static Comparator<Word> getByLengthComparator() 
	{
		return new Comparator<Word>() {
			@Override
			public int compare(Word pWord1, Word pWord2) {
				return pWord1.getOrignialForm().length() - pWord2.getOrignialForm().length();
			}
		};
	}
	
	static Comparator<Word> getCaseSensitiveComparator() 
	{
		return (pWord1, pWord2) ->
			pWord1.orignialForm.compareTo(pWord2.orignialForm);
	}
	
	static Comparator<Word> getCaseIgnoranceComparator() 
	{
		return (pWord1, pWord2) ->
			pWord1.compareTo(pWord2);
	}
	
	/**
	 * This is the driver program.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Word w1 = new Word("hello");
		Word w2 = new Word("great");
		Word w3 = new Word("weather");
		List<Word> words = new ArrayList<>();
		words.add(w1);
		words.add(w2);
		words.add(w3);
		
		Collections.sort(words);
		for(Word eachWord:words) {
			System.out.println(eachWord);
		}
		
	}
	
	

}
