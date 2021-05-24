package sk.stuba.fei.oop.Listeners;

import sk.stuba.fei.oop.graphics.NetCanvas;
import sk.stuba.fei.oop.graphics.Transition2D;
import sk.stuba.fei.oop.petrinet.PetriNet;
import sk.stuba.fei.oop.petrinet.Transition;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddTransitionListener implements MouseListener {
    private PetriNet petriNet;
    private NetCanvas netCanvas;

    public AddTransitionListener(PetriNet petriNet, NetCanvas netCanvas) {
        this.petriNet = petriNet;
        this.netCanvas = netCanvas;
    }

    @Override
    public void mouseClicked(MouseEvent e) {


        long ID=petriNet.getnewID();
       Transition transition=new Transition(ID,"s",e.getX()-20,e.getY()-20);
        petriNet.addTransition(transition);

        Transition2D transition2D=new Transition2D(e.getX()-20,e.getY()-20,petriNet.getTransition(ID));
        netCanvas.getElementList().add(transition2D);
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
