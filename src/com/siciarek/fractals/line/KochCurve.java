package com.siciarek.fractals.line;

import com.siciarek.fractals.common.Drawable;
import com.siciarek.fractals.common.Fractal;
import com.siciarek.fractals.common.Utils;

public class KochCurve extends Fractal {

	
	public KochCurve(Drawable canvas) {
		super(canvas);
		this.name = "Koch Curve";
		this.x1 = 0f;
		this.y1 = canvas.getHeight();
		this.x2 = canvas.getWidth();
		this.y2 = canvas.getHeight();
		this.miny = canvas.getHeight();
		this.setPosition(iterations - 1, x1, y1, x2, y2);
	}

	protected void setPosition(int iter, float sx, float sy, float ex, float ey) {
		this.countPosition(iter, sx, sy, ex, ey);
		this.y1 = (canvas.getHeight() + (canvas.getHeight() - this.miny)) * 0.5f;
		this.y2 = this.y1;
	}
		
	protected void countPosition(int iter, float sx, float sy, float ex, float ey) {
		if (iter > 0) {

			float xoffset = (ex - sx) / 3.0f;
			float yoffset = (ey - sy) / 3.0f;

			float x1 = sx;
			float y1 = sy;

			float x2 = sx + xoffset;
			float y2 = sy + yoffset;

			float angle = (float) -Math.PI / 3;
			float[] temp = Utils.rotatePoint(angle, x2, y2, ex - xoffset, ey - yoffset);

			float x3 = temp[0];
			float y3 = temp[1];

			float x4 = ex - xoffset;
			float y4 = ey - yoffset;

			float x5 = ex;
			float y5 = ey;

			this.countPosition(iter - 1, x1, y1, x2, y2);
			this.countPosition(iter - 1, x2, y2, x3, y3);
			this.countPosition(iter - 1, x3, y3, x4, y4);
			this.countPosition(iter - 1, x4, y4, x5, y5);
		} else {
			if(ey < this.miny) {
				this.miny = ey;
			}
		}
	}
	
	protected void render(int iter, float sx, float sy, float ex, float ey) {

		if (iter > 0) {

			float xoffset = (ex - sx) / 3.0f;
			float yoffset = (ey - sy) / 3.0f;

			float x1 = sx;
			float y1 = sy;

			float x2 = sx + xoffset;
			float y2 = sy + yoffset;

			float angle = (float) -Math.PI / 3;
			float[] temp = Utils.rotatePoint(angle, x2, y2, ex - xoffset, ey - yoffset);

			float x3 = temp[0];
			float y3 = temp[1];

			float x4 = ex - xoffset;
			float y4 = ey - yoffset;

			float x5 = ex;
			float y5 = ey;

			render(iter - 1, x1, y1, x2, y2);
			render(iter - 1, x2, y2, x3, y3);
			render(iter - 1, x3, y3, x4, y4);
			render(iter - 1, x4, y4, x5, y5);
		} else {
			canvas.lineTo(ex, ey);
		}
	}
}
