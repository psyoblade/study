package com.sun.java.puzzlers.maze;

public interface Maze {
	public void init();
	public void generate();
	public void printMaze();
	public void printHistory();
	public void findShortestPath() throws Exception;
}
