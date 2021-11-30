package view;
import controller.action.TranslationAction;
import controller.action.ZoomAction;
import controller.action.SaveAction;
import controller.action.UndoAction;
import controller.action.LoadFileAction;
import controller.action.LoadImageAction;
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
    private ArrayList<Perspective> perspectives;

    public Fenetre(ArrayList<Perspective> perspectives)  {
        //Config de la fenetre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("LOG121 - Labo 3");
        this.setSize(WIDTH_FRAME,HEIGHT_FRAME);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.perspectives = perspectives;

        //Config du menu et l'ajouter a la fenetre
        configMenu();
        this.setJMenuBar(menuBar);

        //Ajout du panneau englobant
        createSuperPanel();
        this.setVisible(true);
    }


    private void createSuperPanel(){
        super.getContentPane().setLayout(null);
        super.getContentPane().setBackground(Color.GRAY);

        for (Perspective perspective: perspectives) {
            super.getContentPane().add(perspective);

            switch (perspective.getType()) {
                case "Zoom": perspective.addMouseWheelListener(new ZoomAction(perspective));
                    break;
                case "Translation": perspective.addMouseListener(new TranslationAction(perspective));
            }
        }
    }

    private void configMenu(){
        this.menuBar = new JMenuBar();
        JMenu file = new JMenu("Fichier");
        JMenuItem loadFile = new JMenuItem(new LoadFileAction(this, "Load", "Charger un fichier de perspectives", KeyEvent.VK_O));
        JMenuItem save = new JMenuItem(new SaveAction(this, "Save", "Sauvegarder les perspectives ainsi que leur images", KeyEvent.VK_S));
        file.add(loadFile);
        file.add(save);

        JMenu edition = new JMenu("Edition");
        JMenuItem undo = new JMenuItem(new UndoAction(this, "Undo", "Défaire une action", KeyEvent.VK_Z));
        edition.add(undo);

        JMenu image = new JMenu("Image");
        JMenuItem loadImage = new JMenuItem(new LoadImageAction(this, "Load", "Charger l'image dans les perspectives", KeyEvent.VK_I));
        image.add(loadImage);

        this.menuBar.add(file);
        this.menuBar.add(edition);
        this.menuBar.add(image);
    }

    public void showPerspectives() {
        for (Perspective perspective: perspectives) {
            super.getContentPane().add(perspective);

            switch (perspective.getType()) {
                case "Zoom": perspective.addMouseWheelListener(new ZoomAction(perspective));
                    break;
                case "Translation": perspective.addMouseListener(new TranslationAction(perspective));
            }
        }
    }

    public ArrayList<Perspective> getPerspectives(){
        return this.perspectives;
    }
}
