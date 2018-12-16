import java.util.Random;
/*
 * Author: Helena Tevar ht222fd
 * 
 * Variables added:
 * PhiState state - Enum for setting philosophers states.
 * Boolean LOG - Flag to show/hide log of philosophers states.
 * Set LOG to true if you want to read the states of the philosophers.
 * 
 * Problems: 
 * It would happen sometimes (at least in my computer) that some counters
 * doesn't work properly, but after making a simple print to console, 
 * without any further code, the will work again. I have not found explanation
 * for this behaviour. 
 * */
public class Philosopher implements Runnable {
	
	private int id;
	
	private final ChopStick leftChopStick;
	private final ChopStick rightChopStick;
	
	private Random randomGenerator = new Random();
	
	private int numberOfEatingTurns = 0;
	private int numberOfThinkingTurns = 0;
	private int numberOfHungryTurns = 0;

	private double thinkingTime = 0;
	private double eatingTime = 0;
	private double hungryTime = 0;
	
	public PhiState state = null;
	public boolean LOG = false;
	/*
	 * Constructor.
	 * First state set is Thinking.
	 * */
	public Philosopher(int id, ChopStick leftChopStick, ChopStick rightChopStick, int seed) {
		this.id = id;
		this.leftChopStick = leftChopStick;
		this.rightChopStick = rightChopStick;
		state = PhiState.THINKING;
		randomGenerator.setSeed(id+seed);
	}
	
	
	
	public int getId() {
		return id;
	}

	public double getAverageThinkingTime() {		
		return thinkingTime/numberOfThinkingTurns;
	}

	public double getAverageEatingTime() {		
		return eatingTime/numberOfEatingTurns;
	}

	public double getAverageHungryTime() {
		return hungryTime/numberOfHungryTurns;
	}
	
	public int getNumberOfThinkingTurns() {
		return numberOfThinkingTurns;
	}
	
	public int getNumberOfEatingTurns() {
		return numberOfEatingTurns;
	}
	
	public int getNumberOfHungryTurns() {
		return numberOfHungryTurns;
	}

	public double getTotalThinkingTime() {
		return thinkingTime;
	}

	public double getTotalEatingTime() {
		return eatingTime;
	}

	public double getTotalHungryTime() {
		return hungryTime;
	}
	
	public PhiState getPhilosopherState() {
		return state;
	}

	/**
	 * 
	 * */
	@Override
	public void run() {
		
		/*
		 * Loop until DinningPhilosophers set all philosophers as DONE. 
		 * */
		while (state != PhiState.DONE) {
			
			int time = randomTime();
			
			try {
				/*Switch
				 *Each state changes the state to the next one. 
				 *Thinking -> Hungry -> Eating -> Thinking...
				 *In order to the sleep method calculate
				 *the time, it needs to be called before the 
				 *change of the state.
				 *
				 * */				
				switch (state) {
				/*In order to Sleep to work properly, it has to 
				 * be placed before the case changes the state
				 * of the philosopher. 
				 * For more information, check sleep() method.*/		
				case THINKING:
					if(LOG)
						this.printState();
					
					numberOfThinkingTurns++;					
					
					sleep(time);
					
					state = PhiState.HUNGRY;
					break;
					
				/*Philosopher will try to lock left chopstick.
				 * If is true, then will try to lock right chopstick.
				 * If is true, next state eating is set. 
				 * If is false, it will release left chopstick and wait.
				 * */
				case HUNGRY:
					if(LOG)
						this.printState();
					
					numberOfHungryTurns++;
					
					if(leftChopStick.pickUp()) {
						
						if (rightChopStick.pickUp()) {
							state = PhiState.EATING;
							break;
						} else {
							leftChopStick.putDown();						
						}
					}	
					
					sleep(500);					
					break;
					
				case EATING:
					if(LOG)
						this.printState();
					
					numberOfEatingTurns++;
					
					sleep(time);
					
					state = PhiState.THINKING;
					releaseChopsticks();
					break;
					
				default:
					break;
				}
			} catch (Exception e) {
				System.out.printf("\n\tP%s is interrupted while %s\n", id, state);
			}			
		}
	}
	
	/*
	 * This method manages the sleeping time and addition to the counters
	 * depending of the current state of the philosophers.
	 * (So I don't need to do it manually, automation
	 * is a better word than lazy)
	 * */
	private void sleep(int time) {
		try {
			
			Thread.sleep(time);
			
			switch (state) {
			case THINKING:
				thinkingTime+=time;
				break;
			case HUNGRY:
				hungryTime+=time;
				break;
			case EATING:
				eatingTime+=time;
				
				break;
			default:
				break;
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}
	
	public void printState() {
		System.out.printf("\nP%s is %s", id, state);
	}
	
	/*SetDone stops philosopher*/
	public void setDone() {
		state = PhiState.DONE;
	}
	
	private void releaseChopsticks() {		
		leftChopStick.putDown();
		rightChopStick.putDown();
	}
	
	public int randomTime() {		
		return randomGenerator.nextInt(1000);
	}
	
}
