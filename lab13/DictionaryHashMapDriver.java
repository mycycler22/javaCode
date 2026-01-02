package lab13Dictionary;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryHashMapDriver {

	public static void main(String[] args) throws IOException  {
		
		String fileName="dict.csv";

		DictionaryHashMap words = new  DictionaryHashMap(fileName);
		System.out.println("Play with hashmap dictionary");
		words.display();
//		words.removeWord("zymurgy");

		if (words.removeWord("zyzzyvasss")) {
			System.out.println("Found and removed");
		} else {
			System.out.println("Not found");
		}

		ArrayList<String> matches = words.findMatches("here");
		  System.out.println(matches);

		int count = 99999;
		System.out.println("Play with hashmap dictionary");
		int time = TimeHashMapDictionary.timeAdds(count,words);
		System.out.println("Time to Add and find "+count+" hashmap items: "+time);

	}

}
