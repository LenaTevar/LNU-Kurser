# blackjack_java

Fork this code to work with java in workshop 3. This repo only contains java files.

# Changes
- Deleted comments, teacher already knows. 
- Enum UserInput added because I got that dependency from Assignment 2 feedback
but not on time to change it here, anyways, here it is!
- Small change in Observer, but actually is big. 
 - Player gets observers instead of the Dealer
 - Added IObservable (see below)

## Observable
During this time I've been looking for more information about implementing an Observer. 

I found another way to solve this exercise by using the interfaces IObserver and IObservable. 

I do not think this is needed, I could just change the methods I used previously in 
the Dealer into Player (And that is the big change, now the owner of the subscribers list
is the player class), but I think it looks better this way. Again, this exercise is
short enough to navigate through the classes, but if it was bigger and I see that
PlayGame implements IObserver, I can see easily an IObservable interface and check the
methods without searching the actual class implementing them. Same in the opposite way, 
If I check Player and I want to know more about the observer, I can check the interface 
faster than searching for the class implementing it. 