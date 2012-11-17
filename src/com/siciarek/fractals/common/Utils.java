package com.siciarek.fractals.common;

public class Utils {

    public final static float GOLDEN_RATIO = 1.6180339887498948482f;
    
    public static float[][] shape(int vertices, float width, float height) {
        return shape(vertices, width, height, 0);
    }
    
    public static float[][] shape(int vertices, float width, float height, float startAngle) {

        float[][] points = new float[vertices][2];

        float centerx = width * 0.5f;
        float centery = height * 0.5f;
        float radius = Math.min(centerx, centery) * 0.95f;
        float angle = (float) (2f * Math.PI / vertices);

        float base_x = centerx;
        float base_y = centery;
        float point_x = base_x;
        float point_y = base_y - radius;

        for (int i = 0; i < vertices; i++) {
            points[i] = rotatePoint(startAngle + angle * i, base_x, base_y, point_x, point_y);
        }

        return points;
    }

    public static float[] rotatePoint(float angle, float base_x, float base_y, float point_x, float point_y) {
        float[] point = new float[2];

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
