package com.siciarek.fractals.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.siciarek.fractals.common.Drawable;
import com.siciarek.fractals.common.Fractal;
import com.siciarek.fractals.test.mocks.TestCanvas;

public class FractalFactoryNotSupportedTest {

	Drawable canvas;

	@Test
	public void notSupportedFractal() {
		Fractal f = com.siciarek.fractals.FractalFactory.get("Dummy", canvas);
		assertEquals("Dummy is not implemented yet", f.name);
	}
	
	@Before
	public void setUp() throws Exception {
		canvas = new TestCanvas();
	}

	@After
	public void tearDown() throws Exception {

	}
}
