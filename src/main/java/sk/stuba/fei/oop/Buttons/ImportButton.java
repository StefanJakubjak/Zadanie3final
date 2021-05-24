package sk.stuba.fei.oop.Buttons;

import sk.stuba.fei.oop.generated.Document;
import sk.stuba.fei.oop.generated.GraphicsTransformer;
import sk.stuba.fei.oop.generated.Importer;
import sk.stuba.fei.oop.generated.PetriNetTransformer;
import sk.stuba.fei.oop.graphics.NetCanvas;
import sk.stuba.fei.oop.graphics.NetFrame;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

public class ImportButton extends Button implements MouseListener {
    public ImportButton() throws HeadlessException {
        super("Import");
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

        for (MouseListener mouseListener:netCanvas.getMouseListeners())
        {netCanvas.removeMouseListener(mouseListener);}
        FileDialog dialog = new FileDialog(((NetFrame)netCanvas.getParent()), "Open", FileDialog.LOAD);
        dialog.setFile("*.xml;*.xml");

        dialog.setVisible(true);
        if (dialog.getFile() != null) {
            try {
                Importer importer = new Importer();
                Document document = importer.importFile(dialog.getDirectory()+dialog.getFile());
                PetriNetTransformer petriNetTransformer = new PetriNetTransformer();
                netFrame.setNet( petriNetTransformer.transform(document));

                GraphicsTransformer graphicsTransformer = new GraphicsTransformer(netFrame.getNet());
                netCanvas.setElementList(graphicsTransformer.transform(document));
                netCanvas.repaint();


            } catch (JAXBException exc) {
                System.out.println(exc);
            } catch (FileNotFoundException exc) {
                System.out.println(exc);
            }
        }


        this.setBackground(new JButton().getBackground());
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
