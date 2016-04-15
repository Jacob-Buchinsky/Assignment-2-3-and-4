// VERY IMPORTANT!!!!!!!!!!!!!! WINDOW CLASS = BALLOT IN INSTRUCTIONS JUST A DIFFERENT NAME
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Window extends JPanel{
	//Initialize Variables
	public static JButton login;
	public JButton confirm;
	public JPanel loginPanel;
	public ArrayList<BallotObject> ballotInfo;
	public ArrayList<ID> userInfo;
	
	static ArrayList <JButton> buttonAlist = new ArrayList <JButton> ();
	static ArrayList <ArrayList<JButton>> seperateButtonL = new ArrayList<ArrayList<JButton>>();
	static ArrayList <String> winnerL = new ArrayList <String> ();
	static boolean _login = false;
	static int voterID;
	
	//Creates and adds to Panels
	public Window(ArrayList<BallotObject> ballotInfo, int balNum){
		this.ballotInfo = ballotInfo;
		this.userInfo = userInfo;
		int i = balNum;
		System.out.println(i +" = " + Ballot.numCategories);
		// adds ballot buttons
		if(i < Ballot.numCategories){
			setLayout(new GridLayout(10,0,20,20));
			
			
			ArrayList<JButton> bList = new ArrayList<JButton>();
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
				buttonAlist.add(btn);
				add(btn);                 
				btn.addActionListener(new ButtonHandler());
				bList.add(btn);
		
				}
			seperateButtonL.add(bList);	
		}	
		//adds confirm and login buttons
		else if(i == (Ballot.numCategories)){
			setLayout(new FlowLayout(FlowLayout.CENTER));
			login = new JButton();
			confirm = new JButton();
			login.setText("Login");
			confirm.setText("Confirm Vote");
			confirm.setEnabled(false);
			add(login);
			add(confirm);
			login.addActionListener(new thehandler());
			confirm.addActionListener(new ConfirmHandler());
			System.out.println("Login and confirm have been made");
			
		}
		
	
	}
	//Listener to login user when clicked
	class thehandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			int Break = 0;
			boolean LOOGIN = false;
			String inputValue = JOptionPane.showInputDialog("Please input your voter ID");
			int numInput = Integer.parseInt(inputValue);
			ArrayList<ID> userInfo;
			VoterID file = new VoterID();
			file.readFile();
			userInfo = file.getID();
			voterID = numInput;
			for(ID id: userInfo){
				LOOGIN = id.checkID(voterID);
				if(id.getBool() == false){
					if(LOOGIN == true){
						Window.login.setEnabled(false);
						Break = 1;
						for( JButton btn : buttonAlist){
							btn.setEnabled(true);
						}
					confirm.setEnabled(true);	
					}
					}
				else if(id.getBool() == true){
					if(LOOGIN == true){
						JOptionPane.showMessageDialog(null, "You have already voted!");
					}
				}
					if(Break == 1)
						break;
				}			
			}
			
				
			
			
		}
	//Listener to change button colors when clicked
	class ButtonHandler implements ActionListener{
		public JButton _btn;
		public String winner;
		public void actionPerformed(ActionEvent e){
			for(ArrayList<JButton> bList: seperateButtonL){
				for(JButton btn: bList){
					if(btn == e.getSource()){
						for(JButton _btn: bList){
							_btn.setForeground(null);
						}
						btn.setForeground(Color.RED);
						winner = btn.getText();
					}
				}
				
			}
			
					 
				}
			}
	//Listener for when confirm button is clicked
	class ConfirmHandler implements ActionListener{
		
		public String WINNER;
		public Color RED;
		
		public void actionPerformed(ActionEvent e){
			ArrayList<ID> userInfo;
			VoterID file = new VoterID();
			file.readFile();
			userInfo = file.getID();
			//Searches through all buttons and add red buttons to an arraylist
			if (JOptionPane.showConfirmDialog(null, "Confirm", "Are you sure", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				for(ArrayList<JButton> bList: seperateButtonL){
					for(JButton btn: bList){
						if(btn.getForeground() == Color.RED){
							WINNER = btn.getText();
							winnerL.add(WINNER);
						} 
						
					}
				}
			//goes through each BallotObject and compares winners against all others
			int i = 0;	
			
			for(BallotObject ballot: ballotInfo){	
				ballot.compareInfo(winnerL, i);
				i++;
			}
			//goes through each user and updates list if they voted
			for(ID id: userInfo){
				if(voterID == id.number){
					id.checkUser(true);
				}
				}
		try{
			File filee = new File("Voters.txt");	
			PrintWriter w = new PrintWriter(filee);
			
			for(ID id: userInfo){
				w.println(id.toStr());
			}
			
			w.close();
			
			
			
			
			
			
		}
		catch(IOException exc){
			System.out.println("Error");
			exc.printStackTrace();
		}
		
		
		//resets GUI to original status and functionality
		for(ArrayList<JButton> bList: seperateButtonL){
					for(JButton btn: bList){
						btn.setEnabled(false);
						btn.setForeground(null);
					}
		}
		confirm.setEnabled(false);
		login.setEnabled(true);
		
			}
			}
			
		}
	}
	

		
	
	
