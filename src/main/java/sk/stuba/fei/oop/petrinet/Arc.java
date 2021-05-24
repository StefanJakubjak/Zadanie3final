package sk.stuba.fei.oop.petrinet;

public abstract class Arc {

    private Vertex source;
    private Vertex destination;
    private int multiplicity = 1;
    private long ID;

    public Arc(long ID,Vertex source, Vertex destination, int multiplicity) throws IllegalArgumentException {
        this(ID,source, destination);
        setMultiplicity(multiplicity);
        this.ID=ID;
    }

    public long getID() {
        return ID;
    }

    public Arc(long ID,Vertex source, Vertex destination) {
        if (source == null || destination == null)
            throw new IllegalArgumentException("Can not create arc from/to null vertex");
        this.source = source;
        this.destination = destination;
        this.ID=ID;

    }

    public int getMultiplicity() {
        return multiplicity;
    }

    public void setMultiplicity(int multiplicity) throws IllegalArgumentException {
        if (multiplicity < 1)
            throw new IllegalArgumentException("Multiplicity can not be less than 1.");

        this.multiplicity = multiplicity;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public abstract Place getPlace();

    public abstract Transition getTransition();
}