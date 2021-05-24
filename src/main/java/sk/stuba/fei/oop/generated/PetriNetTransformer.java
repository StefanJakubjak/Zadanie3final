package sk.stuba.fei.oop.generated;

import sk.stuba.fei.oop.petrinet.PetriNet;

public class PetriNetTransformer extends Transformer<PetriNet> {

    @Override
    public PetriNet transform(Document document) {
        PetriNet net = new PetriNet();


        for (Place place : document.getPlace()) {
            sk.stuba.fei.oop.petrinet.Place place1 = new sk.stuba.fei.oop.petrinet.Place(
                    place.getId(),
                    place.getLabel(),
                    place.getTokens(),
                    place.getX(),
                    place.getY()
            );
            net.addPlace(place1);
        }

        for (Transition transition : document.getTransition()) {
            sk.stuba.fei.oop.petrinet.Transition transition1 = new sk.stuba.fei.oop.petrinet.Transition(
                    transition.getId(),
                    transition.getLabel(),
                    transition.getX(),
                    transition.getY()
            );
            net.addTransition(transition1);
        }
        for (Arc arc : document.getArc()) {
            if(arc.getType()== ArcType.RESET){
                net.addResetArc(arc.getId(),net.getPlace(arc.getSourceId()),net.getTransition(arc.getDestinationId()));}
            else {
                for (Place place2 : document.getPlace()) {
                    for (Transition transition2 : document.getTransition()){
                       if ((place2.getId() == arc.getSourceId())&&(transition2.getId()==arc.getDestinationId()))
                       { net.addPTArc(arc.getId(),
                                net.getPlace(arc.getSourceId()),
                                net.getTransition(arc.getDestinationId()),
                                arc.getMultiplicity()
                            );
                       }

                       if((transition2.getId() == arc.getSourceId())&&place2.getId()==arc.getDestinationId()){
                        net.addTPArc(arc.getId(),
                                net.getTransition(arc.getSourceId()),
                                net.getPlace(arc.getDestinationId()),
                                arc.getMultiplicity()
                        );
                    }
                }
            }
        }
        }
            return net;
        }
    }

