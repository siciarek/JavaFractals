import com.siciarek.fractals.common.Drawable;

public class SvgCanvas implements Drawable {

    String background = "#FAFAD2";
    String foreground = "#141414";

    private float width;
    private float height;
    private boolean debug = false;
    private String title;

    public void updateTitle(String title) {
        this.title = title;
    }

    public void init(String style) {
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        System.out.println("<!DOCTYPE svg>");
        System.out.println("<svg style=\"background-color: black\" xmlns=\"http://www.w3.org/2000/svg\" "
                + "width=\"" + (int) this.width + "\" "
                + "height=\"" + (int) this.height + "\" "
                + "viewBox=\"0 0 " + (int) this.width + " " + (int) this.height
                + "\">");
        

        if (this.debug == true) {
            System.out.println("<line stroke=\"red\" x1=\"0\" x2=\"" + this.width + "\" y1=\"" + this.height * 0.5
                    + "\" y2=\"" + this.height * 0.5 + "\"  />");
            System.out.println("<line stroke=\"red\" y1=\"0\" y2=\"" + this.height + "\" x1=\"" + this.width * 0.5
                    + "\" x2=\"" + this.width * 0.5 + "\"  />");
        }

        String stroke = foreground;
        String fill = "none";

        if (style == "fill") {
            fill = foreground;
            stroke = "none";
        }

        System.out.println("<rect fill=\"" + background + "\" x=\"0\" y=\"0\" width=\"" + (int) this.width
                + "\" height=\"" + (int) this.height + "\" />");
        
        System.out.print("<path fill=\"" + fill + "\" stroke=\"" + stroke + "\" stroke-width=\"2\" d=\"");
    }

    public void finalize() {
        System.out.println("\" />");
        System.out.println("<text x=\"10\" y=\"24\" fill=\"#555555\" font-family=\"sans-serif\" font-size=\"16\">" + title + "</text>");
        System.out.println("</svg>");
        System.out.println();
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
