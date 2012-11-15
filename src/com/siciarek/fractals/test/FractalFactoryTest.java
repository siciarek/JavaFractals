package com.siciarek.fractals.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.siciarek.fractals.common.*;
import com.siciarek.fractals.test.mocks.TestCanvas;

@RunWith(Parameterized.class)
public class FractalFactoryTest {

	Drawable canvas;
	private String given;
	
	public FractalFactoryTest(String given) {
        this.given = given;
    }

	@Parameters
	public static Collection<String[]> dataProvider() {
		return Arrays.asList(new String[][] {
			{ "Chaos Game Triangle" },
			{ "Cantor Set 1D" },
			{ "Koch Curve" },
			{ "Koch Quadratic Curve" },
			{ "Sierpinski Triangle" },
			{ "Sierpinski Carpet" }
		});
	}
	
	@Test
	public void implementedFractals() {
		Fractal f = com.siciarek.fractals.FractalFactory.get(given, canvas);
		assertEquals(given, f.name);
	}
	
	@Before
	public void setUp() throws Exception {
		canvas = new TestCanvas();
	}

	@After
	public void tearDown() throws Exception {

	}
}
