package sk.stuba.fei.oop.petrinet;

public class Place extends Vertex {

    private int marking = 0;

    public Place(long id, String title, int marking,int x, int y) throws IllegalArgumentException {
        super(id, title,x,y);
        setMarking(marking);
    }



    public int getMarking() {
        return marking;
    }

    public void setMarking(int marking) throws IllegalArgumentException {
        if (marking < 0)
            throw new IllegalArgumentException("Marking can not be negative number.");
        this.marking = marking;
    }

    public void increaseMarking(int value) throws IllegalArgumentException {
        setMarking(marking + value);
    }

    public void decreaseMarking(int value) throws IllegalArgumentException {
        setMarking(marking - value);
    }
}