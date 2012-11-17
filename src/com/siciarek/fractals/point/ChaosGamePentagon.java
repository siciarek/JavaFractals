package com.siciarek.fractals.point;

import com.siciarek.fractals.common.Drawable;
import com.siciarek.fractals.common.ChaosGameFractal;

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
}
