package sk.stuba.fei.oop.graphics;
import sk.stuba.fei.oop.petrinet.Transition;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class Transition2D extends Rectangle2D.Float implements Drawable {

    private Transition transition;

    public Transition getTransition() {
        return transition;
    }

    public Transition2D(int x, int y, Transition transition) {
        super(x,y,40,40);
        this.transition = transition;

        }
        @Override
        public void draw (Graphics graphics){
        ((Graphics2D)graphics).draw(this);
            if(transition.isFireable()){
                graphics.setColor(Color.green);
                ((Graphics2D) graphics).fill(this);}
    }



    @Override
    public void onClick(MouseEvent event) {
        try {transition.fire();}
        catch (IllegalStateException exc){
            System.out.println(exc);}


    }

    @Override
    public long getID() {
        return transition.getId();
    }
}
