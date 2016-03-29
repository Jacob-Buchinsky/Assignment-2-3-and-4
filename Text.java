import java.util.*;
import java.io.*;
import java.text.*;
public class Text {
	//declare variables
	int count = 0;
	ArrayList <Question> list;
	
	
	public void readFile (String file){
		//create new File object containing info for quiz
		File textDoc = new File("Quiz.txt");
		list = new ArrayList <Question>();
		
		// Reads each line of quiz text and sets variables
		try{ 
			Scanner s = new Scanner(textDoc);
			while (s.hasNextLine()) {
				String question = s.nextLine();
				int numAnswers = Integer.parseInt(s.nextLine());
				String[] answers = new String[numAnswers];
				//Adds possible answers to an array of size specified in quiz text
				for(int j = 0; j < numAnswers; j++)
					answers[j] = s.nextLine();
				int corAnswer = Integer.parseInt(s.nextLine());
				int tried = Integer.parseInt(s.nextLine());
				int correct = Integer.parseInt(s.nextLine());
				//creates Question object with parameters equal to info from quiz text
				Question question1 = new Question(question, numAnswers, answers, corAnswer, tried, correct);
				//adds Question objects into an array list
				list.add(question1);
				
			}
			s.close();
		}
		catch (Exception e){
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}	
	public ArrayList<Question> getList(){
		return list;
	}
	public static void writeToFile(ArrayList<Question> list) throws IOException{
		PrintWriter writer = new PrintWriter("Quiz.txt");
		for(int i = 0; i < list.size(); i++){
			Question question = list.get(i);
			String q = question.getQuestion();
			int na = question.getNumAnswers_();
			String[] answers = question.getAnswers();
			int ca = question.getCorrectAnswer();
			int t = question.getTried();
			int c = question.getCorrect();
			writer.println(q);
			writer.println(na);
			for(String a: answers){
				writer.println(a);
			}
			writer.println(ca);
			writer.println(t);
			writer.println(c);
		}
		writer.close();
		
			
		
	} 
	
			
		
	 

	
}