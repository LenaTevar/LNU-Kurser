# Notes
## Changes
- Changed to requirements grade 2.

*However, it was so much to change that sadly enough I wasn't able to finish grade 3 and 4 in time. Now I have two more courses to follow. Everything is piled up, so I hope grade 2 would be enough.*

- Less view classes.

*I do like the idea of smaller classes, but I got it, I over exceeded and over complicated the front end. Now it has less classes so it is easier to understand. *

- No integer as switch in Init controller. Now it uses enums from view. 

*That fixes dependencies with view and controller. No matter what happens in the front end, the controller will work through the enum.*

- Added a selected member and boat to work with in controller. 

*It makes sense that the controller is the one with the responsibility of the selected members and boats. I did not follow the answer gave by the teacher, because I though that well.. I should do it by myself instead of just* 
*copy pasting everything. I did used some examples from the teacher, but I wanted to stay in my way in this occasion.*

- Super important method that draws a boat in ascii changed to a smaller boat. 

*Following the path of Wasa, this boat crashed. Actually, after testing and testing, I got annoyed of the big boat. A smaller one does the same effect of "oh, look a boat". *
## Instructions 
1. Open cmd/terminal and navigate to the folder where the .jar file is located
2. Run "java -jar NAME_OF_THE_PROGRAM.jar"

### Option 2
Runnable version of Jar

# To Remember
Notes to remember for the future.
## Hidden Dependencies
### Wrong
```java
public class Foo (){
	public void doSomehting(){
		Bar myBar = new Bar();
		myBar.doSomethingElse();
	}
}
public class Bar(){
	public void doSomethingElse(){
	}
}
```

### Better
```java
public class Foo (){
	public void doSomehting(Bar myBar){
		myBar.doSomethingElse();
	}
}
public class Bar(){
	public void doSomethingElse(){
	}
}
```

### Much Better
```java
public class Foo (){
	Bar myBar;
	public Foo (Bar aBar){
		this.mybar = aBar;
		}
		}
	public void doSomehting(){
		
		myBar.doSomethingElse();
	}
}
public class Bar(){
	public void doSomethingElse(){
	}
}
```