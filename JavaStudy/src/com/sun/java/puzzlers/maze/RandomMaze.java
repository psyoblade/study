package com.sun.java.puzzlers.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMaze implements Maze {
	final int rows;
	final int cols;
	final int startX = 1;
	final int startY = 1;
	final int endX;
	final int endY;
	final Position endPosition;
	double randomRate; // 컬럼당 랜덤으로 생성될 통과가능한 길의 비율.
	int x = startX;
	int y = startY;
	int[][] maps;
	int[][] history;

	public RandomMaze(int rows, int cols, double randomRate) {
		this.rows = rows;
		this.cols = cols;
		this.randomRate = randomRate;
		this.endX = rows-1;
		this.endY = cols-1;
		this.endPosition = new Position(endX, endY);
		maps = new int[rows][cols];
		history = new int[rows][cols];
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	@Override
	/**
	 * 테두리는 이동할 수 없으므로, 갈 수 있는 길에서 제외
	 * 시작/끝 위치는 갈 수 있는 곳이어야 하므로 길에 포함
	 */
	public void generate() {
		Random random = new Random();
		for (int i = 1; i < rows-1; i++) {
			for (int j = 0; j < cols * randomRate; j++) {
				int row = i;
				int col = random.nextInt(cols-2)+1;
				maps[row][col] = 1; // 갈 수 있는 블록
			}
		}
		maps[startX][startY] = 1;
		maps[endX][endY] = 1;
	}

	@Override
	public void printMaze() {
		StringBuilder sb = new StringBuilder(rows * cols);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				sb.append(maps[i][j]);
			}
			sb.append("\n");
		}
		sb.append("\n");
		System.out.println(sb.toString());
	}
	
	@Override
	public void printHistory() {
		StringBuilder sb = new StringBuilder(rows * cols);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				sb.append(history[i][j]);
			}
			sb.append("\n");
		}
		sb.append("\n");
		System.out.println(sb.toString());
	}

	
	
	/**
	 * 현재 위치에서 갈 수있는 모든 후보위치를 반환
	 * @param pos
	 * @return
	 */
	public List<Position> generateCandidates() {
		List<Position> candidates = new ArrayList<Position>();
		// N  (0, -1)
		if (maps[x][y-1] == 1) candidates.add(new Position(x, y-1));
		// NE (1, -1)
		if (maps[x+1][y-1] == 1) candidates.add(new Position(x+1, y-1));
		// E  (1, 0)
		if (maps[x+1][y] == 1) candidates.add(new Position(x+1, y));
		// SE (1, 1)
		if (maps[x+1][y+1] == 1) candidates.add(new Position(x+1, y+1));
		// S  (0, 1)
		if (maps[x][y+1] == 1) candidates.add(new Position(x, y+1));
		// SW (-1, 1)
		if (maps[x-1][y+1] == 1) candidates.add(new Position(x-1, y+1));
		// W  (-1, 0)
		if (maps[x-1][y] == 1) candidates.add(new Position(x-1, y));
		// NW (-1, -1)
		if (maps[x-1][y-1] == 1) candidates.add(new Position(x-1, y-1));
		return candidates;
	}

	@Override
	/**
	 * Brute-Force 문제점
	 * Q1. 길이 막힌 경우 동일한 경로를 계속 반복하는 문제점
	 * A1. 한 번 지나간 길은 가지 않도록 프로그램 수정
	 * 
	 * Q2. 가장 최적의 경로가 막힌 길인 경우 Local-Maxima에 빠져 실제로 이동할 경로가 더 있지만, 이동장소가 없어지는 문제점
	 * A2. 최적의 길을 무조건 선택하지 않고 Stack에 집어넣고 순서대로 시도하도록 수정 + history 변수는 지나간 횟수를 카운트 하도록 변경 
	 */
	public void findShortestPath() throws Exception { // brute-force
		while (x != endX && y != endY) {
			// 현재 위치를 (X, Y) history 정보에서 (passed) 상태로 변경
			history[x][y]++;
			// 현재 위치를 (X, Y) 넣으면 후보 좌표리스트를 전해주는 함수를 통해 최종지점까지 가장 가까운 위치 찾기
			Position best = null;
			double dist = Double.MAX_VALUE;
			for (Position pos : generateCandidates()) {
				if (pos == null) {
					best = pos;
					continue;
				} else if (dist > pos.distanceTo(endPosition)) {
					best = pos;
				}
			}
			// 가장 가까운 위치가 존재하면 이동, 존재하지 않으면 예외 던지기
			if (best == null) {
				throw new Exception(String.format("더 이상 이동할 장소(%d,%d)가 존재하지 않습니다.", x, y));
			} else {
				System.out.println(String.format("(%d,%d)=>(%d,%d)", x, y, best.x, best.y));
				x = best.x;
				y = best.y;
			}
		}
	}

}
