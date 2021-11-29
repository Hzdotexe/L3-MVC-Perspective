package view;

import controller.action.*;
import model.Perspective;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.event.KeyEvent;
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

        //Actions pour les panneaux
        translation.addMouseListener(new TranslationAction(translation));
        zoom.addMouseWheelListener(new ZoomAction(zoom));

        this.add(this.superPanel);
        this.setVisible(true);
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
        JMenu fichier = new JMenu("Fichier");
        JMenuItem load = new JMenuItem(new LoadAction(this, "Load", null, "Charger l'image", KeyEvent.VK_O));
        JMenuItem save = new JMenuItem(new SaveAction(this, "Save", null, "Sauvegarder l'image", KeyEvent.VK_S));
        fichier.add(load);
        fichier.add(save);

        JMenu edition = new JMenu("Edition");
        JMenuItem undo = new JMenuItem(new UndoAction(this, "Undo", null, "Défaire une action", KeyEvent.VK_Z));
        edition.add(undo);

        JMenu image = new JMenu("Image");

        menuBar.add(fichier);
        menuBar.add(edition);
        menuBar.add(image);
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
