package week3.ngram;

import java.util.ArrayList;

/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class MarkovWordOne extends AMarkovWord {


	public MarkovWordOne() {
		super(1);
	}
	
	public void testIndexOf(){
		
		String[] text = "this is just a test yes this is a simple test".split("\\s+");
		
		System.out.println("Index of 'this':\t" + indexOf(text, "this", 0));
		System.out.println("Index of next 'this':\t" + indexOf(text, "this",3));
		System.out.println("Index of 'frog':\t" + indexOf(text, "frog", 0));
		System.out.println("Index of 'frog':\t" + indexOf(text, "frog", 5));
		System.out.println("Index of 'simple':\t" + indexOf(text, "simple", 2));
		System.out.println("Index of 'test':\t" + indexOf(text, "test", 5));
	}
	
	public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length-1);  // random word to start with
		String key = myText[index];
		sb.append(key);
		sb.append(" ");
		for(int k=0; k < numWords-1; k++){
		    ArrayList<String> follows = getFollows(key);
		    if (follows.size() == 0) {
		        break;
		    }
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			key = next;
		}
		
		return sb.toString().trim();
	}
	
	public static void main(String[] args) {
		MarkovWordOne markov = new MarkovWordOne();
		markov.testIndexOf();
	}


}