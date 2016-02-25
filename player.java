import java.io.*;
import java.util.*;
import java.lang.*;


public class player{
	private double Money = 0.00;
	private int Hands = 0;
	private int Won = 0;
	private Formatter x;
	
	public player(String Name){
		File y = new File(Name + ".txt");
		if (y.exists()){
			openFile(y);
			
			
			
			
			
			}
		else {
		Money = 100.00;
		Hands = 0;
		Won = 0;
		}
		try{
			x = new Formatter(Name + ".txt");
		}
		catch(Exception e){
			System.out.println("Error");
		}
		
		
	}
	public void Write(double Money, int Hands, int Won){
		x.format("%s %n", Money );
		x.format("%s %n", Hands);
		x.format("%s %n", Won);
		}
	public double getMoney(){
		return Money;
	}
	public int getHands(){
		return Hands;
	}
	public int getWon(){
		return Won;
	}
	public void closeFile(){
		x.close();}
	
	public void openFile(File y){
		// Look up FileDemo.java
		
		
		try{
			Scanner sc = new Scanner(y);
			
			Money = sc.nextDouble();
			getMoney();
			Hands = sc.nextInt();
			getHands();
			Won = sc.nextInt();
			getWon();
			
		}
		catch(Exception e){
		e.printStackTrace();
		System.out.println("error");}
				
	
		
			
		
	}
	
}