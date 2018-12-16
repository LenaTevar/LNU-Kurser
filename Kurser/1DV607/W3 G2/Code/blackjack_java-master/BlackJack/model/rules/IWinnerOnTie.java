package model.rules;

import model.Dealer;
import model.Player;

public interface IWinnerOnTie {
	boolean dealerWins(Player a_player, Dealer a_dealer, int maxScore);
}
