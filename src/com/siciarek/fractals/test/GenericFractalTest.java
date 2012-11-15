package com.siciarek.fractals.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.siciarek.fractals.common.Drawable;
import com.siciarek.fractals.common.Fractal;
import com.siciarek.fractals.test.mocks.MockFractal;
import com.siciarek.fractals.test.mocks.TestCanvas;

public class GenericFractalTest {

	private Drawable canvas;
	
	@Test
	public void test() {
		Fractal f = new MockFractal(canvas);
		assertEquals("" + 6, "" + f.iterations);
		assertTrue(0 == f.currentIteration);
	}

	@Before
	public void setUp() throws Exception {
		canvas = new TestCanvas();
	}

	@After
	public void tearDown() throws Exception {
	}

}
