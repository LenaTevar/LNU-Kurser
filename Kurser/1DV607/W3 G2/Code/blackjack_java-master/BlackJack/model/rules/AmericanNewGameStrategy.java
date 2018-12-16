package model.rules;

import model.Card;
import model.Dealer;
import model.Deck;
import model.Player;  

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    Card c;

    c = a_deck.GetCard();
    c.Show(true);
    a_player.DealCard(c);

    c = a_deck.GetCard();
    c.Show(true);
    a_dealer.DealCard(c);

    c = a_deck.GetCard();
    c.Show(true);
    a_player.DealCard(c);

    c = a_deck.GetCard();
    c.Show(false);
    a_dealer.DealCard(c);

    return true;
  }
}