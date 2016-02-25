import java.io.*;
import java.util.*;
import java.text.*;


public class blackjack{
	public static void main(String [] args){
		int total = 0;
		int b = 0;
		double Money = 100.00;
		int Hands = 0;
		int Won = 0;
		int playerAces = 0;
		int dealerAces = 0;
		int faceNum = 0;
		int face = 0;
		int suit = 0;
		int sum = 0;
		int sum2 = 0;
		double bet = 0.00;
		char c;
		char cUpper;
		int suit3 = 0;
		int suit4 = 0;
		int suit5 = 0;
		int suit6 = 0;
		int face3 = 0;
		int face4 = 0;
		int face5 = 0;
		int face6 = 0;
		int play = 0;
		boolean bust = false;
		boolean bust2 = false;
		String Name;
		String card;
		
		List<Integer> arrlist = new ArrayList<Integer>();
		List<Integer> arrlist2 = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("What is your name?");
		Name = scanner.nextLine();
		player g = new player(Name);
		System.out.println("Hello " + Name);
		Money = g.getMoney();
		Hands = g.getHands();
		Won = g.getWon();
		System.out.println(Money);
		// generates lists to hold card values for player and dealer, asks for name and creates new player with that name
		mainLoop:
		while(true){
			if (Money <= 0){
				System.out.println("YOU'RE BROKE GO HOME!");
				break;
			}
			
			arrlist.clear();
			arrlist2.clear();
			sum = 0;
			sum2 = 0;
			bust = false;
			bust2 = false;
			while(true){
				try{
					System.out.println("Would you like to play? (1=yes/2=no)");
					String playStr = scanner.nextLine();
					play = Integer.parseInt(playStr);
				}
				catch(Exception e)
				{ play = 5;}
				if(play == 2)
					break mainLoop;
				else if(play == 1)
					break;
		//Main loop of program resets arrays and asks if the player would like to play again		
			}
			System.out.println("Money: " + Money); 
			System.out.println("Hands Played: " + Hands);
			System.out.println("Hands Won: " + Won);
			System.out.println("Place your bet: ");
			while(true){
				try{ 
					bet = scanner.nextDouble();
					DecimalFormat df = new DecimalFormat("#.##");
					double d = Double.parseDouble(df.format(bet));
					bet = d;
					if(bet <= 0){
						throw new Exception();
					}
					break;
				}
				catch(Exception e){
					System.out.println("Invalid Input");
					scanner.next();
					System.out.println("Place your bet: ");
				}
			}		
		
		
			Money = Money - bet;
			Hands++;
			// displays money, hands played and hands won. Subtracts the money betted.
			System.out.println("Your First Cards Are: ");
			
			card Card = new card();
			Card.getSuit();
			Card.getFace();
			Card.toString();
			
			if(Card.getFace() > 9)
				arrlist.add(10);
			if(Card.getFace() == 0){
				arrlist.add(11);
				playerAces++;}
			if(Card.getFace() != 0 && Card.getFace() <= 9)
				arrlist.add(Card.getFace() + 1);
			
			card Card2 = new card();
			Card2.getSuit();
			Card2.getFace();
			Card2.toString();
			
			if(Card2.getFace() > 9)
				arrlist.add(10);
			if(Card2.getFace() == 0){
				arrlist.add(11);
			playerAces++;}
			if(Card2.getFace() != 0 && Card2.getFace() <= 9)
				arrlist.add(Card2.getFace() + 1);
			for( int num : arrlist)
				sum = sum + num;
			//first 2 cards are created with necessary exceptions for Aces and face cards
				
				
			boolean loopThrough = true;
			boolean gotBlackjack = false; 		
			if(sum == 21){
				System.out.println("BLACKJACK!!!");
				Money = Money + (bet*2.5);
				Won++;
				loopThrough = false;
				gotBlackjack = true;
			}
				
			while(loopThrough){
				
				sum = 0;
				System.out.println("[H]it or [S]tay?");
				
				c = scanner.next().charAt(0);
				cUpper = Character.toUpperCase(c);
			
				if (cUpper == 'H'){
					card Card3 = new card();
					suit = Card3.getSuit();
					face = Card3.getFace();
					Card3.toString();
					if(Card3.getFace() > 9)
						arrlist.add(10);
					if(Card3.getFace() == 0){
						arrlist.add(11);
						playerAces++;
					}
					if(Card3.getFace() != 0 && Card3.getFace() <= 9)
						arrlist.add(Card3.getFace() + 1);
					
					for( int num : arrlist) {
						sum = sum + num;
					}
					
					
					sum = getScore(sum, playerAces);
					if(sum > 21){
						System.out.println("Player Busted");
						bust = true;
						break;
					}
				}		
				
				if(cUpper == 'S'){
					for( int num : arrlist)
						sum = sum + num;
					break;
				}
					
			}
				// Loop where player can hit or stay, each hit generates a new card and totals values. If the total value is > 21 bust is set to true
			if(bust == false){
				sum2 = 0;
				System.out.println("The house's cards are: ");
				card Card4 = new card();
				Card4.getSuit();
				Card4.getFace();
				Card4.toString();
			
				if(Card4.getFace() > 9)
					arrlist2.add(10);
				if(Card4.getFace() == 0){
					arrlist2.add(11);
					dealerAces++;
				}
					
				if(Card4.getFace() != 0 && Card4.getFace() <= 9)
					arrlist2.add(Card4.getFace() + 1);
				
				card Card5 = new card();
				Card5.getSuit();
				Card5.getFace();
				Card5.toString();
				
				if(Card5.getFace() > 9)
					arrlist2.add(10);
				if(Card5.getFace() == 0){
					arrlist2.add(11);
					dealerAces++;
				}
				
				if(Card5.getFace() != 0 && Card5.getFace() <= 9)
					arrlist2.add(Card5.getFace() + 1);
				for( int num : arrlist2)
					sum2 = sum2 + num;
				while(sum2 < 17 || (sum2 == 17 && arrlist2.contains(11))){
					sum2 = 0;
					card Card6 = new card();
					suit = Card6.getSuit();
					face = Card6.getFace();
					Card6.toString();
					if(Card6.getFace() > 9)
						arrlist2.add(10);
					if(Card6.getFace() == 0){
						arrlist2.add(11);
						dealerAces++;
					}
					
					if(Card6.getFace() != 0 && Card6.getFace() <= 9)
						arrlist2.add(Card6.getFace() + 1);
					for( int num : arrlist2)
						sum2 = sum2 + num;
				
					sum2 = getScore(sum2, dealerAces);
					if(sum2 > 21){
						System.out.println("Dealer Busted");
						Money = Money + (bet*2);
						Won++;
						bust2 = true;
						break;
					}
				}//Generates house cards 
						
			}		
				if((sum > sum2) && (bust == false) && (gotBlackjack == false)){
					System.out.println("Player Won!");
					Money = Money + (bet*2);
					Won++;
				}
				if (sum == sum2){
					System.out.println("PUSH");
					Money = Money + bet;
				}
				if ((sum < sum2) && (bust2 == false)) {
					System.out.println("Dealer Won");
				}
		}
		//Non-Bust win conditions
		
		Hands = Hands - 1;
		g.Write(Money, Hands, Won);	
		g.closeFile();	
	}
		//Saves information to file	
		
		
			
		
		
	
		
		
	

		
		
		   /**
     * This method accepts the number of base points and the number
     * of aces and calculates a final Blackjack score. 
     * It assumes that all aces are originally calculated as 11 points
     * each!
     * @param points - Total number of points in hand
     * @param numAces - number of ace cards in hand
     * @return int - Correct Blackjack score of hand
     */
    
    private static int getScore(int points, int numAces) {
	int score = 0;

	// If there are no aces, or if score is less than 21 with aces at
	// 11 points each, then the actual score is just
	// equal to the number of points.
	
	if (numAces == 0 || points <= 21) {
	    score = points;
	} else {

	    // Otherwise, we need to check what is the BEST score is,
	    // and that gets a little complicated.  We set a placeholder
	    // -1 for best score, and a placeholder potential score.
	    // We will keep track of what the best score is, and try
	    // different potential scores against it.  Whatever is
	    // highest without going over 21 will win as the best score.
	    
	    int bestScore = -1;
	    int potentialScore = points;

	    // Loop through _number of aces_ times.  Each time, try an
	    // increasing number of aces as a 1 value instead of an
	    // 11 value (thus, subtract 10 * j from the total points
	    // value, which assumes all Aces are equal to 11 points).
	    
	    for (int j = 0; j <= numAces; j++) {
		potentialScore = (points - (10 * j));

		// For each iteration, if the potential score is
		// better than the already-best score, but it is NOT
		// over 21 (causing us to bust), then the
		// potential score should count as our new best score.
		
		if (potentialScore > bestScore && potentialScore <= 21) {
		    bestScore = potentialScore;
		}
	    }

	    // We could have busted even when all of our aces were set
	    // to one point.  In this case, we might never have gotten a
	    // valid "best" score.  But our best potential score is the closest
	    // to a best score we have, so we will replace our placeholder -1
	    // best with the best potential score we got.

	    // Otherwise, just set the score to the best score.
	    
	    if (bestScore == -1) {
		score = potentialScore;
	    } else {
		score = bestScore;
	    }
	}
	return score;
    }
}
