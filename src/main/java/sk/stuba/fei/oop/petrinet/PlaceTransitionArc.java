package sk.stuba.fei.oop.petrinet;

public class PlaceTransitionArc extends Arc {

    public PlaceTransitionArc(long ID,Place source, Transition destination, int multiplicity) throws IllegalArgumentException {
        super(ID,source, destination, multiplicity);
    }

    public PlaceTransitionArc(long ID,Place source, Transition destination) {
        super(ID,source, destination);
    }

    public boolean isSatisfied() {
        return getPlace().getMarking() >= getMultiplicity();
    }

    public void consume() {
        getPlace().decreaseMarking(getMultiplicity());
    }

    @Override
    public Place getPlace() {
        return (Place) getSource();
    }

    @Override
    public Transition getTransition() {
        return (Transition) getDestination();
    }
}