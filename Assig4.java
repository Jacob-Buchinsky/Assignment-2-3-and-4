import java.util.*;
import javax.swing.*;
import java.awt.*;


public class Assig4 {
	public int i = 0;
	
	
	public static void main(String[] args){
		Ballot ballot = new Ballot();
		ballot.readBallot();
		ArrayList<BallotObject> _ballotInfo = ballot.getBallotInfo();
		
			
		
		JFrame myFrame = new JFrame("BALLOT");
		myFrame.setSize(800,800);
		myFrame.setLayout(new FlowLayout());
		myFrame.setVisible(true);
		for(int i = 0; i < (Ballot.numCategories); i++){
			Window Window = new Window(_ballotInfo, i);
			myFrame.add(Window);
			if(i == (Ballot.numCategories-1)){
				Window window = new Window(_ballotInfo, (i+1));
				myFrame.add(window);
				System.out.println("PLEASE");
			}	
		}
		
		
		
		
		
	}
}