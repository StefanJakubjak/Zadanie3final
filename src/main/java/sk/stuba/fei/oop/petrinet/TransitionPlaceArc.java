package sk.stuba.fei.oop.petrinet;

public class TransitionPlaceArc extends Arc {

    public TransitionPlaceArc(long ID, Transition source, Place destination, int multiplicity) throws IllegalArgumentException {
        super(ID,source, destination, multiplicity);
    }

    public TransitionPlaceArc(long ID, Transition source, Place destination) {
        super(ID,source, destination);
    }

    public void produce() {
        ((Place) getDestination()).increaseMarking(getMultiplicity());
    }

    @Override
    public Place getPlace() {
        return (Place) getDestination();
    }

    @Override
    public Transition getTransition() {
        return (Transition) getSource();
    }
}