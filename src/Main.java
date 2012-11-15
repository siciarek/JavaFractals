import com.siciarek.fractals.*;
import com.siciarek.fractals.chaosgame.*;
import com.siciarek.fractals.common.Drawable;
import com.siciarek.fractals.common.Fractal;

class Main {
	public static void main(String[] args) {
		
		Integer iter = args.length > 0 ? Integer.parseInt(args[0]) : 1;
		String orientation = args.length > 1 ? args[1] : "h";
		
		Drawable canvas;
		Fractal fractal;

		canvas = orientation.equals("h") ? new SvgCanvas(800f, 404f) : new SvgCanvas(202f, 400f);

		fractal = new CantorSet1D(canvas);
		fractal = new KochCurve(canvas);
//		fractal = new KochQuadraticCurve(canvas);
//		fractal = new SierpinskiTriangle(canvas);
//		fractal = new SierpinskiCarpet(canvas);

		fractal = new Triangle(canvas);
		fractal.generate(iter);
	}
}
