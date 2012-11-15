package com.siciarek.fractals;

import com.siciarek.fractals.common.*;
import com.siciarek.fractals.line.CantorSet1D;
import com.siciarek.fractals.line.KochCurve;
import com.siciarek.fractals.line.KochQuadraticCurve;
import com.siciarek.fractals.point.ChaosGameTriangle;
import com.siciarek.fractals.shape.SierpinskiCarpet;
import com.siciarek.fractals.shape.SierpinskiTriangle;

public class FractalFactory {
	public static Fractal get(String name, Drawable canvas) {
		
		Fractal fractal;
		
		if(name.equals("Koch Curve")) {
			fractal =  new KochCurve(canvas);
		}
		else if(name.equals("Koch Quadratic Curve")) {
			fractal =  new KochQuadraticCurve(canvas);
		}
		else if(name.equals("Cantor Set 1D")) {
			fractal =  new CantorSet1D(canvas);
		}
		else if(name.equals("Sierpinski Triangle")) {
			fractal =  new SierpinskiTriangle(canvas);
		}
		else if(name.equals("Sierpinski Carpet")) {
			fractal =  new SierpinskiCarpet(canvas);
		}
		else if(name.equals("Chaos Game: Triangle")) {
			fractal =  new ChaosGameTriangle(canvas);
		}
		else {
			fractal =  new NotSupported(canvas);
			fractal.name = name + " is not implemented yet";
		}
		
		return fractal;
	}
}
