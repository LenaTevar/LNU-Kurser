INSTRUCTIONS

1. Open cmd/terminal and navigate to the folder 
where the .jar file is located

2. Run "java -jar NAME.jar"

CHANGES

• Deleted comments, teacher already knows. 
• Enum UserInput added because I got that dependency from Assignment 2 feedback but not on time 
to change it here, anyways, here it is!
• Small change in Observer, but actually is big. 
	• Player gets observers instead of the Dealer
	• Added IObservable (see below)

Observable

During this time I've been looking for more information about implementing an Observer. 

I found another way to solve this exercise by using the interfaces IObserver and IObservable. 

I do not think this is needed, I could just change the methods I used previously in the Dealer 
into Player (And that is the big change, now the owner of the subscribers list is the player class),
 but I think it looks better this way. Again, this exercise is short enough to navigate through 
the classes, but if it was bigger and I see that PlayGame implements IObserver, I can see easily
 an IObservable interface and check the methods without searching the actual class implementing .
