import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Window extends JPanel{
	public static JButton login;
	public JButton confirm;
	public JPanel loginPanel;
	public ArrayList<BallotObject> ballotInfo;
	public ArrayList<ID> userInfo;
	/*public JButton b1;
	public JButton b2;
	public JButton b3;
	public JButton b4;
	public JButton b5;
	*/
	
	static ArrayList <JButton> buttonAlist = new ArrayList <JButton> ();
	static ArrayList <ArrayList<JButton>> seperateButtonL = new ArrayList<ArrayList<JButton>>();
	static ArrayList <String> winnerL = new ArrayList <String> ();
	static boolean _login = false;
	static int voterID;
	
	public Window(ArrayList<BallotObject> ballotInfo, int balNum){
		this.ballotInfo = ballotInfo;
		this.userInfo = userInfo;
		int i = balNum;
		System.out.println(i +" = " + Ballot.numCategories);
		
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
				add(btn);                 //adding to frame
				btn.addActionListener(new ButtonHandler());
				bList.add(btn);
		
				}
			seperateButtonL.add(bList);	
		}	
		else if(i == (Ballot.numCategories)){
			setLayout(new FlowLayout(FlowLayout.CENTER));
			login = new JButton();
			confirm = new JButton();
			login.setText("Login");
			confirm.setText("Confirm Vote");
			add(login);
			add(confirm);
			login.addActionListener(new thehandler());
			confirm.addActionListener(new ConfirmHandler());
			System.out.println("Login and confirm have been made");
			
		}
		
	
	}
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
			System.out.println("Monkeybutt");
			for(ID id: userInfo){
				System.out.println(_login);
				LOOGIN = id.checkID(voterID);
				System.out.println(LOOGIN);
				if(LOOGIN == true){
					Window.login.setEnabled(false);
					Break = 1;
				}
				if(Break == 1)
					break;
			}
			System.out.println(_login);
			if(LOOGIN == true){
				System.out.println("login = true");
				for( JButton btn : buttonAlist){
					System.out.println("Button has been enabled");
					btn.setEnabled(true);
				}
			}	
			
				
			
		}
	}
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
						
						System.out.println(winner);
					}
				}
				
			}
			
					 
				}
			}
	class ConfirmHandler implements ActionListener{
		
		public String WINNER;
		public Color RED;
		
		public void actionPerformed(ActionEvent e){
			ArrayList<ID> userInfo;
			VoterID file = new VoterID();
			file.readFile();
			userInfo = file.getID();
			if (JOptionPane.showConfirmDialog(null, "Confirm", "Are you sure", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				for(ArrayList<JButton> bList: seperateButtonL){
					for(JButton btn: bList){
						System.out.println(btn.getForeground());
						if(btn.getForeground() == Color.RED){
							WINNER = btn.getText();
							winnerL.add(WINNER);
							System.out.println("Winner Added");
						} 
						
					}
				}
			int i = 0;	
			
			for(BallotObject ballot: ballotInfo){	
				ballot.compareInfo(winnerL, i);
				i++;
			}
			System.out.println("AAAAAAAAAAAAAAAAAAAAAAA");
			for(ID id: userInfo){
				if(voterID == id.number){
					System.out.println("login = " + _login);
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
		catch(Exception killme){
			System.out.println("FUCKING DO IT");
			killme.printStackTrace();
		}
		
			}
			}
			
		}
}
	

		
	
	
