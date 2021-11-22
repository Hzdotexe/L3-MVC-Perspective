package view;

import controleur.PatronCommand.Load;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 Nom du fichier: Fenetre.java
 Date créé: 2021-11-15
 *******************************************************/

public class Fenetre extends JFrame {

    public final int HEIGHT_FRAME = 800;
    public final int WIDTH_FRAME = 1000;
    public BufferedImage img = null;
    private JPanel superPanel;
    private JMenuBar menuBar;
    private ArrayList<Perspective> perspectives = new ArrayList<>();


    public Fenetre(Perspective init, PerspectiveZoom zoom, PerspectiveTranslation translation)  {

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
    }

    private void createSuperPanel(Perspective init, PerspectiveZoom zoom, PerspectiveTranslation translation){
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
        load.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            fileChooser.setCurrentDirectory(new File("src"));
            fileChooser.setDialogTitle("Sélectionnez une photo");
            fileChooser.setAcceptAllFileFilterUsed(false);

            // Create filters
            FileNameExtensionFilter filtreJpg = new FileNameExtensionFilter(".jpg", "jpg");
            FileNameExtensionFilter filtrePng = new FileNameExtensionFilter(".png", "png");
            FileNameExtensionFilter filtreJpeg = new FileNameExtensionFilter(".jpeg", "jpeg");

            // add filters
            fileChooser.addChoosableFileFilter(filtreJpg);
            fileChooser.addChoosableFileFilter(filtrePng);
            fileChooser.addChoosableFileFilter(filtreJpeg);

            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedImage image = ImageIO.read(fileChooser.getSelectedFile());
                    setImg(image);

                    //load using load command
                    Load loadImg = new Load();
                    loadImg.setWindow(this);
                    loadImg.doIt();

                    System.out.println("image loaded successfully");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        menu.add(load);
        menu.add(save);
        menuBar.add(menu);
    }

    public  void setImg(BufferedImage img)
    {
        this.img = img;
    }
    public BufferedImage getImg() {
        return this.img;
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
