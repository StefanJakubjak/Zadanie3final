package sk.stuba.fei.oop.graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class delete extends Button implements ActionListener {
    public delete() throws HeadlessException {
        super("delete");
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

