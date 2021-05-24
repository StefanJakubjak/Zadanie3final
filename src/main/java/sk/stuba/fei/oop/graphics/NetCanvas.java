package sk.stuba.fei.oop.graphics;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class NetCanvas extends Canvas implements MouseListener {

    private List<Drawable> elementList;

    public NetCanvas(){
        this.elementList=new ArrayList<>();
        addMouseListener(this);
        repaint();
    }

    public List<Drawable> getElementList(){
        return elementList;
    }

    public void setElementList(List<Drawable>elementList){
        this.elementList=elementList;
    }


    @Override
    public void paint (Graphics g) {
        super.paint(g);
        for (Drawable element : elementList) {
            g.setColor(Color.black);
            element.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public synchronized MouseListener[] getMouseListeners() {
        return super.getMouseListeners();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public synchronized void removeMouseListener(MouseListener l) {
        super.removeMouseListener(l);
    }

    @Override
    public synchronized void addMouseListener(MouseListener l) {
        super.addMouseListener(l);
    }
}
