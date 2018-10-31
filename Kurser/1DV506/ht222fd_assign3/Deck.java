package ht222fd_assign3;

import java.util.Random;

import ht222fd_assign3.Card.Ranks;
import ht222fd_assign3.Card.Suites;


public class Deck {
	Card [] arrDeck = new Card [52];
	private int dealCounter = 0;
	
	public Deck (){
		NewDeck();
	}


	public void NewDeck (){
		for (int i = 0; i < arrDeck.length; i++){
			for (Ranks r: Ranks.values()){
				for (Suites s : Suites.values()){
					Card newDeckCard = new Card(s, r);
					arrDeck[i] = newDeckCard;
					i++;
				}//for suites
			}//for ranks
		}//for i new deck
	}//Method newDeck
	
	public Card Deal (){
		/*Card Deal:
		 * I wrote that if() just to check
		 * the size of arrDeck. I tried this
		 * exercise with List but it was a mess.
		 * I feel that arrays are more reliable.
		 * */
		Card dealedCard = arrDeck[dealCounter];
		if (dealCounter <= arrDeck.length-1){

//			System.out.print(dealCounter + " - ");
			dealCounter++;
			}
		return dealedCard;
	}

	public void Shuffle (){

		Random rndShuffle = new Random ();
		dealCounter = 0;

		for (int i = 0; i < arrDeck.length; i++) {
			int rndPlace = rndShuffle.nextInt(52);
			Card tempShuffle = arrDeck[i];

			arrDeck[i] = arrDeck[rndPlace];
			arrDeck[rndPlace] = tempShuffle;
		}

	}


	public Boolean Patience (){
		/*Boolean Patience:
		 * Combinatorics, yeah!
		 * Prob. to lose = 1 - (2/3)^12
		 * = 1 - 4096/531441 = 0,99...
		 * */
		
		this.Shuffle();
		int patiDraw = 1;
		/*int patiDraw:
		 * At the first draft I used a for loop
		 * but it was another mess. I use my own
		 * "counter" as patiDraw to have more
		 * control over my variables.
		 * */
		for (int i = 0; i <= arrDeck.length-1; i++) {
			
				Card patiCard = Deal();
				if (patiDraw > 3)
					patiDraw = 1;
				
				if( patiDraw == patiCard.getValue()){
//					System.out.println( "\nNumber " + patiDraw + " == " + patiCard.toString());
//					System.out.println("You lose");
					return false;
				}//if 1
				else{
					patiDraw++;
				}
					
			
		}//for length
//		System.out.println("WIN <<<<<<<<<<<");
		return true;
	}

	public int HowMany(){
		int howMany = 52-dealCounter;
		return howMany;
	}
	
	
	public String ArrToString() {
		String allCardsStr = "DECK \n";
		for (int i = dealCounter; i < arrDeck.length; i++) {
			Card card = arrDeck[i];
			String out = card.toString();
			allCardsStr += out;
		}
		
		return allCardsStr;
	}

}// DECK


