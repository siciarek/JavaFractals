package com.siciarek.fractals;

import com.siciarek.fractals.common.Drawable;
import com.siciarek.fractals.common.Fractal;
import com.siciarek.fractals.common.NotSupported;

public class FractalFactory {
    public static Fractal get(String name, Drawable canvas) {

        Fractal fractal;

        for (String type : new String[] { "line", "shape", "point" }) {

            try {
                return (Fractal) Class
                        .forName("com.siciarek.fractals." + type + "." + name.replaceAll(" ", ""))
                        .getConstructor(new Class[] { Drawable.class })
                        .newInstance(canvas);
            } catch (Exception e) {
                
            }
        }

        fractal = new NotSupported(canvas);
        fractal.name = name + " is not implemented yet";

        return fractal;
    }
}
