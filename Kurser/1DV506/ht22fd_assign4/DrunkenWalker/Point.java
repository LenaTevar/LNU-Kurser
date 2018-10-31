package ht22fd_assign4.DrunkenWalker;



public class Point {
    private int pointX;
    private int pointY;

    public Point (int x, int y){
        setpointX(x);
        setpointY(y);
    }

    public String toString(){
        String pointSTR = "x " + this.getpointX() + " -  y: " + this.getpointY();
        return pointSTR;
    }
    public int getpointX() {
        return pointX;
    }
    public void setpointX(int pointX) {
        this.pointX = pointX;
    }
    public int getpointY() {
        return pointY;
    }
    public void setpointY(int pointY) {
        this.pointY = pointY;
    }
}