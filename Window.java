import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Window extends JPanel{
	public JButton login;
	public JButton confirm;
	public JPanel loginPanel;
	/*public JButton b1;
	public JButton b2;
	public JButton b3;
	public JButton b4;
	public JButton b5;
	*/
	
	ArrayList <JButton> buttonAlist = new ArrayList <JButton> ();
	
	public Window(ArrayList<BallotObject> ballotInfo, int balNum){
		int i = balNum;
		System.out.println(i +" = " + Ballot.numCategories);
		
		if(i < Ballot.numCategories){
			setLayout(new GridLayout(10,0,20,20));
			
			
			
			BallotObject ballot = ballotInfo.get(i);
			String[] _nomineesList = ballot.getNomineesList();
			String category = ballot.getCategory();
			JLabel item = new JLabel();
			item.setText(category);
			add(item);
			int buttonNum = ballot.getbuttonNum();
			System.out.println(buttonNum);
			for(int n = 0; n < buttonNum; n++){ 
				JButton btn = new JButton(); 
				btn.setText(_nomineesList[n]);
				btn.setEnabled(false);
				add(btn);                 //adding to frame
				buttonAlist.add(btn);
					
				}
		}	
		else if(i == (Ballot.numCategories)){
			setLayout(new FlowLayout(FlowLayout.CENTER));
			login = new JButton();
			confirm = new JButton();
			login.setText("Login");
			confirm.setText("Confirm Vote");
			add(login);
			add(confirm);
			System.out.println("KILL ME");
		} 
		
		
		
		
		try{
		login.addActionListener(new thehandler());
		}
		catch(Exception FUCKMYASS){
			FUCKMYASS.printStackTrace();
		}
    
		
		
		/*add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		*/
	}
	
	public class thehandler implements ActionListener{
		boolean _login = false;
		public void actionPerformed(ActionEvent e){
		String inputValue = JOptionPane.showInputDialog("Please input your voter ID");
		int numInput = Integer.parseInt(inputValue);
		ArrayList<ID> userInfo;
		VoterID file = new VoterID();
		file.readFile();
		userInfo = file.getID();
		int voterID = numInput;
		for(ID id: userInfo){
			_login = id.checkID(voterID);
		}
		System.out.println(_login);
		if(_login == true){
			System.out.println("ANUS");
			for( JButton btn : buttonAlist){
				System.out.println("Button has been anusilized");
				btn.setEnabled(true);
			}
		}	
			
				
			
		}
	}
	
	
}