package com.siciarek.fractals.shape;

import com.siciarek.fractals.common.Drawable;
import com.siciarek.fractals.common.Fractal;
import com.siciarek.fractals.common.Utils;

public class SierpinskiTriangle extends Fractal {

	public SierpinskiTriangle(Drawable canvas) {
		this(canvas, false);
	}

	public SierpinskiTriangle(Drawable canvas, boolean reset) {
		super(canvas);
		this.name = "Sierpinski Triangle";
		this.type = "shape";

		this.x1 = 0f;
		this.y1 = canvas.getHeight();
		this.x2 = canvas.getWidth();
		this.y2 = canvas.getHeight();
		
		if(canvas.getHeight() < canvas.getWidth()) {
			this.x1 = (canvas.getWidth() - canvas.getHeight()) * 0.5f;
			this.x2 = this.x1 + canvas.getHeight();
		}
		
		this.miny = canvas.getHeight();
		this.setPosition(iterations - 1, x1, y1, x2, y2);
	}

	protected void render(int iter, float sx, float sy, float ex, float ey) {

		if (iter > 0) {

			float delta = (ex - sx) * 0.5f;
			
			float x1 = sx;
			float y1 = sy;
			
			float x2 = x1 + delta;
			float y2 = y1;
			
			float x3 = ex;
			float y3 = ey;

			float angle = (float) -Math.PI / 3;
			float[] temp = Utils.rotatePoint(angle, sx, sy, ex - delta, ey);

			float x4 = temp[0];
			float y4 = temp[1];
			
			float x5 = x4 + delta;
			float y5 = y4;
			
			render(iter - 1, x1, y1, x2, y2);
			render(iter - 1, x2, y2, x3, y3);
			render(iter - 1, x4, y4, x5, y5);
			
		} else {
			float angle = (float) -Math.PI / 3;
			float[] temp = Utils.rotatePoint(angle, sx, sy, ex, ey);

			float tx = temp[0];
			float ty = temp[1];
			
			canvas.moveTo(sx, sy);
			canvas.lineTo(tx, ty);
			canvas.lineTo(ex, ey);
			canvas.close();
		}
	}

	@Override
	protected void setPosition(int iteration, float sx, float sy, float ex,
			float ey) {

		this.countPosition(0, sx, sy, ex, ey);
		this.y1 = (canvas.getHeight() + (canvas.getHeight() - this.miny)) * 0.5f;
		this.y2 = this.y1;
	}

	@Override
	protected void countPosition(int iter, float sx, float sy, float ex,
			float ey) {
		if (iter > 0) {

			float delta = (ex - sx) * 0.5f;
			
			float x1 = sx;
			float y1 = sy;
			
			float x2 = x1 + delta;
			float y2 = y1;
			
			float x3 = ex;
			float y3 = ey;

			float angle = (float) -Math.PI / 3;
			float[] temp = Utils.rotatePoint(angle, sx, sy, ex - delta, ey);

			float x4 = temp[0];
			float y4 = temp[1];
			
			float x5 = x4 + delta;
			float y5 = y4;
			
			countPosition(iter - 1, x1, y1, x2, y2);
			countPosition(iter - 1, x2, y2, x3, y3);
			countPosition(iter - 1, x4, y4, x5, y5);
			
		} else {
			float angle = (float) -Math.PI / 3;
			float[] temp = Utils.rotatePoint(angle, sx, sy, ex, ey);

			float ty = temp[1];
			
			if(ty < this.miny) {
				this.miny = ty;
			}
		}		
	}
}
