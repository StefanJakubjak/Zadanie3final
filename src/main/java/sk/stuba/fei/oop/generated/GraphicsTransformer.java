package sk.stuba.fei.oop.generated;

import sk.stuba.fei.oop.graphics.*;
import sk.stuba.fei.oop.petrinet.PetriNet;

import java.util.ArrayList;
import java.util.List;

public class GraphicsTransformer extends Transformer<List<Drawable>> {
    private PetriNet net;

    public GraphicsTransformer(PetriNet net) {
        this.net = net;
    }


    @Override
    public List<Drawable> transform(Document document) {
        List<Drawable> drawables=new ArrayList<>();
        for(Place place:document.getPlace()){
            Place2D place2D= new Place2D(
                    place.getX(),
                    place.getY(),
                    this.net.getPlace(place.getId()));
            drawables.add(place2D);
        }
        for(Transition transition:document.getTransition()){
            Transition2D transition2D= new Transition2D(
                    transition.getX(),
                    transition.getY(),
                    this.net.getTransition(transition.getId()));
            drawables.add(transition2D);
        }

        for(Arc arc :document.getArc()) {
            if (arc.getType()== ArcType.RESET) {
                ResetArc2D resetArc2D = new ResetArc2D(
                        net.getPlace(arc.getSourceId()).getX(),
                        net.getPlace(arc.getSourceId()).getY(),
                        net.getTransition(arc.getDestinationId()).getX(),
                        net.getTransition(arc.getDestinationId()).getY() ,
                        net.getArc(arc.getSourceId(), arc.getDestinationId()));
                drawables.add(resetArc2D);

            } else {
                for (Place place : document.getPlace()) {
                    for (Transition transition : document.getTransition()) {
                        if ((place.getId() == arc.getSourceId()) && (transition.getId() == arc.getDestinationId())) {
                            Arc2D arc2D = new Arc2D(
                                    net.getPlace(arc.getSourceId()).getX(),
                                    net.getPlace(arc.getSourceId()).getY(),
                                    net.getTransition(arc.getDestinationId()).getX(),
                                    net.getTransition(arc.getDestinationId()).getY() ,
                                    net.getArc(place.getId(), transition.getId()));
                            drawables.add(arc2D);
                        }
                        if ((place.getId() == arc.getDestinationId()) && (transition.getId() == arc.getSourceId())) {
                            Arc2D arc2D2 = new Arc2D(
                                    net.getTransition(arc.getSourceId()).getX(),
                                    net.getTransition(arc.getSourceId()).getY() ,
                                    net.getPlace(arc.getDestinationId()).getX(),
                                    net.getPlace(arc.getDestinationId()).getY() ,
                                    net.getArc(transition.getId(), place.getId()));
                            drawables.add(arc2D2);
                        }

                    }
                }
            }

        }

        return drawables;}
    }

