package sk.stuba.fei.oop.graphics;

import sk.stuba.fei.oop.Buttons.*;
import sk.stuba.fei.oop.petrinet.PetriNet;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NetFrame extends Frame {


    private PetriNet net;


    private NetCanvas netCanvas;

    public PetriNet getNet() {
        return net;
    }

    public NetFrame() throws HeadlessException {
        setSize(1600, 900);
        netCanvas = new NetCanvas();
        net=new PetriNet();
        Panel panel = new Panel();
        setLayout(new BorderLayout());
        panel.setBackground(Color.green);
        panel.setLayout(new GridLayout(1, 1));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));


        RemoveButton deleteButton=new RemoveButton();
        AddPlaceButton addPlace=new AddPlaceButton();
        StartButton startButton=new StartButton();
        ImportButton importButton=new ImportButton();
        AddArcButton addArcButton=new AddArcButton();
        AddTransitionButton addTransitionButton=new AddTransitionButton();
        ExportButton exportButton=new ExportButton();
        AddResetArcButton addResetArcButton=new AddResetArcButton();
        panel.add(importButton);
        panel.add(exportButton);
        panel.add(startButton);
        panel.add(addPlace);
        panel.add(addTransitionButton);
        panel.add(addArcButton);
        panel.add(addResetArcButton);
        panel.add(deleteButton);

        add(panel, BorderLayout.NORTH);
        add(netCanvas, BorderLayout.CENTER);

        setVisible(true);
        addWindowListener(new WindowAdapter() {
                              public void windowClosing(WindowEvent e) {
                                  dispose();
                              }
                          }
        );

    }

    public void setNet(PetriNet net) {
        this.net = net;
    }

    public NetCanvas getNetCanvas() {
        return netCanvas;
    }



    }
