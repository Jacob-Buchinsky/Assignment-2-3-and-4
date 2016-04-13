import java.util.*;
import java.io.*;
import java.text.*;

public class Ballot{
	public static int numCategories = 0;
	public int buttonNum = 0;
	String[] nomineeList;
	ArrayList <BallotObject> ballotInfo;
	
	public ArrayList<BallotObject> readBallot (){
		File ballotDoc = new File("Ballot1.txt");
		ballotInfo = new ArrayList <BallotObject> ();
		try{ 
			Scanner s = new Scanner(ballotDoc);
			numCategories = Integer.parseInt(s.nextLine());
			while (s.hasNextLine()) {
				String infoCat = s.nextLine();
				String[] catList = infoCat.split(":");
				int catNumber = Integer.parseInt(catList[0]);
				String category = catList[1];
				String nominee = catList[2];
				String[] nomineeList = nominee.split(",");
				buttonNum = nomineeList.length;
				BallotObject ballot = new BallotObject(catNumber, category, nomineeList);
				ballotInfo.add(ballot);
				
				
				
			}
			s.close();
		}
		catch(Exception e){
			System.out.println("ERROR");
			e.printStackTrace();
		}
		return ballotInfo;
	}	
	public String[] getNomineeList(){
		return nomineeList;
	}
	public ArrayList<BallotObject> getBallotInfo(){
		return ballotInfo;
	}
}