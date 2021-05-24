package sk.stuba.fei.oop.Buttons;


import sk.stuba.fei.oop.Listeners.AddTransitionListener;
import sk.stuba.fei.oop.graphics.NetCanvas;
import sk.stuba.fei.oop.graphics.NetFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class AddTransitionButton extends Button implements ActionListener {
    public AddTransitionButton() throws HeadlessException {
        super("Add Transition");
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Panel panel=(Panel) this.getParent();
        for (Component component:panel.getComponents()){
            component.setBackground(new JButton().getBackground());
        }
        this.setBackground(Color.green);

        NetFrame netFrame = (NetFrame) this.getParent().getParent();
        NetCanvas netCanvas = netFrame.getNetCanvas();
        AddTransitionListener transitionListener = new AddTransitionListener(netFrame.getNet(),netCanvas);
        netFrame.setTitle(" ");
        for (MouseListener mouseListener:netCanvas.getMouseListeners())
        {netCanvas.removeMouseListener(mouseListener);}
        netCanvas.addMouseListener(transitionListener);
    }
}
