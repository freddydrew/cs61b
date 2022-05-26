public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b){
        this(b.xxPos, b.yyPos, b.xxVel, b.yyVel, b.mass, b.imgFileName);
    }

    public double calcDistance(Body b){
        double x = this.xxPos - b.xxPos;
        double y = this.yyPos - b.yyPos;
        return Math.sqrt((x*x)+(y*y));
    }

    public double calcForceExertedBy(Body b){
        double G = 6.67e-11;
        double r = calcDistance(b);
        return G*(this.mass*b.mass)/(r*r);
    }

    public double calcForceExertedByX(Body b){
        double F = calcForceExertedBy(b);
        double r = calcDistance(b);
        double x = b.xxPos - this.xxPos;
        return F*x/r;
    }

    public double calcForceExertedByY(Body b){
        double F = calcForceExertedBy(b);
        double r = calcDistance(b);
        double y = b.yyPos - this.yyPos;
        return F*y/r;
    }

    public double calcNetForceExertedByX(Body[] bodies){
        double FxNet = 0;
        for (int i = 0; i < bodies.length; i++){
            if (this.equals(bodies[i])) {
                continue;
            } else {
                double Fnx = calcForceExertedByX(bodies[i]);
                double r = calcDistance(bodies[i]);
                FxNet = FxNet + Fnx;

            }
        }
        return FxNet;
    }

    public double calcNetForceExertedByY(Body[] bodies){
        double FyNet = 0;
        for (int i = 0; i < bodies.length; i++){
            if (this.equals(bodies[i])) {
                continue;
            } else {
                double Fny = calcForceExertedByY(bodies[i]);
                double r = calcDistance(bodies[i]);
                FyNet = FyNet + Fny;

            }
        }
        return FyNet;
    }

}
