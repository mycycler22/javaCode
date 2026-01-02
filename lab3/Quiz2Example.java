package lab3;

import java.util.ArrayList;

public class Quiz2Example {

	public static void main(String[] args) {
		

	}

	/**
	* Returns the average length of the Strings of the ArrayList
	*  @param words the ArrayList to calculate the average of
	*  @return the average length of the values in the ArrayList
	*  */
	public double avgLength(ArrayList<String> words){
		double sum = 0;
		//for (int i=0;i<words.size();i++)
			for (String word:words)
		{
			sum += word.length();
		}	
			return sum/words.size();
	}
}
