package com.siciarek.fractals.shape;

import com.siciarek.fractals.common.Drawable;

public class SierpinskiCarpet extends SierpinskiTriangle {

	public SierpinskiCarpet(Drawable canvas) {
		super(canvas);
		this.name = "Sierpinski Carpet";

		if(canvas.getHeight() > canvas.getWidth()) {
			this.y1 = (canvas.getWidth() + canvas.getHeight()) * 0.5f;
			this.y2 = this.y1;
		}
		this.setPosition(iterations - 1, x1, y1, x2, y2);
	}

	@Override
	protected void setPosition(int iteration, float sx, float sy, float ex,
			float ey) {

	}

	@Override
	protected void render(int iter, float sx, float sy, float ex, float ey) {

		if (iter > 0) {
			float delta = (ex - sx) / 3f;
			
			render(iter - 1, sx + 0 * delta, sy + 0 * delta, sx + 1 * delta, sy + 0 * delta);
			render(iter - 1, sx + 1 * delta, sy + 0 * delta, sx + 2 * delta, sy + 0 * delta);
			render(iter - 1, sx + 2 * delta, sy + 0 * delta, sx + 3 * delta, sy + 0 * delta);

			render(iter - 1, sx + 0 * delta, sy - 1 * delta, sx + 1 * delta, sy - 1 * delta);
			render(iter - 1, sx + 2 * delta, sy - 1 * delta, sx + 3 * delta, sy - 1 * delta);

			render(iter - 1, sx + 0 * delta, sy - 2 * delta, sx + 1 * delta, sy - 2 * delta);
			render(iter - 1, sx + 1 * delta, sy - 2 * delta, sx + 2 * delta, sy - 2 * delta);
			render(iter - 1, sx + 2 * delta, sy - 2 * delta, sx + 3 * delta, sy - 2 * delta);
			
		} else {
			float delta = (ex - sx);
			canvas.moveTo(sx, sy);
			canvas.lineTo(sx, sy - delta);
			canvas.lineTo(ex, ey - delta);
			canvas.lineTo(ex, ey);
			canvas.close();
		}
	}
}
