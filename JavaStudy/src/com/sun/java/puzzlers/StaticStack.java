package com.sun.java.puzzlers;

public class StaticStack implements Stack {
	final Object[] stack;
	final int maxStackSize;
	int position;
	
	public StaticStack(int maxStackSize) {
		this.stack = new Object[maxStackSize];
		this.maxStackSize = maxStackSize;
		this.position = 0;
	}

	@Override
	public boolean isFull() {
		return position == maxStackSize ? true : false;
	}

	@Override
	public boolean isEmpty() {
		return position == 0 ? true : false;
	}

	@Override
	public void push(Object val) throws Exception {
		if (isFull()) throw new Exception("스택 오버플로우.");
		stack[position++] = val;
	}

	@Override
	public Object pop() throws Exception {
		if (isEmpty()) throw new Exception("스택 언더플로우.");
		Object o = stack[--position];
		return o;
	}

}
