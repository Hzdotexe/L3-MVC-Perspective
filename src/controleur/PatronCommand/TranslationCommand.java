package controleur.PatronCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
 Nom du fichier: TranslationCommand.java
 Date créé: 2021-11-20
 *******************************************************/

public class TranslationCommand extends JPanel implements Command, MouseListener, MouseMotionListener {
    private Image imageTranslate;
    private int x;
    private int y;
    private boolean dragger;
    private boolean released;
    private int xDiff;
    private int yDiff;
    private Point startPoint;



    public TranslationCommand() {
        this.imageTranslate = imageTranslate;
        this.x = x;
        this.y = y;
        initComponent();
    }

    private void initComponent(){
        addMouseListener(this);
    }

    @Override
    public boolean doIt() {
        if (dragger){
            return true;
        }else{
            return false;
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if(dragger){
            AffineTransform transform = new AffineTransform();
            transform.translate(x+xDiff, y+yDiff);
            g2.transform(transform);

            if(released){
                x += xDiff;
                y += yDiff;
                dragger = false;
            }
        }

        g2.drawImage(imageTranslate,0,0,this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        released = false;
        startPoint = MouseInfo.getPointerInfo().getLocation();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        released = true;
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point currentPoint = e.getLocationOnScreen();
        xDiff = currentPoint.x - startPoint.x;
        yDiff = currentPoint.y - startPoint.y;

        dragger = true;
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
