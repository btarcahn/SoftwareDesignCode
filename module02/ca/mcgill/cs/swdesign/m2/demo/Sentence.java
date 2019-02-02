package ca.mcgill.cs.swdesign.m2.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import ca.mcgill.cs.swdesign.m3.demo.WordStemmer;


public class Sentence implements Iterable<Word> {
	private WordStemmer aStemmer;
	private String aOriginalSentence;
	private Map<Integer, Word> aWords; // The key is the position of one word from a sentence.
	private Comparator<Word> aWordComparator; // The strategy to compare two words 
	
	public Sentence(String pOrignalSentence) {
		aOriginalSentence = pOrignalSentence;
		aStemmer = WordStemmer.getStemmer(WordStemmer.Type.Porter);
		aWords = new HashMap<>();
		aWordComparator = Word.getCaseIgnoranceComparator(); // Default comparator 
		splitSentence();
	}
	
	/**
	 * Split the sentence to obtain each token (tokenizatino).
	 * Currently using any non alphabetic character to split.
	 */
	private void splitSentence() {
		String[] wordsInSentence = aOriginalSentence.split("[^a-zA-Z]");
		int index = 0;
		for(String wordString:wordsInSentence) {
			if (wordString.length()>0) {	
				Word word = new Word(aStemmer.stem(wordString));	
				aWords.put(index, word);
				index ++;
			}
		}
	}
	
	/**
	 * @param pIndex The position of certain word in one sentence
	 * @return the word at index
	 * 
	 * @pre index >=0 && index<aWords.size();
	 */
	public Word getWord(int pIndex) {
		assert pIndex >=0 && pIndex<aWords.size();
		return aWords.get(pIndex);
	}
	
	/**
	 * 
	 * Remove the word in one sentence by its position
	 * @param pIndex The position of certain word in one sentence
	 * 
	 * @pre index >=0 && index<aWords.size();
	 */
	public void removeWord(int pIndex) {
		assert pIndex >=0 && pIndex<aWords.size();
		aWords.remove(pIndex);
	}
		

	public Comparator<Word> getWordComparator() {
		return aWordComparator;
	}

	/**
	 * @param pConcreteWordComparator The comparator defining the strategy to rank two words
	 * @pre pWordComparator != null
	 */
	public void setWordComparator(Comparator<Word> pWordComparator) {
		assert pWordComparator != null;
		aWordComparator = pWordComparator;
	}
	
	

	public WordStemmer getStemmer()
	{
		return aStemmer;
	}
	
	
	/**
	 * @pre stemmer != null
	 */
	public void setStemmer(WordStemmer pStemmer)
	{
		assert pStemmer != null;
		this.aStemmer = pStemmer;
	}

	@Override
	public Iterator<Word> iterator() {
		List<Word> wordCopies = new ArrayList<>(aWords.values());
		return wordCopies.iterator();
	}
	
	/**
	 * This is the driver program.
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please input your sentence: ");
		String keyboradInput = keyboard.nextLine();
		keyboard.close();
		
		System.out.println("Processing...");
		
		Iterable<Word> testSentence = new Sentence(keyboradInput);		
		for(Word word:testSentence) {
			System.out.println(word.toString());
		}
		
		
	}
	

}
