/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s:  Anyin Zhang, Isaac David Zolana,
                Hanz Sami, Fatsy Ramampiarison,
                Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: GUI.java
 Date créé: 2021-11-20
 *******************************************************/
package view;

import model.Perspective;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

/**
 * Launch the application
 */
public class GUI {

    public static final Dimension PERSPECTIVE_DIMENSION = new Dimension(350, 350);
    private static final Point PERSPECTIVE_INIT_LOCATION = new Point(315,380);
    private static final Point PERSPECTIVE_ZOOM_LOCATION = new Point(15,10);
    private static final Point PERSPECTIVE_TRANSLATION_LOCATION = new Point(620,10);

    public static void main(String[] args){
        Perspective init = new Perspective("Original",PERSPECTIVE_INIT_LOCATION,PERSPECTIVE_DIMENSION);
        Perspective zoom = new Perspective("Zoom",PERSPECTIVE_ZOOM_LOCATION,PERSPECTIVE_DIMENSION);
        Perspective translation = new Perspective("Translation",PERSPECTIVE_TRANSLATION_LOCATION,PERSPECTIVE_DIMENSION);

        ArrayList<Perspective> perspectives = new ArrayList<>();
        perspectives.add(init);
        perspectives.add(zoom);
        perspectives.add(translation);

        Fenetre fenetre = new Fenetre(perspectives);

        System.out.println(fenetre.getPerspectives().size() + " perspectives detected");
    }
}
