package model.rules;

import model.Dealer;
import model.Deck;
import model.Player;

public interface INewGameStrategy {
    boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player);
}