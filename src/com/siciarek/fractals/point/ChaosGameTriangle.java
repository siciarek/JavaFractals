package com.siciarek.fractals.point;

import com.siciarek.fractals.common.Drawable;
import com.siciarek.fractals.common.ChaosGameFractal;

public class ChaosGameTriangle extends ChaosGameFractal {
	
	public ChaosGameTriangle(Drawable canvas) {
		super(canvas);
		this.name = "Chaos Game Triangle";
		this.vertices = 3;
		this.startAngle = 0f;
		this.phi = 0.5f;
	}
}
