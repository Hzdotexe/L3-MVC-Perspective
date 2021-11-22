package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

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

public class Perspective extends JPanel {

    public Perspective(String type, Point location, Dimension dimension){
        Border border = BorderFactory.createTitledBorder(type+ "Perspective");
        this.setBorder(border);
        this.setSize(dimension);
        this.setLocation(location);
    }
}
