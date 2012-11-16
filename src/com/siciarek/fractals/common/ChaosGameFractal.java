package com.siciarek.fractals.common;


abstract public class ChaosGameFractal extends Fractal {

	int maxx;
	int maxy;
	protected float[] vertex;
	protected float[] point = new float[2];

	protected int vertices = 3;
    protected float startAngle = 0f;
    protected float phi = 0.5f;
	
	public ChaosGameFractal(Drawable canvas) {
		super(canvas, true);
		this.name = "Chaos Game Fractal";
		this.type = "point";
		this.step = 500;
		this.iterations = 10000;
		this.currentIteration = 0;
		
		maxx = (int) canvas.getWidth() - 2;
		maxy = (int) canvas.getHeight() - 2;
	}
	
	public Integer getIterations() {
		return iterations;
	}

	protected float[] getRandomPoint() {
		Integer index;

		index = (int) (Math.random() * 100000);
	    index %= maxx;
	    point[0] = ((float) index);

		index = (int) (Math.random() * 100000);
	    index %= maxy;
	    point[1] = ((float) index);
	    
	    return point;
	}
	
	protected float[] getVertex() {
	    float[][] points = Utils.shape(vertices, canvas.getWidth(), canvas.getHeight(), startAngle);

		Integer index = (int) (Math.random() * 100000);
		index %= points.length;
		return points[index];
	}
	
	protected float[] getNewPoint(float[] p, float[] v) {
        float deltax = (v[0] - p[0]);
        float deltay = (v[1] - p[1]);

        float[] newp = new float[2];
        newp[0] = v[0] - deltax * this.phi;
        newp[1] = v[1] - deltay * this.phi;
	    return newp;
	}
	
	protected void render(int iter, float sx, float sy, float ex, float ey) {

		point = getRandomPoint();
		canvas.setPoint(point[0], point[1]);
		
		for(int i = 0; i < iter; i++) {
			vertex = getVertex();
			
			float[] np = getNewPoint(point, vertex);
			
			float x = np[0];
			float y = np[1];
			
			canvas.setPoint(x, y);

			point[0] = x;
			point[1] = y;
		}
	}

    protected void setPosition(int iteration, float sx, float sy, float ex, float ey) {
        
    }

    protected void countPosition(int iter, float sx, float sy, float ex, float ey) {
        
    }
}
