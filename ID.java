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
		boolean login = hasVoted;
		if(voterID == number){
			System.out.println("Hello "+ fullName);
			JOptionPane.showMessageDialog(null, "Hello " + fullName);
			login = true;
			return login;
		}
		else{
			return false;	
		}
		
	}
	
}