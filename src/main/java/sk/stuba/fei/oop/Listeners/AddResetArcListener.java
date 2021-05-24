package sk.stuba.fei.oop.Listeners;

import sk.stuba.fei.oop.graphics.Drawable;
import sk.stuba.fei.oop.graphics.NetCanvas;
import sk.stuba.fei.oop.graphics.NetFrame;
import sk.stuba.fei.oop.graphics.ResetArc2D;
import sk.stuba.fei.oop.petrinet.PetriNet;
import sk.stuba.fei.oop.petrinet.Place;
import sk.stuba.fei.oop.petrinet.Transition;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

public class AddResetArcListener implements MouseListener {

    private NetCanvas netCanvas;
    private PetriNet petriNet;
    private Drawable start;
    private NetFrame netFrame;
    private int i=0;
    private boolean arcClicked=false;
    public AddResetArcListener(PetriNet petriNet, NetCanvas netCanvas) {
        this.petriNet=petriNet;
        this.netCanvas=netCanvas;
        this.netFrame=(NetFrame)netCanvas.getParent();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        long ID=petriNet.getnewID();
        if (arcClicked){
            for(Drawable element:netCanvas.getElementList()) {
                if(element.contains(e.getX(),e.getY()))
                {try{
                    if(petriNet.getPlacesID().contains(start.getID())&&petriNet.getPlacesID().contains(element.getID()))
                    { i=1;
                        throw new IllegalArgumentException("Reset Arc can't be between this");}

                     for(Map.Entry <Long, Place> place : petriNet.getPlaces().entrySet()) {
                        for (Map.Entry <Long, Transition> transition : petriNet.getTransitions().entrySet()) {


                            if (place.getKey() == start.getID() && element.getID() == transition.getKey()) {
                                if (petriNet.getArcs().contains(petriNet.getArc(start.getID(), element.getID()))) {

                                    if ((petriNet.getArc(start.getID(), element.getID()).getMultiplicity()) == -1) {
                                        i = 1;
                                        throw new IllegalArgumentException("Reset arc already exists");

                                    } else {
                                        petriNet.addResetArc(ID, place.getValue(), transition.getValue());
                                        ResetArc2D resetArc2D = new ResetArc2D(start.getBounds().getX(), start.getBounds().getY(), element.getBounds().getX(), element.getBounds().getY(), petriNet.getArc(start.getID(), element.getID()));
                                        netCanvas.getElementList().add(resetArc2D);
                                        i = 1;
                                    }
                                } else {
                                    petriNet.addResetArc(ID, place.getValue(), transition.getValue());
                                    ResetArc2D resetArc2D = new ResetArc2D(start.getBounds().getX(), start.getBounds().getY(), element.getBounds().getX(), element.getBounds().getY(), petriNet.getArc(start.getID(), element.getID()));
                                    netCanvas.getElementList().add(resetArc2D);
                                    i = 1;
                                }
                            }

                        }}}
                            catch (IllegalArgumentException z)
                            {System.out.println(z.getMessage());}

                        }
                if(i==1)
                {i=0;
                    break;}}
            netFrame.setTitle("====== KLIKNITE NA PRVY VRCHOL =====");
            netCanvas.repaint();
            arcClicked=false;}
        else
        {
            for(Drawable element1:netCanvas.getElementList()) {
                if(element1.contains(e.getX(),e.getY())){
                    start=element1;
                    netFrame.setTitle("====== KLIKNITE NA DRUHY VRCHOL =====");
                    break;}}
            try{if(petriNet.getPlaces().containsKey(start.getID()) )
                arcClicked=true;
            else{arcClicked=false;
                i=0;
                netFrame.setTitle("====== KLIKNITE NA PRVY VRCHOL =====");
                throw new IllegalArgumentException("Transition can't be starting point for reset arc");}}

            catch(IllegalArgumentException x)
                {System.out.println(x.getMessage());}
        }

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
