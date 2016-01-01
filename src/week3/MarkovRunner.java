package week3;
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

public class MarkovRunner {
	

	/**
	 * Get sample text from file as a string
	 * @return
	 */
	private String getText() {
		FileResource fr = new FileResource("data/markov/confucius.txt");
		String st = fr.asString();
		st = st.replace('\n', ' ');
		return st;
	}
	
    public void runMarkovZero() {

    	String st = getText();
		MarkovZero markov = new MarkovZero();
		markov.setRandom(42);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
	}
	
    public void runMarkovOne() {
    	String st = getText();
		MarkovOne markov = new MarkovOne();
		markov.setRandom(42);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(500);
			printOut(text);
		}
    }
    
	private void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}
	
	public static void main(String[] args) {
		MarkovRunner mr = new MarkovRunner();
		mr.runMarkovOne();
	}
	
}
