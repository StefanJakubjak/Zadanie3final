package sk.stuba.fei.oop.graphics;

import java.awt.*;
import java.awt.event.MouseEvent;

public interface Drawable extends Shape {
    void draw(Graphics graphics);
    void onClick(MouseEvent event);
    long getID();
}
