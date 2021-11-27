package view;

import model.ImageModel;
import observer.Observer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;

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

public class Perspective extends JPanel implements Observer {
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
        this.add(new JLabel(new ImageIcon(imageModel.getImage())));
    }

    public String getType() {
        return type;
    }

    @Override
    public void update() {
        Image tmp = imageModel.getImage().getScaledInstance(imageModel.getWidth(), imageModel.getHeight(), Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(this.imageModel.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        this.removeAll();
        this.add(new JLabel(new ImageIcon(resizedImage)));
    }
}
