package com.siciarek.fractals.test.mocks;

import com.siciarek.fractals.common.Drawable;
import com.siciarek.fractals.common.Fractal;

public class MockFractal extends Fractal {

	public MockFractal(Drawable canvas, boolean reset) {
		super(canvas, reset);
		// TODO Auto-generated constructor stub
	}

	public MockFractal(Drawable canvas) {
		super(canvas);
	}

	@Override
	protected void render(int iter, float x1, float y1, float x2, float y2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setPosition(int iteration, float sx, float sy, float ex,
			float ey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void countPosition(int iter, float sx, float sy, float ex,
			float ey) {
		// TODO Auto-generated method stub
		
	}
}
