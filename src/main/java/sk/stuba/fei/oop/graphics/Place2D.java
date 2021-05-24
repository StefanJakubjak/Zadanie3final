package sk.stuba.fei.oop.graphics;


import sk.stuba.fei.oop.petrinet.Place;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class Place2D extends Ellipse2D.Float implements Drawable {
    private Place place;

    @Override
    public long getID() {
        return place.getId();
    }

    public Place2D(int x, int y, Place place) {
        super (x,y,40,40);
        this.place=place;

    }


    public Place getPlace() {

        return place;
    }

    @Override
    public void draw(Graphics graphics) {
        ((Graphics2D)graphics).draw(this);
        graphics.drawString(toString().valueOf(place.getMarking()),place.getX()+17,place.getY()+20);

    }

    @Override
    public void onClick(MouseEvent event) {
        try{
            if (event.getButton() == MouseEvent.BUTTON1)
                place.increaseMarking(1);
            if (event.getButton() == MouseEvent.BUTTON3)
                place.decreaseMarking(1);
        }
        catch(IllegalArgumentException exc){
            System.out.println(exc);

        }

    }
}
