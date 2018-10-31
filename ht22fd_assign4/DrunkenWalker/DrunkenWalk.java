package ht22fd_assign4.DrunkenWalker;


public class DrunkenWalk {


	/*VARIABLES*/

    private Point origin;
    private Point current;
    private int sizeMap;
    private int steps;
    private int stepsDone=0;
    private boolean wet = false;

    //NEW VARIABLES DIFFERENT FROM RANDOMWALK.JAVA
    private int numberPeople;
    private int totalPeopleDead = 0;


    /*CONSTRUCTORS*/
    public DrunkenWalk(int max, int size, int people){
        setSteps(max);
        setSizeMap(size);
        setNumberPeople(people);
        setCurrent(new Point (0,-size));
    }

    public DrunkenWalk(){
        setSteps(1);
        setSizeMap(1);
        setCurrent(new Point (0,-1));
    }
	/*METHODS*/

    /*Method horde:
     * A number of people will walk a number of steps
     * until they finish or die
     * */
    public void horde(){
        for(int i = 0; i < getNumberPeople(); i++){
            //System.out.println("\n\nPerson: " + (i+1));
            setStepsDone(0);
            setWet(false);
            setCurrent(new Point (0,-getSizeMap()));
            walk();
        }
        statistic();
    }

    /*Method statistic:
     * It prints the % of people wet.
     * */
    private void statistic(){
        float percent = getTotalPeopleDead() * 100 / getNumberPeople();
        System.out.println("\n=============\n"+" STATISTICS "+"\n=============");
        System.out.println("\nOut of " + getNumberPeople() + " drunk people, "
                + getTotalPeopleDead() + " (" + percent + " %) fell into the water");
    }

    /*Method Walk:
     * Simulates a random walk, N steps are taken until
     * the maximum number of steps has been taken or until
     * a step goes outside the boundary plane.*/
    public void walk(){
        //System.out.println("PROCESSING STEPS");
        for (int i = 0; i < getSteps(); i++){
            takeStep();
            if (!inBounds()){
                setTotalPeopleDead(getTotalPeopleDead()+1);
                //System.out.println(" In Bounds: " + inBounds());
                //System.out.println(" Last step: " + toString());
                break;
            }
        }
		/*if (inBounds()){
			System.out.println(" The walker arrived home safely in "
					+ current.toString());
		}*/
    }

    /*Method takeStep:
     * */
    private void takeStep(){

        int dice = (int) (Math.random() * 4 + 1);
        switch (dice) {
            //UP
            case 1:
                current.setpointY(current.getpointY() + 1);
                break;
            //DOWN
            case 2:
                current.setpointY(current.getpointY() - 1);
                break;
            //LEFT
            case 3:
                current.setpointX(current.getpointX() + 1);
                break;
            //RIGHT
            case 4:
                current.setpointX(current.getpointX() - 1);
                break;
			/*I'm not using a default case because there is no user choosing
			 * it's the dice the one that choose, so it's never more than 4 or less than 1.
			 * */

        }//END SWITCH

        setStepsDone(getStepsDone() + 1);
        //System.out.println(" Step done: "+getStepsDone());

		/*If the walker is wet, it cannot go further. Probably because
		 * wet clothes are really uncomfortable.
		 * */
    }

    /*Method moreSteps:
     *  returns true if the number of steps taken is less than the maximal
     *  number of steps, otherwise false is returned.
     *  Not using it because.. well.. i don't need it.
     * */
    public boolean moreSteps(){
        if (getStepsDone()<getSteps()){ return true; }
        else
            return false;
    }

    /*Method inBounds:
     * To me the platform will be a line
     * with X = 0
     * */
    public boolean inBounds(){
        if (current.getpointX() != 0){
            return false;
        }
        else
            return true;
    }

    /*Method toString: self explanatory
     * */
    public String toString(){
        String toString =" " + current.toString() + " \n Steps Done so far: "+ getStepsDone();
        toString += " - People dead: " + getTotalPeopleDead();
        return toString;
    }

    /*GETTERS AND SETTERS*/
    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public Point getCurrent() {
        return current;
    }

    public void setCurrent(Point current) {
        this.current = current;
    }

    public int getSizeMap() {
        return sizeMap;
    }

    public void setSizeMap(int sizeMap) {
        this.sizeMap = sizeMap;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getStepsDone() {
        return stepsDone;
    }

    public void setStepsDone(int stepsDone) {
        this.stepsDone = stepsDone;
    }

    public boolean isWet() {
        return wet;
    }

    public void setWet(boolean wet) {
        this.wet = wet;
    }

    public int getNumberPeople() {
        return numberPeople;
    }

    public void setNumberPeople(int numberPeople) {
        this.numberPeople = numberPeople;
    }

    public int getTotalPeopleDead() {
        return totalPeopleDead;
    }

    public void setTotalPeopleDead(int totalPeopleDead) {
        this.totalPeopleDead = totalPeopleDead;
    }

	/*END GETTERS AND SETTERS*/

}