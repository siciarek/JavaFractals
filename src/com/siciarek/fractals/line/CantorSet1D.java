package com.siciarek.fractals.line;

import com.siciarek.fractals.common.Drawable;
import com.siciarek.fractals.common.Fractal;

public class CantorSet1D extends Fractal {

	public CantorSet1D(Drawable canvas) {
		super(canvas);
		this.name = "Cantor Set 1D";
		this.x1 = 0f;
		this.y1 = canvas.getHeight() * 0.5f;
		this.x2 = canvas.getWidth();
		this.y2 = canvas.getHeight() * 0.5f;
		this.miny = canvas.getHeight();
		this.setPosition(iterations - 1, x1, y1, x2, y2);
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
	
	public void render(int iter, float sx, float sy, float ex, float ey) {

		if (iter > 0) {

			float xoffset = (ex - sx) / 3.0f;
			float yoffset = (ey - sy) / 3.0f;

			float x1 = sx;
			float y1 = sy;

			float x2 = sx + xoffset;
			float y2 = sy + yoffset;

			float x3 = ex - xoffset;
			float y3 = ey - yoffset;

			float x4 = ex;
			float y4 = ey;

			render(iter - 1, x1, y1, x2, y2);
			render(iter - 1, x3, y3, x4, y4);
		} else {
			canvas.moveTo(sx, sy);
			canvas.lineTo(ex, ey);
		}
	}

}
