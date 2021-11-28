package model;

import observer.Observer;
import observer.Subject;
import view.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s: Anyin Zhang, Isaac David Zolana,
               Hanz Sami, Fatsy Ramampiarison,
               Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: Image.java
 Date créé: 2021-11-15
 *******************************************************/

public class ImageModel implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();
    private BufferedImage image;
    private int width;
    private int height;
    private int x;
    private int y;

    public ImageModel(File imageFile) {
        try {
            this.image = ImageIO.read(imageFile);
            this.width = GUI.PERSPECTIVE_DIMENSION.width;
            this.height = GUI.PERSPECTIVE_DIMENSION.height;
            this.x = 0;
            this.y = 0;
            this.image = this.scaleImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public BufferedImage scaleImage() {
        Image tmp = image.getScaledInstance(this.width, this.height, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(tmp, this.x, this.y, null);
        g2d.dispose();

        return resizedImage;
    }

    public int getWidth() {
        return width;
    }

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
