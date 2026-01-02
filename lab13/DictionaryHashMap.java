package lab13Dictionary;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DictionaryHashMap {
	private Map<String,Word> words;

	public DictionaryHashMap() {
		this.words = new HashMap<String,Word>();
	}

	public DictionaryHashMap(String filename) {
		this();

		try {
			Scanner infile = new Scanner(new File(filename));
			while (infile.hasNext()) {
				String nextWord = infile.next();
				String definition = infile.nextLine().trim();

		//alternative way:
/*			String line = infile.nextLine();
				String[] parts = line.split(" ", 2);
				if (parts.length != 2) continue;
				String nextWord = parts[0];
				String definition = parts[1];
*/
				add(nextWord, definition);
			}
			infile.close();
		}
		catch (java.io.FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
		}
	}

	/**
	 * FINISH - add the Word to the dictionary
	 */
	public void add(String newWord,String def) {
		words.put(newWord, new Word(newWord, def));
	}

	/**
	 * FINISH - remove the entry in the hashset with the key
	 */
	public boolean removeWord(String oldWord) {
		return words.remove(oldWord) != null;
	}

	/**
	 * FINISH - return the definition portion of the Word in the hashset
	 */
	public String getDefinition(String word) {
		Word w = words.get(word);
		if(w != null) {
			return w.getDefinition();
		}
		
		return "not found";
	}

	/**
FINISH- see if the word is a key in the hashset
	 */
	public boolean contains(String testWord) {
		return words.containsKey(testWord);
		
	}

	
	/**
	 * FINISH - show the number of words in the map
	 */
	public int numWords() {
		return words.size();
	}
	
	
	/**
	 * FINISH - collect all the values and display
	 */
	public void display() {
		Collection<Word> values = words.values();
		
		for(Word w: values) {
			System.out.println(w);
		}
	}

	/**
	 * FINISH - collect the keys and display
	 */
	public void displayWords(){
		Set<String> keys = words.keySet();
		
		for(String word: keys) {
			System.out.println(word);
		}
	}
	
	
	//Sample methods
	/**
	 * get List of dictionary words
	 * @return the ArrayList of words
	 */
	public ArrayList<String> getList()
	{
		Set<String> listing = new HashSet<String>();
		listing = words.keySet();
		ArrayList<String> wordList = new ArrayList<String>();
		for (String s:listing)
			wordList.add(s);
		return wordList;

	}

	/**
	 * Returns an ArrayList of words that contain the specified substring.
	 *   @param substr the substring to match
	 *   @return an ArrayList containing all words that contain the substring
	 */
	public ArrayList<String> findMatches(String substr)
	{
		ArrayList<String> matches = new ArrayList<String>();
		/*
		 * look through all the words in the words list
		 * 		 if the word contains the substr
		 * 				add to matches ArrayList
		 */
		ArrayList<String> words = getList();
		for (String w:words)
		{
			if (w.contains(substr)) {
				matches.add(w);
			}
		}
		return matches;
	}
	

}

