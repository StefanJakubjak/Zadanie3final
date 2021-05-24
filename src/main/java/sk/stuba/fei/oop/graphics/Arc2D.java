package sk.stuba.fei.oop.graphics;

import sk.stuba.fei.oop.petrinet.Arc;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

public class Arc2D extends Line2D.Double implements Drawable {
    private Arc arc;
    private double h=5, d=5;

    @Override
    public long getID() {
        return arc.getID();
    }

    public Arc2D(double x1, double y1, double x2, double y2, Arc arc) {
       super(x1, y1+20, x2, y2+20);
        if (x2>x1){
            x1=x1+40;
            this.x1=x1;
        }
        if (x2<x1) {
            x2 = x2 + 40;
            this.x2 = x2;
        }
        this.arc=arc;

    }
@Override
public void draw(Graphics graphics) {

        double dx =  (x2 - x1), dy = y2 - y1;
        double D = Math.sqrt(dx*dx + dy*dy);
        double xm = D - d, xn = xm, ym = h, yn = -h, x;
        double sin = dy / D, cos = dx / D;

        x = xm*cos - ym*sin + x1;
        ym = xm*sin + ym*cos + y1;
        xm = x;

        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;

        int[] xpoints = {(int)x2, (int) xm, (int) xn};
        int[] ypoints = {(int)y2, (int) ym, (int) yn};

        ((Graphics2D)graphics).draw(this);
        graphics.fillPolygon(xpoints, ypoints, 3);
        int midX=(int)((x2 + x1)/2);
        int midY=(int)((y2+y1)/2);
        if (x2>x1)
            {midY=midY+15;}

        ((Graphics2D)graphics).drawString(toString().valueOf(arc.getMultiplicity()),midX,midY);


    }



    @Override
    public void onClick(MouseEvent event) {


    }
}