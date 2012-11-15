
import com.siciarek.fractals.common.Drawable;

public class SvgCanvas implements Drawable {

	private float width;
	private float height;
	private boolean debug = false;

	public void init(String style) {
		System.out
				.print("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\""
						+ (int) this.width + "\" height=\"" + (int) this.height
						+ "\">");

		if (this.debug == true) {
			System.out.print("<line stroke=\"red\" x1=\"0\" x2=\"" + this.width
					+ "\" y1=\"" + this.height * 0.5 + "\" y2=\"" + this.height
					* 0.5 + "\"  />");
			System.out.print("<line stroke=\"red\" y1=\"0\" y2=\""
					+ this.height + "\" x1=\"" + this.width * 0.5 + "\" x2=\""
					+ this.width * 0.5 + "\"  />");
		}

		String stroke = "black";
		String fill = "none";

		if (style == "fill") {
			fill = "black";
			stroke = "none";
		}

		System.out
				.print("<rect stroke=\"silver\" fill=\"none\" x=\"0\" y=\"0\" width=\""
						+ this.width + "\" height=\"" + this.height + "\" />");
		System.out.print("<path fill=\"" + fill + "\" stroke=\"" + stroke
				+ "\" stroke-width=\"2\" d=\"");
	}

	public void finalize() {
		System.out.print("\" />");
		System.out.print("</svg>");
	}

	public SvgCanvas(float width, float height, boolean debug) {
		this.debug = debug;
		this.width = width;
		this.height = height;
	}

	public SvgCanvas(float width, float height) {
		this(width, height, false);
	}

	public float getWidth() {
		return this.width;
	}

	public float getHeight() {
		return this.height;
	}

	public void moveTo(float x, float y) {
		System.out.print("M" + x + "," + y + " ");
	}

	public void lineTo(float x, float y) {
		System.out.print("L" + x + "," + y + " ");
	}

	public void close() {
		System.out.print("Z");
	}

	public void reset() {

	}

	public void setPoint(float x, float y) {
		if (x < getWidth() - 1.0f && y < getHeight() - 1.0f) {
			moveTo(x, y);
			lineTo(x + 1, y + 1);
		}
	}
}
