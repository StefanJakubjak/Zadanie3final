package sk.stuba.fei.oop.Listeners;

import sk.stuba.fei.oop.graphics.Arc2D;
import sk.stuba.fei.oop.graphics.Drawable;
import sk.stuba.fei.oop.graphics.NetCanvas;
import sk.stuba.fei.oop.graphics.NetFrame;
import sk.stuba.fei.oop.petrinet.PetriNet;
import sk.stuba.fei.oop.petrinet.Place;
import sk.stuba.fei.oop.petrinet.Transition;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

public class AddArcListener implements MouseListener {

   private NetCanvas netCanvas;
    private PetriNet petriNet;
    private NetFrame netFrame;
    private Drawable start;
    private int i=0;
    private boolean arcClicked=false;

    public AddArcListener(PetriNet petriNet, NetCanvas netCanvas) {
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
                if(petriNet.getPlacesID().contains(start.getID())&&petriNet.getPlacesID().contains(element.getID())||
                        petriNet.getTransitionsID().contains(start.getID())&&petriNet.getTransitionsID().contains(element.getID()))
                { i=1;
                    arcClicked=false;
                    netFrame.setTitle("====== KLIKNITE NA PRVY VRCHOL =====");
                    throw new IllegalArgumentException(" Arc can't be between this");}
                for(Map.Entry <Long, Place> place : petriNet.getPlaces().entrySet()) {
                    for (Map.Entry <Long, Transition> transition : petriNet.getTransitions().entrySet()){
                        if(place.getKey()==start.getID() && element.getID()==transition.getKey()){
                            if(petriNet.getArcs().contains(petriNet.getArc(start.getID(),element.getID()))) {
                                if (petriNet.getArc(start.getID(), element.getID()).getMultiplicity() != -1) {
                                    petriNet.getArc(start.getID(), element.getID()).setMultiplicity(petriNet.getArc(start.getID(), element.getID()).getMultiplicity() + 1);
                                i=1;}
                            }else
                            {petriNet.addPTArc( ID,place.getValue(), transition.getValue(),1);
                                Arc2D arc2D= new Arc2D(start.getBounds().getX(),start.getBounds().getY(),element.getBounds().getX(),element.getBounds().getY(),petriNet.getArc(start.getID(),element.getID()));
                                netCanvas.getElementList().add(arc2D);
                                i=1;}
                        }
                        if(transition.getKey()==start.getID() && element.getID()==place.getKey()){
                            if(petriNet.getArcs().contains(petriNet.getArc(start.getID(),element.getID())))
                                petriNet.getArc(start.getID(),element.getID()).setMultiplicity(petriNet.getArc(start.getID(),element.getID()).getMultiplicity()+1);
                            else{
                                petriNet.addTPArc(ID,transition.getValue(),place.getValue(),1 );
                                Arc2D arc2D= new Arc2D(start.getBounds().getX(),start.getBounds().getY(),element.getBounds().getX(),element.getBounds().getY(),this.petriNet.getArc(start.getID(),element.getID()));
                                netCanvas.getElementList().add(arc2D);
                                i=1;}
                        }

                    }}}
            catch (IllegalArgumentException z)
            {System.out.println(z.getMessage());}
            }
            if(i==1)
            {i=0;
                netFrame.setTitle("====== KLIKNITE NA PRVY VRCHOL =====");
                break;}}
        netCanvas.repaint();
        arcClicked=false;}
        else
    {
        for(Drawable element:netCanvas.getElementList()) {
            if(element.contains(e.getX(),e.getY())){
                start=element;
                break;}}
        if(petriNet.getPlaces().containsKey(start.getID()) || petriNet.getTransitions().containsKey(start.getID()))
            arcClicked=true;
        netFrame.setTitle("====== KLIKNITE NA DRUHY VRCHOL =====");
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
