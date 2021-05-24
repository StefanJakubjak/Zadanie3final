package sk.stuba.fei.oop.Buttons;

import sk.stuba.fei.oop.Listeners.AddArcListener;
import sk.stuba.fei.oop.graphics.NetCanvas;
import sk.stuba.fei.oop.graphics.NetFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class AddArcButton extends Button  implements MouseListener {
    public AddArcButton() throws HeadlessException {
        super("Add Arc");
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Panel panel=(Panel) this.getParent();
        for (Component component:panel.getComponents()){
            component.setBackground(new JButton().getBackground());
        }
        this.setBackground(Color.green);
        NetFrame netFrame = (NetFrame) this.getParent().getParent();
        NetCanvas netCanvas = netFrame.getNetCanvas();
        netFrame.setTitle(" ");

        AddArcListener arcListenner = new AddArcListener(netFrame.getNet(),netCanvas);
        for (MouseListener mouseListener:netCanvas.getMouseListeners())
        {netCanvas.removeMouseListener(mouseListener);}
        netCanvas.addMouseListener(arcListenner);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

