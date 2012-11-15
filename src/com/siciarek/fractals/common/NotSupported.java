package com.siciarek.fractals.common;


public class NotSupported extends Fractal {
	
	public NotSupported(Drawable canvas) {
		super(canvas);
		this.name = "Not Supported Fractal";
		this.iterations = 0;
	}
	
	public void render(int iter, float sx, float sy, float ex, float ey) {

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
