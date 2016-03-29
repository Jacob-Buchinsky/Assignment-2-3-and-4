import java.util.*;
import java.util.Arrays;
import java.io.*;
import java.text.*;
public class Quiz{
	
	public static void main(String[] args)throws IOException{
		//Initialize Variables
		int userAns = 0;
		int count = 0;
		int count2 = 0;
		int countQ = 0;
		int listCount = 0;
		ArrayList <Question> list;
		
		//Create Arraylists for user answers and number of answers
		Text text = new Text();
		text.readFile("Quiz.txt");
		list = text.getList();
		ArrayList <Integer> userAnsArr;
		userAnsArr = new ArrayList <Integer>();
		ArrayList<Integer> numAnswerArr;
		numAnswerArr = new ArrayList <Integer>();
		
		//Runs the main part of the quiz
		for( Question question: list){
			System.out.println(question.toString());
			Scanner scanner = new Scanner(System.in);
			boolean invalidNum = false;
			int na = question.getNumAnswers_();
			do{
				invalidNum = false;
				try{
					userAns = Integer.parseInt(scanner.next());
				}
				catch(Exception e){
					invalidNum = true;
					continue;
				}
			}while(userAns < 0 || userAns > (na-1) || invalidNum == true );
			userAnsArr.add(userAns);
		}
		
		System.out.println("\n" + "Thanks for playing! So... how did you do?"+ "\n");
		//Checks user input against answers
		for( Question question: list){
			countQ++;
			System.out.println(question.checkAnswerString(userAnsArr.get(listCount), countQ));
			boolean isCorrect = question.checkAnswer(userAnsArr.get(listCount), numAnswerArr, list);
			listCount++;
			if(isCorrect == true){
				count++;
				text.writeToFile(list);
				
			}
			else{
				count2++;
				text.writeToFile(list);
			}
		}
		displayResult(count, count2, countQ);
		
		for(Question question : list){
			numAnswerArr.add(question.getNumAnswers_());
		}
				
		// shows cumulative percent of correct answer for each question
		System.out.println("Here are some statistics:");
		ArrayList <Double> questionPctArr;
		questionPctArr = new ArrayList <Double>();
		for( Question question: list){
			questionPctArr.add(question.savePct());
			System.out.println(question.compareAnswerString());
		}
		double[] Pct = new double[questionPctArr.size()];
		int i = 0;
		for(double pct: questionPctArr){
			Pct[i] = pct;
			i++;
		}
		Arrays.sort(Pct);
		System.out.println("\n" + "These were the hardest and easiest questions:" + "\n");
		for(Question question: list){
			question.difficultyQuestionDisplay(Pct);
		}
		
		
		
		
	}
	// displays right, wrong, and pct correct
	public static void displayResult(float count, float count2, float countQ){
		System.out.println("Your Results: ");
		System.out.println("Right: " + (int)count);
		System.out.println("Wrong: " + (int)count2);
		System.out.println("Percent: " + ((count/countQ)*100)+"%");
	}
	
}