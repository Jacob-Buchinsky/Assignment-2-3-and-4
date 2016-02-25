import java.util.*;

public class card{
	int suitNum;
	public int faceNum;
	int i = 0;
	
	
	final private static String[] SuitAr = {"s", "h", "d", "c"};
	final private static String[] FaceAr = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
	
	//Arrays containing possible suits and face values
	public card(){
		
		Random random = new Random();
		int r = random.nextInt(4);
		suitNum = r;
		Random random2 = new Random();
		int r2 = random2.nextInt(12);
		faceNum = r2;
		
		//when a card is created a random number correlating to the length of its respective array is created
	}
	public int getSuit(){
		
		return suitNum;
		
		
	}
	public int getFace(){
		
		
		return faceNum;
		
	}
	 public String toString()
    {
        String str = FaceAr[faceNum] + SuitAr[suitNum];
		System.out.println(str);
		return str;
		
    //r and r2 are locations within the array, takes the values stored in the arrays an puts them together as a string before returning
}
}