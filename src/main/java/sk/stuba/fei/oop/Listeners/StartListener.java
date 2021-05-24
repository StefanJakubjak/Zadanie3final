package sk.stuba.fei.oop.Listeners;

import sk.stuba.fei.oop.graphics.Drawable;
import sk.stuba.fei.oop.graphics.NetFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StartListener implements MouseListener  {
    private NetFrame netFrame;

    public StartListener(NetFrame netFrame) {
        this.netFrame = netFrame;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        for (Drawable element:netFrame.getNetCanvas().getElementList()){
            if(element.contains(e.getX(),e.getY()))
                element.onClick(e);

        }
        netFrame.getNetCanvas().repaint();

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
    public void mouseExited(MouseEvent e) {

    }
}
