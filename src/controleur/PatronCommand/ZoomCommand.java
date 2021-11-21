package controleur.PatronCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
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

public class ZoomCommand extends JPanel implements Command, MouseWheelListener {
    private java.awt.Image imageZoom;
    private int height;
    private int width;
    private double zoomFactor;
    private double prevZoomFactor;
    private boolean zoomer;
    private static final double FACTOR = 1.1;

    /**
     * Constructor
     * @param imageZoom The image for the command zoom.
     * @param zoomFactor The zoom factor of the image.
     * @param prevZoomFactor The previous zoom factor.
     */
    public ZoomCommand(Image imageZoom, int zoomFactor, int prevZoomFactor) {
        this.imageZoom = imageZoom;
        this.zoomFactor = zoomFactor;
        this.prevZoomFactor = prevZoomFactor;
        initComponent();
    }

    private void initComponent(){
        addMouseWheelListener(this);
    }


    @Override
    public boolean doIt() {
        if (zoomer){
            return true;
        }else{
            return false;
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if (zoomer) {
            AffineTransform transform = new AffineTransform();
            transform.scale(zoomFactor, zoomFactor);
            prevZoomFactor = zoomFactor;
            g2.transform(transform);
            zoomer = false;
        }
        g2.drawImage(imageZoom,0,0,this);
    }

    @Override
    public void mouseWheelMoved (MouseWheelEvent e){
        zoomer = true;

        //Zoom in
        if (e.getWheelRotation() < 0){
            zoomFactor *= FACTOR;
            repaint();
        }

        //Zoom out
        if (e.getWheelRotation() > 0){
            zoomFactor /= FACTOR;
            repaint();
        }
    }
}
