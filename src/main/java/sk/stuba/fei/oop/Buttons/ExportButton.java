package sk.stuba.fei.oop.Buttons;

import sk.stuba.fei.oop.generated.Document;
import sk.stuba.fei.oop.generated.PetriNetIntoDocumentTransformer;
import sk.stuba.fei.oop.graphics.NetCanvas;
import sk.stuba.fei.oop.graphics.NetFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class ExportButton extends Button implements MouseListener {
    private JAXBContext jaxbContext;
    public ExportButton() throws HeadlessException {
        super("Export");
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

        String workingdir = System.getProperty("user.dir") + "/src/main/resources";
        JFileChooser jfc = new JFileChooser(new File(System.getProperty("user.dir")));
        jfc.setDialogTitle("Uloz subor ");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(".xml", "xml");
        jfc.addChoosableFileFilter(filter);
        File file;
        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {

        }
        if(jfc.getSelectedFile()!=null){
           File selectedFile = jfc.getSelectedFile();
            if (selectedFile.getAbsolutePath().endsWith(".xml")) {
                file =new File(selectedFile.getAbsolutePath());
            } else {
                file =new File(selectedFile.getAbsolutePath() + ".xml");
            }

                PetriNetIntoDocumentTransformer petriNetIntoDocumentTransformer=new PetriNetIntoDocumentTransformer(netFrame.getNet());
                Document document= petriNetIntoDocumentTransformer.DocumentTransformet();
             try{   jaxbContext = JAXBContext.newInstance(Document.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.marshal(document, file);
    } catch (JAXBException x) {
        System.out.println("\u001B[31m" + "CHYBA! PRI UKLADANI SUBORU NASTALA CHYBA!");

    }

    }
    this.setBackground(new JButton().getBackground());}

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
