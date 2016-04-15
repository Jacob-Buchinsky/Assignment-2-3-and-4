import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class ID{
	int number;
	String fullName;
	boolean hasVoted;
	//constructor for id object
	public ID(int userID, String name, boolean bool){
		number = userID;
		fullName = name;
		hasVoted = bool;
		
	}
	//checks if user is the "database"/voters.txt
	public boolean checkID(int voterID){
		int _voterID = voterID;
		boolean login = hasVoted;
		if(_voterID == number){
			JOptionPane.showMessageDialog(null, "Hello " + fullName);
			return true;
		}
		else{
			
			return false;	
		}
		
	}
	public void checkUser(boolean hasvoted){
		hasVoted = hasvoted;
		
	} 
	
	public boolean getBool(){
		return hasVoted;
		
		
	}
	public String toStr(){
		String string = number + ":" + fullName + ":" + hasVoted;
		return string;
	}
}