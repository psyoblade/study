package com.jenkov.tutorials;

public class JavaEnums {
	public enum Level {
		HIGH 	(9),
		MEDIUM 	(5),
		LOW 	(0)
		;
		private final int level;
		Level(int level) { // why not public
			this.level = level;
		}
		public int getValue() {
			return this.level;
		}
	}
}
