package model;

import observer.Observer;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Point;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.Serializable;

/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s: Anyin Zhang, Isaac David Zolana,
               Hanz Sami, Fatsy Ramampiarison,
               Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: Perspective.java
 Date créé: 2021-11-15
 *******************************************************/

public class Perspective extends JPanel implements Observer, Serializable {
    private ImageModel imageModel;
    private String type;

    public Perspective(String type, Point location, Dimension dimension){
        Border border = BorderFactory.createTitledBorder(type+ "Perspective");
        this.setBorder(border);
        this.setSize(dimension);
        this.setLocation(location);
        this.type = type;
    }

    public ImageModel getImageModel() {
        return imageModel;
    }

    public void setImageModel(ImageModel imageModel) {
        this.imageModel = imageModel;
        this.add(new JLabel(imageModel.getImageIcon()));
    }

    public String getType() {
        return type;
    }

    @Override
    public void update() {
        Image tmp = imageModel.getImageIcon().getImage().getScaledInstance(imageModel.getWidth(), imageModel.getHeight(), Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(this.imageModel.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(tmp, imageModel.getX(), imageModel.getY(), null);
        g2d.dispose();

        this.removeAll();
        this.add(new JLabel(new ImageIcon(resizedImage)));

        SwingUtilities.updateComponentTreeUI(this);
    }
}
