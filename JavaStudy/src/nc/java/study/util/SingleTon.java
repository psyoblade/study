package nc.java.study.util;

import java.util.HashMap;
import java.util.Map;

public class SingleTon {
	private static SingleTon m_singleton = null; 
	private static Map<String, String> map = null;
	private SingleTon() {
		System.out.println("constructor called...");
		map = new HashMap<String, String>();
		map.put("psyoblade", "park.suhyuk@gmail.com");
	}
	public static SingleTon getInstance() {
		if (m_singleton == null) {
			m_singleton = new SingleTon();
		}
		return m_singleton;
	}
	
	public boolean contains(String key) {
		return map.containsKey(key);
	}
	
	public String get(String key) {
		return map.get(key);
	}
}
