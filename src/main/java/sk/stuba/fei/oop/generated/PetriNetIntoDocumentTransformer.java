package sk.stuba.fei.oop.generated;


import sk.stuba.fei.oop.petrinet.Arc;
import sk.stuba.fei.oop.petrinet.PetriNet;
import sk.stuba.fei.oop.petrinet.Place;
import sk.stuba.fei.oop.petrinet.Transition;

public class PetriNetIntoDocumentTransformer  {

    private PetriNet petriNet;

    public PetriNetIntoDocumentTransformer(PetriNet petriNet) {
        this.petriNet=petriNet;
    }
public Document DocumentTransformet(){
        Document document=new Document();

    for(Place place:petriNet.getPlaces().values()){
        sk.stuba.fei.oop.generated.Place place1=new sk.stuba.fei.oop.generated.Place();

        place1.setId(place.getId().intValue());
        place1.setLabel(place.getTitle());
        place1.setTokens(place.getMarking());
        place1.setX(place.getX());
        place1.setY(place.getY());
        document.getPlace().add(place1);
    }
    for (Transition transition:petriNet.getTransitions().values())
    {
        sk.stuba.fei.oop.generated.Transition transition1=new sk.stuba.fei.oop.generated.Transition();
        transition1.setId(transition.getId().intValue());
        transition1.setLabel(transition.getTitle());
        transition1.setX(transition.getX());
        transition1.setY(transition.getY());
        document.getTransition().add(transition1);
    }
    for (Arc arc:petriNet.getArcs()){
        sk.stuba.fei.oop.generated.Arc arc1=new sk.stuba.fei.oop.generated.Arc();
        arc1.setDestinationId(arc.getDestination().getId().intValue());
        arc1.setSourceId(arc.getSource().getId().intValue());
        arc1.setId((int) arc.getID());
        arc1.setMultiplicity(arc.getMultiplicity());
        if(arc.getMultiplicity()==-1)
            arc1.setType((ArcType.RESET));
            else
        arc1.setType(ArcType.REGULAR);
        document.getArc().add(arc1);
}
    return document;
    }
}



