package BlackJack;

import controller.PlayGame;
import model.Game;
import view.IView;
import view.SimpleView;

public class Program
{
/*
 * Changes: 
 * view display welcome message here so it doesn't
 * repeats each time you play the game. 
 * */
  public static void main(String[] a_args)
  {
  
    Game g = new Game();
    IView v = new SimpleView(); 
    PlayGame ctrl = new PlayGame(g,v);
    v.DisplayWelcomeMessage();
    while (ctrl.Play());
  }
}