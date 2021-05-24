package sk.stuba.fei.oop.petrinet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Transition extends Vertex {

    private Set<PlaceTransitionArc> inputArcs = new HashSet<>();
    private Set<TransitionPlaceArc> outputArcs = new HashSet<>();
    private Set<ResetArc> resetArcs=new HashSet<>();
    public Transition(long id, String title,int x, int y) {
        super(id, title,x,y);
    }

    public boolean isFireable() {
        for (PlaceTransitionArc inputArc : inputArcs) {
            if (!inputArc.isSatisfied()) {
                return false;
            }
        }
        return true;
    }

    public void fire() {
        if (!isFireable())
            throw new IllegalStateException("Transition " + getTitle() + " is not fireable.");

        for (PlaceTransitionArc inputArc : inputArcs) {
            inputArc.consume();
        }

        for (TransitionPlaceArc outputArc : outputArcs) {
            outputArc.produce();
        }
        for (ResetArc resetArc: resetArcs){
            resetArc.consume();
        }
    }

    public void addInputArc(PlaceTransitionArc arc) throws IllegalArgumentException {
        addArc(arc, inputArcs);
    }


    public void addOutputArc(TransitionPlaceArc arc) throws IllegalArgumentException {
        addArc(arc, outputArcs);
    }

    public void addResetArc(ResetArc arc) throws IllegalArgumentException {
        addArc(arc,resetArcs);
    }

    private <T extends Arc> void addArc(T arc, Set<T> arcs) {
        if (arc.getTransition() != this)
            throw new IllegalArgumentException();
        arcs.add(arc);
    }
    public void removeArcC(long ID){
        for (Iterator<PlaceTransitionArc> it = inputArcs.iterator(); it.hasNext();) {
            PlaceTransitionArc element = it.next();
            if (element.getID() == ID) {
                it.remove();
            }
        }
        for (Iterator<TransitionPlaceArc> it = outputArcs.iterator(); it.hasNext();) {
            TransitionPlaceArc element = it.next();
            if (element.getID() == ID) {
                it.remove();
            }
        }
        for (Iterator<ResetArc> it = resetArcs.iterator(); it.hasNext();) {
            ResetArc element = it.next();
            if (element.getID() == ID) {
                it.remove();
            }
        }


    }

    }

