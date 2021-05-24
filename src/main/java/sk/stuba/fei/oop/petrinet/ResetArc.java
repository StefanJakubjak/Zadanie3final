package sk.stuba.fei.oop.petrinet;

public class ResetArc extends Arc {


    public ResetArc(long ID,Place source, Transition destination) {
        super(ID,source, destination);
    }



    public void consume() {
        getPlace().decreaseMarking(getPlace().getMarking());
    }
    @Override public int getMultiplicity() {
        return -1;
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