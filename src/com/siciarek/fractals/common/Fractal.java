package com.siciarek.fractals.common;

abstract public class Fractal {
	public Drawable canvas;
	public String style = "stroke";
	public Integer iterations = 6;
	public Integer step = 1;
	public Integer currentIteration = 0;
	public String name = "Abstract Fractal";
	protected float x1, y1, x2, y2, miny = -1.0f;
	private boolean reset;
	
	public Fractal(Drawable canvas, boolean reset) {
		this.canvas = canvas;
		this.currentIteration = 0;
		this.reset  = reset;
	}
	
	public Fractal(Drawable canvas) {
		this(canvas, true);
	}

	protected void init(float x, float y) {
		canvas.moveTo(x, y);
	}
	
	protected void reset() {
		this.currentIteration = 0;
	}
	
	abstract protected void render(int iter, float x1, float y1, float x2, float y2);
	abstract protected void setPosition(int iteration, float sx, float sy, float ex, float ey);
	abstract protected void countPosition(int iter, float sx, float sy, float ex, float ey);

	public void generateNext() {
		this.generate(this.currentIteration);
		this.currentIteration += this.step;
		if(this.currentIteration > this.getIterations()) {
			this.currentIteration = 0;
		}
	}
	
	public void generate(Integer iteration) {
		
		if(reset == true) {
			canvas.reset();
		}

		String title = this.name;
		title += this.iterations > 0
			? " (" + iteration + "/" + this.getIterations() + ")"
			: "";
		
		canvas.init(this.style);
		canvas.updateTitle(title);

		if(this.iterations > 0) {
			this.init(x1, y1);
			this.render(iteration, x1, y1, x2, y2);
		}
		
		canvas.finalize();
	}

	public Integer getIterations() {
		return iterations - 1;
	}
}
