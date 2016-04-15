import java.util.*;
import java.io.*;
import java.text.*;

public class BallotObject{
	int number;
	String category;
	String _number;
	String[] nomineesList;
	int buttonNum = 0;

	
	//constructor for ballot object
	public BallotObject(int Num, String Category, String[] nomineeList){
		number = Num;
		_number = Integer.toString(number);
		category = Category;
		nomineesList = nomineeList;
		buttonNum = nomineesList.length;
	}
	public String get_Number(){
		return _number;
	}
	public String[] getNomineesList(){
		return nomineesList;
	}
	public String getCategory(){
		return category;
	}
	public int getbuttonNum(){
		return buttonNum;
	}
	//creates ballot files that votes are stored in
	public void makeFiles(){
		try{
		File file = new File(_number);
		if(file.exists() == false){
			PrintWriter writer = new PrintWriter(_number);
			for(String _nominee : nomineesList){
				writer.println(_nominee + ":0");
			}
			writer.close();	
			
			}
		}
			catch(Exception e){
				System.out.println("MakeFile FAILED!");
			}
	}
	// overwrites ballot txt file and updates vote info
	public void compareInfo(ArrayList<String> winnerL, int i){
		int _i = i;
		int votes = 0;
		ArrayList<String> stringL = new ArrayList<String>();
		ArrayList<String> _winnerL = winnerL;
		File catFile = new File(_number);
		try{
		Scanner S = new Scanner(catFile);
		while(S.hasNextLine()){
			String info = S.nextLine();
			String[] infoList = info.split(":");
			String name = infoList[0];
			votes = Integer.parseInt(infoList[1]);
			if(winnerL.get(_i).equals(name)){
				votes++;
			}
			String string = toString(name, votes);
			stringL.add(string);	
		}
		S.close();
		
		if(catFile.exists()){
			try{
			PrintWriter Writer = new PrintWriter(catFile);
			int n = 0;
			for(String string : stringL){
				n++;
				if(n < stringL.size()){
					Writer.println(string);
				}
				else{
					Writer.print(string);
				}
			}
			Writer.close();
			}
			catch(Exception e){
				System.out.println("Error");
				
			}
			
		}
		}
		catch(Exception e){
			System.out.println("Scanner Failed");
			e.printStackTrace();
		}
		
	}
	public String toString(String name, int votes){
		String _name = name;
		int _votes = votes;
		String string =(_name + ":" + _votes);
		return string;
		
	}
}