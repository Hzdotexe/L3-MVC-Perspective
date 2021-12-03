/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s:  Anyin Zhang, Isaac David Zolana,
                Hanz Sami, Fatsy Ramampiarison,
                Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: TranslationAction.java
 Date créé: 2021-11-22
 *******************************************************/
package controller.action;

import controller.command.TranslationCommand;
import controller.singleton.CommandManager;
import model.Perspective;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class TranslationAction extends MouseAdapter {
    protected final static CommandManager COMMAND_MANAGER = CommandManager.getInstance();
    private Point perspectiveCenter;
    private Point mousePoint;

    public TranslationAction(Perspective perspective) {
        this.perspectiveCenter = new Point(perspective.getWidth()/2, perspective.getHeight()/2);

        perspective.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int dx = e.getX() - mousePoint.x;
                int dy = e.getY() - mousePoint.y;
                perspectiveCenter.setLocation(perspectiveCenter.x+dx, perspectiveCenter.y+dy);
                mousePoint = e.getPoint();

                COMMAND_MANAGER.execute(new TranslationCommand(perspective.getImageModel(), dx, dy));
            }
        });
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mousePoint = e.getPoint();
    }
}
