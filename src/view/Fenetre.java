package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Fenetre extends JFrame {

    public final int HEIGHT_FRAME = 800;
    public final int WIDTH_FRAME = 1000;
    private JPanel superPanel;
    private JMenuBar menuBar;

    public Fenetre()  {

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
        createSuperPanel();
        this.add(this.superPanel);

        this.setVisible(true);
    }

    private void createSuperPanel(){
        this.superPanel = new JPanel();
        this.superPanel.setLayout(new GridLayout(2,2, 10, 10));
        this.superPanel.setBackground(Color.GRAY);
        addZoomPerspective(this.superPanel);
        addTranslationPerspective(this.superPanel);
        addInitPerspective(this.superPanel);


    }

    private void addInitPerspective(JPanel superPanel){
        Perspective init = new Perspective(Color.RED);
        Border border = BorderFactory.createTitledBorder("Original Perspective");
        init.setSize(350,350);
        init.setBorder(border);
        init.setLayout(new BoxLayout(init, BoxLayout.X_AXIS));
        superPanel.add(init);
    }

    private void addZoomPerspective(JPanel superPanel){
        Perspective zoom = new Perspective(Color.BLUE);
        Border border = BorderFactory.createTitledBorder("Zoom Perspective");
        zoom.setSize(350,350);
        zoom.setBorder(border);
        zoom.setLayout(new BoxLayout(zoom, BoxLayout.Y_AXIS));
        superPanel.add(zoom);
    }

    private void addTranslationPerspective(JPanel superPanel){
        Perspective translation = new Perspective(Color.GREEN);
        Border border = BorderFactory.createTitledBorder("Translation Perspective");
        translation.setSize(350,350);
        translation.setBorder(border);
        translation.setLayout(new BoxLayout(translation, BoxLayout.Y_AXIS));
        superPanel.add(translation);
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
            // Créer un filtre
            FileNameExtensionFilter filtre = new FileNameExtensionFilter(".png", "png");
            fileChooser.addChoosableFileFilter(filtre);

            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
            }
        });
        menu.add(load);
        menu.add(save);
        menuBar.add(menu);
    }
}
