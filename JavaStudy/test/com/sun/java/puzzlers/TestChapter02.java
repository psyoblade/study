package com.sun.java.puzzlers;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import com.sun.java.puzzlers.maze.Maze;
import com.sun.java.puzzlers.maze.RandomMaze;

public class TestChapter02 {

	public void test() {
		fail("Not yet implemented");
	}
	
	public void testTimeForAChange() {
		long micro_seconds = 24 * 60 * 60 * 1000 * 1000; // overflow occurred
		long milli_seconds = 24 * 60 * 60 * 1000;
		System.out.println(micro_seconds / milli_seconds);
		assertTrue(micro_seconds / milli_seconds == 1000);
	}

	public void testStackClass() {
		final int maxStackSize = 30;
		Stack stack = new StaticStack(maxStackSize);
		Random random = new Random();
		while (!stack.isFull()) {
			try {
				stack.push(random.nextInt(maxStackSize));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		while (!stack.isEmpty()) {
			try {
				System.out.println(stack.pop());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	/**
	 * 임의의 난수로 만들어진 미로에서 최적의 경로를 찾아내기.
	 */
	public void findShortestPathInRandomMaze() throws Exception {
		final int rows = 20;
		final int cols = 50;
		final double rate = 0.8;
		Maze maze = new RandomMaze(rows, cols, rate);
		maze.generate();
		maze.printMaze();
		maze.findShortestPath();
		maze.printHistory();
	}
}
