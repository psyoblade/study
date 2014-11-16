package com.sun.java.puzzlers;

public interface Stack {
	public boolean isFull();
	public boolean isEmpty();
	public void push(Object val) throws Exception;
	public Object pop() throws Exception;
}
