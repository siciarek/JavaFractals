package com.siciarek.fractals.point;

import com.siciarek.fractals.common.Drawable;
import com.siciarek.fractals.common.ChaosGameFractal;

public class ChaosGameSquare extends ChaosGameFractal {
	
	public ChaosGameSquare(Drawable canvas) {
		super(canvas);
		this.name = "Chaos Game Square";
		this.vertices = 4;
		this.startAngle = (float) Math.PI / 4f;

		this.phi = 1.0f / 4.0f;
	}
}
