public class NBody {
    public static double readRadius(String file_name){
        In in = new In(file_name);
        in.readLine();
        double r = in.readDouble();
        in.close();
        return r;
    }

    public static Body[] readBodies(String file_name){
        In data = new In(file_name);
        int n = data.readInt();
        double r = data.readDouble();
        Body[] Bodies = new Body[n];
        for(int i = 0; i < n; i ++){
            double xxPos = data.readDouble();
            double yyPos = data.readDouble();
            double xxVel = data.readDouble();
            double yyVel = data.readDouble();
            double mass = data.readDouble();
            String imgFileName = data.readString();
            Bodies[i] = new Body(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
        }
        data.close();
        return Bodies;
    }
    public static void main(String args[]){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Body[] Bodies = readBodies(filename);
        double r = readRadius(filename);
        String imageToDraw = "images/starfield.jpg";
        StdDraw.enableDoubleBuffering();
        int time = 0;
        double[] xForces = new double[Bodies.length];
        double[] yForces = new double[Bodies.length];

        while (time < T){
            for (int j = 0; j < Bodies.length; j++) {
                xForces[j] = Bodies[j].calcNetForceExertedByX(Bodies);
                yForces[j] = Bodies[j].calcNetForceExertedByY(Bodies);
            }

            for (int j = 0; j < Bodies.length; j++) {
                Bodies[j].update(time,xForces[j],yForces[j]);
            }
            StdDraw.setScale(-r, r);
            StdDraw.picture(0, 0, imageToDraw);
            Bodies[0].draw();
            Bodies[1].draw();
            Bodies[2].draw();
            Bodies[3].draw();
            Bodies[4].draw();
            StdDraw.show();
            StdDraw.pause(100);
            time += dt;
        }
        StdDraw.clear();
        StdOut.printf("%d\n", Bodies.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < Bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Bodies[i].xxPos, Bodies[i].yyPos, Bodies[i].xxVel,
                    Bodies[i].yyVel, Bodies[i].mass, Bodies[i].imgFileName);
        }

    }
}
