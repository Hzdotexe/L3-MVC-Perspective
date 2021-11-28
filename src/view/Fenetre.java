package view;

import controller.action.LoadAction;
import controller.action.PerspectiveTranslationAction;
import model.ImageModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
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
 Nom du fichier: Fenetre.java
 Date créé: 2021-11-15
 *******************************************************/

public class Fenetre extends JFrame {

    public final int HEIGHT_FRAME = 800;
    public final int WIDTH_FRAME = 1000;
    public ImageModel img;
    private JPanel superPanel;
    private JMenuBar menuBar;
    private ArrayList<Perspective> perspectives = new ArrayList<>();



    public Fenetre(Perspective init, Perspective zoom, Perspective translation)  {

        //Config de la fenetre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("LOG121 - Labo 3");
        this.setSize(WIDTH_FRAME,HEIGHT_FRAME);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //Config du menu et l'ajouter a la fenetre
        configMenu();
        this.setJMenuBar(menuBar);

        //Ajout du panneau englobant
        createSuperPanel(init, zoom , translation);
        this.add(this.superPanel);

        this.setVisible(true);


        //Créer les actions
        translation.addMouseListener(new PerspectiveTranslationAction(this,translation.getImageModel(),"Translation pressed",null,
                "Translation l'image",KeyEvent.VK_A));
        translation.addMouseMotionListener(new PerspectiveTranslationAction(this,translation.getImageModel(),"Translation dragged",null,
                "Translation l'image",KeyEvent.VK_V));


    }


    private void createSuperPanel(Perspective init, Perspective zoom, Perspective translation){
        this.superPanel = new JPanel();
        this.superPanel.setLayout(null);
        this.superPanel.setBackground(Color.GRAY);
        this.superPanel.add(init);
        this.superPanel.add(zoom);
        this.superPanel.add(translation);

    }

    private void configMenu(){

        this.menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem load = new JMenuItem("Load");
        JMenuItem save = new JMenuItem("Save");
        load.addActionListener(new LoadAction(this, "Charger", null, "Charger l'image", KeyEvent.VK_O));
        menu.add(load);
        menu.add(save);
        menuBar.add(menu);
    }

    public void addPerspective(Perspective perspective)
    {
        perspectives.add(perspective);
    }
    public ArrayList<Perspective> getPerspectives()
    {
        return this.perspectives;
    }

}
