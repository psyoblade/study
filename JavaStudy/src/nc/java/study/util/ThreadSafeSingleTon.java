package nc.java.study.util;

public class ThreadSafeSingleTon {
	private static volatile ThreadSafeSingleTon INSTANCE;
	private ThreadSafeSingleTon() {}
	public ThreadSafeSingleTon getInstance() {
		if (INSTANCE == null) {
			synchronized (ThreadSafeSingleTon.class) {
				INSTANCE = new ThreadSafeSingleTon();
			}
		}
		return INSTANCE;
	}
}
