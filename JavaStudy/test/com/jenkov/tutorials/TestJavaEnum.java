package com.jenkov.tutorials;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jenkov.tutorials.JavaEnums.Level;

public class TestJavaEnum {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIterating() {
		Level[] levels = { Level.HIGH, Level.MEDIUM, Level.LOW };
		for (Level e : levels) {
			System.out.println(e.name() + ":" + e.getValue());
		}
	}

}
