package com.siciarek.fractals.point;

import com.siciarek.fractals.common.Drawable;
import com.siciarek.fractals.common.Utils;
import com.siciarek.fractals.shape.SierpinskiTriangle;

import java.util.*;

public class ChaosGameTriangle extends SierpinskiTriangle {

	float currx, curry;
	int maxx, maxy;
	Vector<Float>vertex = new Vector<Float>(2);
	Vector<Float>point = new Vector<Float>(2);
	
	public ChaosGameTriangle(Drawable canvas) {
		super(canvas, true);
		this.name = "Chaos Game: Triangle";
		this.style = "stroke";
		this.step = 500;
		this.iterations = 10000;
		this.currentIteration = 0;
		
		maxx = (int) canvas.getWidth() - 2;
		maxy = (int) canvas.getHeight() - 2;
	}

	protected void init(float x, float y) {

	}

	protected void reset() {

	}
	
	public Integer getIterations() {
		return iterations;
	}

	protected Vector<Float> getRandomPoint() {
		Vector<Float>p = new Vector<Float>();
		Integer index;

		index = (int) (Math.random() * 100000);
	    index %= maxx;
	    p.add((float) index);

		index = (int) (Math.random() * 100000);
	    index %= maxy;
	    p.add((float) index);
	    
	    return p;
	}
	
	protected Vector<Float> getVertex() {
		Vector<Vector<Float>> vertices = new Vector<Vector<Float>>();
		Vector<Float> v;

		float angle = (float) -Math.PI / 3;
		float[] p = Utils.rotatePoint(angle, x1, y1, x2, y2);

		float tx = p[0];
		float ty = p[1];

		v = new Vector<Float>();
		v.add(x1);
		v.add(y1);
		vertices.add(v);

		v = new Vector<Float>();
		v.add(tx);
		v.add(ty);
		vertices.add(v);

		v = new Vector<Float>();
		v.add(x2);
		v.add(y2);
		vertices.add(v);

		Integer index = (int) (Math.random() * 100000);
		index %= vertices.size();
		return vertices.get(index);
	}
	
	protected void render(int iter, float sx, float sy, float ex, float ey) {

		point = getRandomPoint();
		canvas.setPoint(point.get(0), point.get(1));
		
		for(int i = 0; i < this.currentIteration; i++) {
			vertex = getVertex();

			float vx = vertex.get(0);
			float vy = vertex.get(1);

			float px = point.get(0);
			float py = point.get(1);
			
			float tx = vx - (vx - px) * 0.5f;
			float ty = vy - (vy - py) * 0.5f;
			
			canvas.setPoint(tx, ty);

			point.set(0, tx);
			point.set(1, ty);
		}
	}
}
