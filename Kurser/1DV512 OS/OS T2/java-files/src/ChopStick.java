import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {
	private final int id;
	Lock myLock = new ReentrantLock();
	
	public ChopStick(int id) {
		this.id = id;
	}

	public boolean pickUp() {
		return myLock.tryLock();
	}
	
	public void putDown() {
		myLock.unlock();
	}
	
	public int getId() {
		return this.id;
	}
	
}
