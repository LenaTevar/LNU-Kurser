/*
 * File:	Process.java
 * Course: 	Operating Systems
 * Code: 	1DV512
 * Author: 	Suejb Memeti
 * Date: 	November, 2018
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class FCFS{

	// The list of processes to be scheduled
	public ArrayList<Process> processes;
	public Queue<Process> pQueue = new LinkedList<>();
	public Process currentP = null;
	public int counter = 0;
	public int currentBurst = 0;

	// Class constructor
	public FCFS(ArrayList<Process> processes) {
		this.processes = processes;
		this.sortList(processes);
	}

	public void run() {
		// TODO Implement the FCFS algorithm here		
		processes.forEach( p -> pQueue.add(p));
		
		while(!pQueue.isEmpty() || currentP != null) {
			
			/*My first options. Works fine but can be improved.*/
			/*while(!pQueue.isEmpty() && (currentP == null)) {					
				if(counter >= pQueue.peek().getArrivalTime()) {					
					currentP = pQueue.poll();
					currentBurst = currentP.getBurstTime();
				}	
				break;
			}*/
			
			/*Improved code from above. If there is no current process running, and 
			 * the first in queue has hit counter time, then poll it from queue. 
			 * */			
			if(currentP == null && counter >= pQueue.peek().getArrivalTime()) {
				currentP = pQueue.poll();
				currentBurst = currentP.getBurstTime();
			}
			
			/*If there was no process ready in queue, nor a process already running, 
			 * increment the counter and loop again.*/
			if(currentP == null) {
				counter++;
				continue;
			}
			
			/*If there is a process running: Add one to counter and decrease the 
			 * burst time. 
			 * If burst time reached 0, the process terminated. Set timers, release
			 * current process and reset current process burst time counter. */
			else if(currentP != null) {
				counter++;
				currentBurst--;
			
				if(currentBurst <= 0) {
					//Helper method to encapsulate arithmetic. 
					this.setTimers(currentP);
					currentP = null;
					currentBurst=0;
				}				
			}			
		}
		printGanttChart();
		printTable();
	}
	
	private void setTimers(Process fifoP) {
		fifoP.setCompletedTime(counter);
		fifoP.setTurnaroundTime(counter - fifoP.getArrivalTime());
		fifoP.setWaitingTime(fifoP.getTurnaroundTime() - fifoP.getBurstTime());
	}
	
	private void sortList(ArrayList<Process> mList) {
		mList.sort(new Comparator<Process>() {

			@Override
			public int compare(Process o1, Process o2) {
				return o1.getArrivalTime() - o2.getArrivalTime();
			}
			
		});
	}
	
	/*Beware, monsters below.*/
	public void printTable() {
		// TODO Print the list of processes in form of a table here
		ArrayList<Process> copyProcesses = new ArrayList<Process>(processes);
		
		StringBuilder top = new StringBuilder();
		StringBuilder middle = new StringBuilder("|");
		StringBuilder bottomtimers = new StringBuilder("0");
		String appendix = " \"x\" represent idle time.";
		int twoChars = 9;
		int sizeTwoChars = 2;
		
		for (int i = 0; i < copyProcesses.size(); i++) {
			Process p1 = copyProcesses.get(i);

			if (p1.getBurstTime()> sizeTwoChars) {
				String title = "P" + p1.getProcessId();
				String centered = center(title, p1.getBurstTime()) + "|";
				middle.append(centered);
			}
			else {
				String title = Integer.toString(p1.getProcessId());
				String centered = center(title, p1.getBurstTime())+ "|";
				middle.append(centered);				
			}
			
			if (p1.getCompletedTime() > twoChars) {
				bottomtimers.append(repeatedChar(" ", p1.getBurstTime()-1));
				bottomtimers.append(p1.getCompletedTime());
			} else {
				bottomtimers.append(repeatedChar(" ", p1.getBurstTime()));
				bottomtimers.append(p1.getCompletedTime());
			}
					
			try {
				Process p2 = copyProcesses.get(i+1);
				
				if (p1.getCompletedTime() < p2.getArrivalTime()) {
					int idleTime = p2.getArrivalTime() - p1.getCompletedTime();
					
					String idleStr = repeatedChar("x", idleTime) + "|";
					String idleBottom = repeatedChar(" ", idleTime) + p2.getArrivalTime();
					
					middle.append(idleStr);
					bottomtimers.append(idleBottom);
					
				}
			} catch (Exception e) {
				// DONOTHING
			}
			
		}
		
		top.append(repeatedChar("-", middle.length()));
		
		System.out.println(top.toString());
		System.out.println(middle.toString());
		System.out.println(top.toString());
		System.out.println(bottomtimers.toString());
		System.out.println(appendix);
	}

	public void printGanttChart() {
		// TODO Print the list of processes in form of a table here
		
		System.out.println("\n\n=======================FCFS ASSIGNMENT=======================");
				
				
		ArrayList<Process> copyProcesses = new ArrayList<Process>(processes);
				
		StringBuilder sb = new StringBuilder();
		sb.append("=============================================================\n");
		sb.append("\t ID \t AT \t BT \t CT \t TAT \t WT\t\n");
		sb.append("=============================================================\n");
		copyProcesses.forEach(p -> {
			sb.append(p.toString());
		});
		System.out.println(sb.toString());
	}
	

	/*FORMAT HELPERS*/
	private String repeatedChar(String c, int times) {
		return  String.join("", Collections.nCopies(times, c));
	}
	private String center(String text, int sLength) {
		String out = String.format("%"+sLength+"s%s%"+sLength+"s", "",text,"");
	    float mid = (out.length()/2);
	    float start = mid - (sLength/2);
	    float end = start + sLength; 
	    return out.substring((int)start, (int)end);
	}
}
