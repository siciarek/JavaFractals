package com.siciarek.fractals.point;

import com.siciarek.fractals.common.*;

public class ChaosGamePentagon extends ChaosGameFractal {

    public ChaosGamePentagon(Drawable canvas) {
        super(canvas);
        this.name = "Chaos Game Pentagon";
        this.vertices = 5;
        this.startAngle = 0f;

        this.phi = Utils.GOLDEN_RATIO / (1.0f + Utils.GOLDEN_RATIO);
    }

    protected float[] getNewPoint(float[] p, float[] v) {
        float deltax = (v[0] - p[0]);
        float deltay = (v[1] - p[1]);

        float[] newp = new float[2];
        newp[0] = p[0] + deltax * this.phi;
        newp[1] = p[1] + deltay * this.phi;
        return newp;
    }

    protected void render(int iter, float sx, float sy, float ex, float ey) {

        this.point = getRandomPoint();
        this.canvas.setPoint(point[0], point[1]);

        for (int i = 0; i < iter; i++) {
            this.vertex = getVertex();

            float vx = vertex[0];
            float vy = vertex[1];

            float px = point[0];
            float py = point[1];

            float x = px + (vx - px) * this.phi;
            float y = py + (vy - py) * this.phi;

            this.canvas.setPoint(x, y);

            this.point[0] = x;
            this.point[1] = y;
        }
    }

}
