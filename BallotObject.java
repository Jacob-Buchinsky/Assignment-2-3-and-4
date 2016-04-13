import java.util.*;
import java.io.*;
import java.text.*;

public class BallotObject{
	int number;
	String category;
	String[] nomineesList;
	int buttonNum = 0;
	
	public BallotObject(int Num, String Category, String[] nomineeList){
		number = Num;
		category = Category;
		nomineesList = nomineeList;
		buttonNum = nomineesList.length;
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
}