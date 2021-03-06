/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s:  Anyin Zhang, Isaac David Zolana,
                Hanz Sami, Fatsy Ramampiarison,
                Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: ImageModel.java
 Date créé: 2021-11-15
 *******************************************************/
package model;

import observer.Observer;
import observer.Subject;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Les information d'image
 */
public class ImageModel implements Subject, Serializable {
    private ArrayList<Observer> observers = new ArrayList<>();
    private ImageIcon image;
    private int width;
    private int height;
    private int x;
    private int y;

    /**
     * Initialiser l'image
     * @param imageFile Le fichier contenant l'image
     */
    public ImageModel(File imageFile) {
        try {
            this.image = new ImageIcon(ImageIO.read(imageFile));
            this.width = 500;
            this.height = 500;
            this.x = 0;
            this.y = 0;
            this.scaleImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ImageIcon getImageIcon() {
        return this.image;
    }

    /**
     * Redimensionner et replacer l'image
     */
    public void scaleImage() {
        Image tmp = image.getImage().getScaledInstance(this.width, this.height, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(tmp, this.x, this.y, null);
        g2d.dispose();

        image = new ImageIcon(resizedImage);
    }

    /**
     * Getter & Setter
     */
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        this.notifyObservers();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        this.notifyObservers();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        this.notifyObservers();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        this.notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update();
        }
    }
}
