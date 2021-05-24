package sk.stuba.fei.oop.Listeners;
import sk.stuba.fei.oop.graphics.NetCanvas;
import sk.stuba.fei.oop.graphics.Place2D;
import sk.stuba.fei.oop.petrinet.PetriNet;
import sk.stuba.fei.oop.petrinet.Place;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddPlaceListener implements MouseListener {
    private PetriNet petriNet;
    private NetCanvas netCanvas;
    public AddPlaceListener(PetriNet petriNet, NetCanvas netCanvas) {
        this.petriNet=petriNet;
        this.netCanvas=netCanvas;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        long ID=petriNet.getnewID();
        Place place=new Place(ID,"s",1,e.getX()-20,e.getY()-20);
        petriNet.addPlace(place);

        Place2D place2D=new Place2D(e.getX()-20,e.getY()-20,petriNet.getPlace(ID));
        netCanvas.getElementList().add(place2D);
        netCanvas.repaint();


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
