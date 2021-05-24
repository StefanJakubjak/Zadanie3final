package sk.stuba.fei.oop.Listeners;


import sk.stuba.fei.oop.graphics.Drawable;
import sk.stuba.fei.oop.graphics.NetCanvas;
import sk.stuba.fei.oop.petrinet.Arc;
import sk.stuba.fei.oop.petrinet.PetriNet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DeleteListener implements MouseListener {
private PetriNet petriNet;
private NetCanvas netCanvas;

public DeleteListener(PetriNet petriNet, NetCanvas netCanvas) {
        this.petriNet=petriNet;
        this.netCanvas=netCanvas;
        }

@Override
public void mouseClicked(MouseEvent e) {
    long ID=-500;
    int HIT_BOX_SIZE = 10;

    List<Drawable> valuesToRemove=new ArrayList<>();

    for(Iterator<Drawable> it = netCanvas.getElementList().iterator(); it.hasNext();) {
        Drawable element = it.next();
        if (element.intersects(e.getX()-HIT_BOX_SIZE, e.getY()-HIT_BOX_SIZE, HIT_BOX_SIZE, HIT_BOX_SIZE)) {
            ID = element.getID();
            if (petriNet.getArcsID().contains(ID))
            { it.remove();}
            else{
            for (Arc arc : petriNet.getArcs()) {
                for (Iterator<Drawable> ti = netCanvas.getElementList().iterator(); ti.hasNext(); ) {
                    Drawable element2 = ti.next();
                    if (arc.getID() == element2.getID()) {
                        if (arc.getSource().getId() == element.getID() || arc.getDestination().getId() == element.getID()) {
                            valuesToRemove.add(element2);
                        }
                    }
                }

            }
            it.remove();

            }
        if(ID!=-500) {
            if (petriNet.getPlacesID().contains(ID))
                petriNet.removePlace(ID);

            else if (petriNet.getTransitionsID().contains(ID))
                petriNet.removeTransition(ID);
            else if (petriNet.getArcsID().contains(ID))
                petriNet.removeArc(ID);
        }


netCanvas.repaint();
break;
}
    }
    netCanvas.getElementList().removeAll(valuesToRemove);

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

    }}