package sk.stuba.fei.oop.petrinet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PetriNet {

    private Map<Long, Place> places = new HashMap<>();
    private Map<Long, Transition> transitions = new HashMap<>();
    private Set<Arc> arcs = new HashSet<>();

    public Place getPlace(long id) {
        return this.places.get(id);
    }

    public Transition getTransition(long id) {
        return this.transitions.get(id);
    }

    public Arc getArc(long in, long out) {
        for (Arc arc : arcs) {
            if ((arc.getSource().getId() == in) && (arc.getDestination().getId() == out)) {
                return arc;
            }
        }
        return null;
    }

    public Arc getArc(long id){
        for (Arc arc : arcs) {
            if (arc.getID()==id)
                return arc;
            }
        return null;}

    public long getnewID(){
        long x=0;
        for (Arc arc:arcs){
            if (arc.getID()>x)
            x=arc.getID();}
        for (Map.Entry <Long, Place> place : this.getPlaces().entrySet()){
            if (place.getKey()>x)
                x=place.getKey();}
        for (Map.Entry <Long, Transition> transition: this.getTransitions().entrySet()){
            if (transition.getKey()>x)
                x=transition.getKey();}

        return (x+1);
}

    public Set<Long> getPlacesID() {
        return places.keySet();
    }

    public Set<Long> getArcsID() {
        Set<Long> IDs = new HashSet<>();
        for (Arc arc : arcs) {
            IDs.add(arc.getID());
        }

        return IDs;
    }
    public Set<Arc> getArcs(){
        return this.arcs;
}
    public Set<Long> getTransitionsID() {
        return transitions.keySet();
    }

    public void removeArc(long ID) {
     for (Transition transition :getTransitions().values()){
         transition.removeArcC(ID);
     }
     arcs.remove(this.getArc(ID));
    }

    public void removePlace(long ID) {
        Set<Arc> valuesToRemove = new HashSet<>();
        for (Arc arc : arcs) {
            if (arc.getSource().getId() == ID)
            {this.getTransition(arc.getDestination().getId()).removeArcC(arc.getID());

                valuesToRemove.add(arc);
            }

            if (arc.getDestination().getId() == ID) {
                this.getTransition(arc.getSource().getId()).removeArcC(arc.getID());
                valuesToRemove.add(arc);
                }
        }
        arcs.removeAll(valuesToRemove);
    places.remove(this.getPlace(ID));
        places.remove(ID);
}


    public void removeTransition(long ID)
    { Set<Arc> valuesToRemove = new HashSet<>();
        for(Arc arc: arcs){
        if (arc.getSource().getId() == ID){

            valuesToRemove.add(arc);

                }
        if (arc.getDestination().getId() == ID)
            {
                valuesToRemove.add(arc);
               }

    }
        arcs.removeAll(valuesToRemove);
        transitions.remove(this.getTransition(ID));
        transitions.remove(ID);
    }


    public void fireTransition(long transitionId) {
        Transition transition = transitions.get(transitionId);
        if (transition == null)
            throw new IllegalArgumentException();
        transition.fire();

    }

    public Map<Long, Place> getPlaces(){return this.places;}
    public Map<Long, Transition> getTransitions(){return this.transitions;}

    public void addPlace(Place place) {
        places.put(place.getId(), place);
    }

    public void addTransition(Transition transition) {
        transitions.put(transition.getId(), transition);
    }

    public void addPTArc(long ID, Place p, Transition t, int multyplicity) {
        PlaceTransitionArc arc = new PlaceTransitionArc(ID,p, t, multyplicity);
        t.addInputArc(arc);
        arcs.add(arc);
    }
    public void addResetArc(long ID, Place p, Transition t) {
        ResetArc arc = new ResetArc(ID,p, t);
        t.addResetArc(arc);
        arcs.add(arc);}
    public void addTPArc(long ID, Transition t, Place p, int multyplicity) {
        TransitionPlaceArc arc = new TransitionPlaceArc(ID,t, p,multyplicity);
        t.addOutputArc(arc);
        arcs.add(arc);
    }
}