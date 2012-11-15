package com.siciarek.fractals.common;

public interface Drawable {

	public void init(String style);
	public void finalize();
	
	public float getWidth();
	public float getHeight();

	public void updateTitle(String title);
	public void setPoint(float x, float y);
	public void moveTo(float x, float y);
	public void lineTo(float x, float y);
	public void close();
	public void reset();
}
