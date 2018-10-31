package ht22fd_assign4.DrunkenWalker;


public class RandomWalk {
	/*VARIABLES*/

    private Point origin;
    private Point current;
    private int sizeMap;
    private int steps;
    private int stepsDone=0;
    //private boolean wet = false;


    /*CONSTRUCTORS*/
    public RandomWalk(int max, int size){
        setSteps(max);
        setSizeMap(size);
        setCurrent(new Point (0,0));
    }
    public RandomWalk(){
        setSteps(1);
        setSizeMap(1);
        setCurrent(new Point (0,0));
    }

    /*Method Walk:
     * Simulates a random walk, N steps are taken until
     * the maximum number of steps has been taken or until
     * a step goes outside the boundary plane.*/
    public void walk(){

        for (int i = 0; i < getSteps(); i++){
            takeStep();
            if (!inBounds()){
                System.out.println(" In Bounds: " + inBounds());
                System.out.println(" Last step: " + toString());
                break;
            }

        }
        if (inBounds()){
            System.out.println(" The walker arrived home safely in "
                    + current.toString());
        }
    }

    /*Method takeStep:
     * */
    public void takeStep(){

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

		/*If the walker is wet, it cannot go further. Probably because
		 * wet clothes are really uncomfortable.
		 * */
    }

    /*Method moreSteps:
     *  returns true if the number of steps taken is less than the maximal
     *  number of steps, otherwise false is returned.
     * */
    public boolean moreSteps(){
        if (getStepsDone()<getSteps()){ return true; }
        else
            return false;
    }

    /*Method inBounds:
     *
     * */
    public boolean inBounds(){
        if (current.getpointX()> sizeMap || // too right
                current.getpointX()< -sizeMap|| // too left
                current.getpointY()> sizeMap || // too up
                current.getpointY()< -sizeMap){ // too down
            return false;
        }
        else
            return true;
    }

    /*Method toString:
     * */
    public String toString(){
        String toString = current.toString() + " \n Steps Done so far: "+ getStepsDone();
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

	/*public boolean isWet() {
		return wet;
	}
	public void setWet(boolean wet) {
		this.wet = wet;
	}*/

	/*END GETTERS AND SETTERS*/
}