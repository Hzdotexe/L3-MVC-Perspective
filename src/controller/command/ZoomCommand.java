package controller.command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;

/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s: Anyin Zhang, Isaac David Zolana,
               Hanz Sami, Fatsy Ramampiarison,
               Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: ZoomCommand.java
 Date créé: 2021-11-20
 *******************************************************/

public class ZoomCommand extends JPanel implements Command {
    private java.awt.Image imageZoom;
    private double height;
    private double width;
    private double zoom = 1.0;
    private boolean zoomer;
    private static final double FACTOR = 0.1;
    //private static final double MIN = 0.01;

    /**
     * Constructor
     * @param imageZoom The image for the command zoom.
     * @param height The zoom factor of the image.
     * @param width The previous zoom factor.
     */
    public ZoomCommand(Image imageZoom, double height, double width) {
        this.imageZoom = imageZoom;
        this.height = height;
        this.width = width;
        initComponent();
    }

    private void initComponent(){
        addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
                zoomer = true;

                //Zoom in
                if (e.getWheelRotation() < 0) {
                    zoom -= FACTOR;
                    repaint();
                } else
                    //zoom out
                    zoom += FACTOR;
                    repaint();
            }
        });
    }

    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2 = (Graphics2D) g.create();

        double zoomHeight = height*zoom;
        double zoomWidth = width*zoom;

        double anchorx = (width - zoomWidth)/2;
        double anchory = (height - zoomHeight)/2;

        if (zoomer) {
            AffineTransform at = new AffineTransform();
            at.translate(anchorx,anchory);
            at.scale(zoom, zoom);
            at.translate(-100,-100);

            g2.setTransform(at);
            zoomer = false;
        }
        g2.drawImage(imageZoom,0,0,this);
    }

    @Override
    public boolean execute() {
        return zoomer;
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

}
