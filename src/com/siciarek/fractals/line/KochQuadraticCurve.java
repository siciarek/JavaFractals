package com.siciarek.fractals.line;

import com.siciarek.fractals.common.Drawable;
import com.siciarek.fractals.common.Utils;

public class KochQuadraticCurve extends KochCurve {

	public KochQuadraticCurve(Drawable canvas) {
		super(canvas);
		this.name = "Koch Quadratic Curve";
		this.x1 = 0f;
		this.y1 = canvas.getHeight();
		this.x2 = canvas.getWidth();
		this.y2 = canvas.getHeight();
		this.miny = canvas.getHeight();
		this.setPosition(iterations - 1, x1, y1, x2, y2);
	}

	@Override
	protected void countPosition(int iter, float sx, float sy, float ex,
			float ey) {
		if (iter > 0) {

			float[] temp;
			float angle = (float) - Math.PI / 2;
			
			float xoffset = (ex - sx) / 3.0f;
			float yoffset = (ey - sy) / 3.0f;

			float x1 = sx;
			float y1 = sy;

			float x2 = sx + xoffset;
			float y2 = sy + yoffset;

			temp = Utils.rotatePoint(angle, x2, y2, ex - xoffset, ey - yoffset);

			float x3 = temp[0];
			float y3 = temp[1];

			temp = Utils.rotatePoint(angle, ex - xoffset, ey - yoffset, ex, ey);

			float x4 = temp[0];
			float y4 = temp[1];
			
			float x5 = ex - xoffset;
			float y5 = ey - yoffset;

			float x6 = ex;
			float y6 = ey;

			countPosition(iter - 1, x1, y1, x2, y2);
			countPosition(iter - 1, x2, y2, x3, y3);
			countPosition(iter - 1, x3, y3, x4, y4);
			countPosition(iter - 1, x4, y4, x5, y5);
			countPosition(iter - 1, x5, y5, x6, y6);
		} else {
			if(ey < this.miny) {
				this.miny = ey;
			}
		}		
	}

	protected void render(int iter, float sx, float sy, float ex, float ey) {

		if (iter > 0) {

			float[] temp;
			float angle = (float) - Math.PI / 2;
			
			float xoffset = (ex - sx) / 3.0f;
			float yoffset = (ey - sy) / 3.0f;

			float x1 = sx;
			float y1 = sy;

			float x2 = sx + xoffset;
			float y2 = sy + yoffset;

			temp = Utils.rotatePoint(angle, x2, y2, ex - xoffset, ey - yoffset);

			float x3 = temp[0];
			float y3 = temp[1];

			temp = Utils.rotatePoint(angle, ex - xoffset, ey - yoffset, ex, ey);

			float x4 = temp[0];
			float y4 = temp[1];
			
			float x5 = ex - xoffset;
			float y5 = ey - yoffset;

			float x6 = ex;
			float y6 = ey;

			render(iter - 1, x1, y1, x2, y2);
			render(iter - 1, x2, y2, x3, y3);
			render(iter - 1, x3, y3, x4, y4);
			render(iter - 1, x4, y4, x5, y5);
			render(iter - 1, x5, y5, x6, y6);
		} else {
			canvas.lineTo(ex, ey);
		}
	}

}
