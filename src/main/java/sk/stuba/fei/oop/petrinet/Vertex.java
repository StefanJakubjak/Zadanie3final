package sk.stuba.fei.oop.petrinet;

public abstract class Vertex {

    private long id;
    private String title;
    private int x;
    private int y;

    protected Vertex(long id, String title, int x, int y) {
        this.id = id;
        this.title = title;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}

