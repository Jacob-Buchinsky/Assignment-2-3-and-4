import java.util.*;
import java.io.*;
import java.text.*;

public class VoterID {
	ArrayList <ID> userInfo;
	//Reads voter info from Voters.txt and creates new id object which is stored in an arraylist
	public void readFile(){
		File text = new File("Voters.txt");
		userInfo = new ArrayList <ID>();
		try{
			Scanner s = new Scanner(text);
			while (s.hasNextLine()) {
				String info = s.nextLine();
				String[] infoList = info.split(":");
				int number = Integer.parseInt(infoList[0]);
				String name = infoList[1];
				String _bool = infoList[2];
				boolean bool = Boolean.parseBoolean(_bool);
				ID id = new ID(number, name, bool);
				userInfo.add(id);
			}
			s.close();
		
		
		}
		catch(Exception e){
			System.out.println("ERROR");
			e.printStackTrace();
		}	
	}
	public ArrayList<ID> getID(){
		return userInfo;
	}
	
}