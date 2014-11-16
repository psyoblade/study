package com.google.interview.datastructure;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestChapter01 {
	private static int recurCount = 0;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * 재귀함수를 통한 이진탐색. 
	 * @param list
	 * @param finding
	 * @param start
	 * @param end
	 * @return
	 */
	private int binsearch(int[] list, int finding, int start, int end) { // finding 16 ==> 0,29 15,29 15,21 15,17, 15,16
		// mid means static position of raw list
		recurCount++;
		System.out.println(String.format("%d:%d", start, end));
		int mid = (end + start) / 2; // 14:22:18:16:15
		if (finding < list[mid]) { // 16 < l[22]=23, 16 < l[18]=19
			return binsearch(list, finding, start, mid - 1); // 15,21:15,17:15,16
		} else if (list[mid] < finding) { // l[14]=15 < 16
			return binsearch(list, finding, mid + 1, end); // 15,29
		} else { // (finding == list[mid]) {
			return 0;
		}
	}

	/**
	 * 
	 * @param sortedList
	 * @param finding
	 * @return found=0, notFound=1
	 */
	private int binarySearch(int[] sortedList, int finding) {
		int length = sortedList.length; 
		if (finding < sortedList[0] || sortedList[length - 1] < finding) {
			return -1;
		} else {
			return binsearch(sortedList, finding, 0, length - 1);
		}
	}

	/**
	 * Traverse binary tree
	 * @date 2014.11.10
	 */
	public void testBinarySearch() {
		int finding = 15;
		int[] sortedList = new int[30];
		for (int i = 0; i < sortedList.length; i++) {
			sortedList[i] = i; // 1 ~ 30
		}
		int found = binarySearch(sortedList, finding);
		if (found == 0) {
			assertEquals(recurCount, 5);
		}
		System.out.println(found);
	}

	/**
	 * 
	 */
	public void testIterativePermutation() {

	}

	private void swap(int[] list, int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}

	public void testSwapInJava() {
		int list[] = new int[10];
		for (int i = 0; i < list.length; i++) {
			list[i] = i;
		}
		swap(list, 5, 6);
		for (int j = 0; j < list.length; j++) {
			System.out.print(list[j]);
		}
	}

	private void perm(int[] list, int depth, int length) {
		if (depth == list.length) {
			for (int i = 0; i < list.length; i++) {
				System.out.print(String.format("%d", list[i]));
			}
			System.out.println("");
		} else {
			for (int j = depth; j < length; j++) {
				swap(list, depth, j);
				perm(list, depth+1, length);
				swap(list, j, depth);
			}
		}
	}

	/**
	 * 재귀호출을 이용한 순열 출력 프로그램.
	 * "순열"이란? 서로다른 n 개의 원소에서 r 개를 뽑아 한 줄로 세우는 방법.
	 * n 과 r 이 같을 때, 모든 원소의 
	 * P(n, r) = (n!) / (n-r)!   
	 * @since 2014.11.10
	 */
	public void testRecursivePermutation() {
		int sizeOfList = 3;
		int list[] = new int[sizeOfList];
		for (int i = 0; i < sizeOfList; i++) {
			list[i] = i + 1;
		}
		perm(list, 0, sizeOfList);
	}

	private int maxFiboNum = 10;
	/**
	 * 반복함수를 이용한 피보나치 수열 출력함수.
	 * @see 피보나치 수열은 1, 1 으로 시작하게 되므로 "maxFiboNum - 2"으로 바운드를 정해야만 한다.
	 */
	@Test
	public void testIterativeFibonacci() {
		int fx1 = 1; // 1
		int fx2 = 1; // 2
		int fxt = 0;
		int sum = 0;
		for (int i = 0; i < maxFiboNum - 2; i++) {
			fxt = fx2;
			// System.out.println(fx1 + "+" + fx2 + "=" + (fx1 + fx2));
			fx2 = fx1 + fx2;
			fx1 = fxt;
		}
		System.out.println("iterativeFibo=" + fx2);
	}

	private int fiboCount = 0; // fibo(x) * 2 - 1 회수만큼 함수호출
	private int fibo(int n) {
		fiboCount++;
		if (n <= 2) return 1; // 인터넷 코드가 항상 옳은 것은 아니다. 의심하고 직접 쳐봐라.
		else return (fibo(n-2) + fibo(n-1));
	}

	/**
	 * 재귀함수를 이용한 피보나치 수열 출력함수.
	 * f1 = 1, f2 = 1
	 * @see 재귀함수는 디버깅이 힘들다, 피보나치 수열과 같이 함수호출이 빈번하면 성능이 떨어진다.
	 */
	@Test
	public void testRecursiveFibonacci() {
		System.out.println("recursiveFibo=" + fibo(maxFiboNum));
		System.out.println(fiboCount);
	}

}
