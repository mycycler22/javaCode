package lab13Dictionary;

import java.util.Random;

// The timedHashMap driver runs much quicker than the other dictionaries

public class TimeHashMapDictionary {
	public static int timeAdds(int numValues, DictionaryHashMap dict) {

		Random randomizer = new Random();

		int startTime = (int)System.currentTimeMillis();
		for (int i = numValues; i > 0; i--) {
			String word = "0000000000" + randomizer.nextInt();
			dict.add(word.substring(word.length()-10),"def");
		}


		for (int i = 0; i < numValues; i++) {
			dict.contains("zzz");
		}

		int endTime = (int)System.currentTimeMillis();

		return endTime - startTime;
	}
}