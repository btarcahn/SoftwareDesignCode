package ca.mcgill.cs.swdesign.m3.demo;

import java.util.HashMap;
import java.util.Map;

import opennlp.tools.stemmer.*;
import opennlp.tools.stemmer.snowball.SnowballStemmer;

public class WordStemmer
{
	public enum Type {Porter, Snowball}
	private final Type aStemmerType;
	private final Stemmer aStemmer;
	private static final Map<Type, WordStemmer> stemmerStore = new HashMap<>();
	
	/*
	 * @param the stemming algorithm to be used
	 * @pre pType != null
	 */
	private WordStemmer(Type pType) {
		assert pType != null;
		aStemmerType = pType;
		switch(pType) {
			case Porter: 
				aStemmer = new PorterStemmer();
				break;
			case Snowball:
				aStemmer = new SnowballStemmer(SnowballStemmer.ALGORITHM.ENGLISH);
				break;
			default:
				throw new AssertionError(this);
		}
	}
	
	/*
	 * Access to the shared instances of WordStemmer
	 * @pre pType != null
	 */ 
	public static WordStemmer getStemmer(Type pType) {
		assert pType != null;
		if(!stemmerStore.containsKey(pType)) {
			stemmerStore.put(pType, new WordStemmer(pType));
		}
		return stemmerStore.get(pType);
	}

	/*
	 * Get the root form of the input string based on the stemming algorithm specified by Type.
	 * @pre wordString != null
	 */ 
	public String stem(String wordString)
	{
		assert  wordString != null;
		return aStemmer.stem(wordString).toString();
	}
	
	public Type getType() {
		return aStemmerType;
	}

}
