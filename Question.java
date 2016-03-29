import java.util.*;
import java.text.*;
public class Question {
		String q;
		int na;
		String[] answers;
		int ca;
		int t;
		int c;
		int count = 0;
		int count2 = 0; 
		boolean correct = false;
	public Question(String question_ , int numAnswers, String [] answers, int correctAnswer, int tried, int correct){
		q = question_;
		na = numAnswers;
		this.answers = answers;
		ca = correctAnswer;
		t = tried;
		c = correct;
	}
	// returns string of question and possible answers
	public String toString(){
		String retVal = q; 
		for(String ans: answers){
			retVal = retVal + "\n" + count + ":" + ans;
			count++;
		}
		return retVal;		
	}
	// returns string of question, correct answer and user answer	
	public String checkAnswerString(int userAns, int countQ){
		String retVal = q;
		retVal = "Question " + countQ + ":" + retVal + "\n" + "Answer: " + answers[ca] + "\n" + "Your Answer :" + answers[userAns];
		return retVal;
		
	}	
	// returns boolean and string based on correctness of user answer
	public boolean checkAnswer(int userAns, ArrayList<Integer> numAnswerArr, ArrayList<Question> list ){
		Text text = new Text();
		if( userAns == (ca)){
			System.out.println("YES! YES! YES!"+ "\n");
			t++;
			c++;
			
			
			return true;
		}
		else{
			System.out.println("NO! NO! NO! NO!"+ "\n");
			t++;
			return false;
		}
		
	}
	// returns string of question and cumulative statistics
	public String compareAnswerString(){
		DecimalFormat df = new DecimalFormat("#.##");
		String retVal = q;
		retVal = "Question: " + q + "\n" + "Times Tried: " + t + "\n" + "Times Correct: " + c + "\n" + "Percent Correct: " + df.format((((float)c /t)*100)) +"\n";
		return retVal;
	}
	public void difficultyQuestionDisplay(double[] Pct){
		if(Pct[0] == (((double)c/t)*100)){
			System.out.println("Most Difficult Question");
			System.out.println(compareAnswerString());
		}
		else if((Pct[Pct.length-1] == (((double)c/t)*100))){
			System.out.println("Easiest Qustion");
			System.out.println(compareAnswerString());
		}
		
	}
	public double savePct(){
		double percent = (((double)c/t)*100);
		return percent;
	}
	public int getNumAnswers_(){
		return na;
	}
	public String getQuestion(){
		return q;
	}
	
	public String[] getAnswers(){
		return this.answers;	
	}
	public int getCorrectAnswer(){
		return ca;
	}
	public int getTried(){
		return t;
	}
	public int getCorrect(){
		return c;
	}
}	