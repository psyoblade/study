package com.google.interview.datastructure;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestChapter02 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	public void test() {
//		fail("Not yet implemented");
	}
	
	public void testCalcDistinctCharCount() {
		String input = "abcdabc";
		int[] count = new int['z'-'a'+1];
		int result = 0;
		int answer = 4;
		int index = 0;
		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}
		for (char c : input.toCharArray()) {
			index = c - 'a';
			count[index]++;
		}
		for (int j = 0; j < count.length; j++) {
			if (count[j] > 0) {
				result++;
			}
		}
		assertTrue(answer == result);
	}
	
	/**
	 * 패턴에서 반복되는 패턴의 위치를 찾아 위치를 찾아주는 함수.
	 * @param pattern
	 * @return
	 */
	private String fail(String pattern) {
		int[] failure = new int[pattern.length()];
		failure[0] = -1;
		int i = -1;
		for (int j = 1; j < pattern.length(); j++) {
			i = failure[j-1];
			// 이전문자와 다르고, 반복되는 패턴이 발생한 경우에 i위치 Reset
			while ((pattern.charAt(j) != pattern.charAt(i+1)) && i >= 0) { // ababc, j=2, i=0, c[j]='a', c[i+1]='b'
				i = failure[i];
			}
			if (pattern.charAt(j) == pattern.charAt(i+1)) {
				failure[j] = i + 1;
			} else {
				failure[j] = -1;
			}
		}
		String result = "";
		for (int f : failure) {
			result += (result.length() == 0 ? f : "," + f);
		}
		return result;
	}
	
	@Test
	/**
	 * 패턴 매치 함수의 중복패턴 위치찾는 함수 테스트.
	 * @author psyoblade
	 * @since 2014/11/13
	 */
	public void testPatternMatchFailureFunction() {
		String[] patterns = { "aaaab", "ababaa", "abaabaab" };
		String[] answers = { "-1,0,1,2,-1", "-1,-1,0,1,2,0", "-1,-1,0,0,1,2,3,4" };
		for (int i = 0; i < patterns.length; i++) {
			String result = fail(patterns[i]);
			System.out.println(result);
			System.out.println(answers[i]);
			assertTrue(answers[i].equals(result));
		}
	}
}



