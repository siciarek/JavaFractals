package com.siciarek.fractals.point;

import com.siciarek.fractals.common.Drawable;
import com.siciarek.fractals.common.ChaosGameFractal;

public class ChaosGameHexagon extends ChaosGameFractal {
	
	public ChaosGameHexagon(Drawable canvas) {
		super(canvas);
		this.name = "Chaos Game Hexagon";
		this.vertices = 6;
		this.startAngle = 0f;
		this.phi = 1.0f / 3.0f;
	}
}
