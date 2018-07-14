package core;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {
	
	public static void main(String [] args){
		PrintStream out;
		ArrayList<String> players = new ArrayList<String>();
		ArrayList<String> prizes = new ArrayList<String>();
		int prizeCounter = 0;
		int rounds = 0;
		int randomNumber;
		
		try {
			out = new PrintStream(new FileOutputStream("./winners.txt"));
			System.setOut(out);
			
			players.addAll(Arrays.getPlayers());
			prizes.addAll(Arrays.getPrizes());
			rounds = players.size();
			
			for(int i = 0; i < rounds; i++){
				randomNumber = (int) (Math.random() * players.size());
				if(prizeCounter < (prizes.size()-1)){
					System.out.print(players.get(randomNumber));
					System.out.println("   "+prizes.get(prizeCounter));
					prizeCounter++;
				}
				else{
					System.out.println(players.get(randomNumber));
				}
				players.remove(randomNumber);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
