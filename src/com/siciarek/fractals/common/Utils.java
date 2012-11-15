package com.siciarek.fractals.common;

public class Utils {
	
	public static float[] rotatePoint(float angle, float base_x, float base_y,
		float point_x, float point_y) {
		float[] point = { 0.0f, 0.0f };

		float sin_a = (float) Math.sin(angle);
		float cos_a = (float) Math.cos(angle);

		float temp_x = point_x - base_x;
		float temp_y = point_y - base_y;

		float rotated_x = temp_x * cos_a - temp_y * sin_a;
		float rotated_y = temp_x * sin_a + temp_y * cos_a;
		float target_x = rotated_x + base_x;
		float target_y = rotated_y + base_y;

		point[0] = target_x;
		point[1] = target_y;

		return point;
	}
}
