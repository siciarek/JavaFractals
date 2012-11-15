import com.siciarek.fractals.common.Drawable;
import com.siciarek.fractals.common.Fractal;

class Main {
	public static void main(String[] args) {

		String name = args.length > 0 ? args[0] : "Koch Curve";
		Integer iter = args.length > 1 ? Integer.parseInt(args[1]) : 3;
		String orientation = args.length > 2 ? args[2] : "h";

		Drawable canvas;
		Fractal fractal;

		canvas = orientation.equals("h") ? new SvgCanvas(800f, 404f)
				: new SvgCanvas(202f, 400f);

		fractal = com.siciarek.fractals.FractalFactory.get(name, canvas);
		fractal.generate(iter);
	}
}
