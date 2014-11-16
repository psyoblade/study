package nc.java.study.util;

public class SimpleSingleTon {
	private final static SimpleSingleTon instance = new SimpleSingleTon();
	private SimpleSingleTon() {}
	public SimpleSingleTon getInstance() {
		return instance;
	}
}
