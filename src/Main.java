import com.siciarek.fractals.common.Drawable;
import com.siciarek.fractals.common.Fractal;
import com.siciarek.fractals.point.*;

import gnu.getopt.*;

public class Main {

    public static void main(String[] args) {
        
        Boolean help = false;

        // Default values:
        String name = "Koch Curve";
        Integer stage = 3;
        String orientation = "horizontal";
        
        // </handling-commandline-options>

        StringBuffer sb = new StringBuffer();
        LongOpt[] longopts = new LongOpt[4];
        longopts[0] = new LongOpt("help", LongOpt.NO_ARGUMENT, null, 'h');
        longopts[1] = new LongOpt("fractal", LongOpt.REQUIRED_ARGUMENT, sb, 'f');
        longopts[2] = new LongOpt("stage", LongOpt.REQUIRED_ARGUMENT, sb, 's');
        longopts[3] = new LongOpt("orientation", LongOpt.REQUIRED_ARGUMENT, sb, 'o');

        Getopt g = new Getopt("fractal", args, "", longopts);

        int c;

        while ((c = g.getopt()) != -1) {

            switch (c) {

            case 'h':
                help = true;
                break;

            case 0:
                String opt = longopts[g.getLongind()].getName();
                String value = g.getOptarg();

                if (opt.equals("fractal")) {
                    name = value;
                }

                if (opt.equals("stage")) {
                    stage = Integer.parseInt(value);
                }

                if (opt.equals("orientation")) {
                    orientation = value;
                }

                break;
            }
        }

        // </handling-commandline-options>
        
        if(help == true) {
            usage();
        }
        
        Drawable canvas;
        Fractal fractal;

        canvas = orientation.equals("horizontal") ? new SvgCanvas(800f, 404f) : new SvgCanvas(404f, 800f);
        fractal = com.siciarek.fractals.FractalFactory.get(name, canvas);
        fractal.generate(stage);
    }

    /**
     * Display application help text.
     */
    private static void usage() {
        System.out.println("Usage: java -jar fractals.jar [options...]");
        System.out.println("Options:");
        System.out.println(" -h, --help               This help text");
        System.out.println(" -f, --fractal NAME       Name the fractal (default: Koch Curve)");
        System.out.println(" -V, --version            Show version number and quit");
        System.out.println(" -s, --stage STAGE        Number of fractal iteration (default: 3)");
        System.out.println(" -o, --orientation ORIEN  Image orientation (horizontal or vertical,");
        System.out.println("                          default: horizontal)");
        System.out.println();
        System.out.println("Mail bug reports and suggestions to <siciarek@gmail.com>.");
        System.exit(0);
    }
    
}
