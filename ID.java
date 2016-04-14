import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class ID{
	int number;
	String fullName;
	boolean hasVoted;
	public ID(int userID, String name, boolean bool){
		number = userID;
		fullName = name;
		hasVoted = bool;
		
	}
	public boolean checkID(int voterID){
		int _voterID = voterID;
		boolean login = hasVoted;
		System.out.println("login is " + login);
		System.out.println(_voterID + "=" + number);
		if(_voterID == number){
			System.out.println("Hello00 "+ fullName);
			JOptionPane.showMessageDialog(null, "Hello " + fullName);
			return true;
		}
		else{
			
			return false;	
		}
		
	}
	public void checkUser(boolean voted){
		hasVoted = voted;
		
		
	}
	public String toStr(){
		String string = number + ":" + fullName + ":" + hasVoted;
		return string;
	}
}