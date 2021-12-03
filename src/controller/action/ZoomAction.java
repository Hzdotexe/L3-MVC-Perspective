/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s:  Anyin Zhang, Isaac David Zolana,
                Hanz Sami, Fatsy Ramampiarison,
                Nureddin Aida
 Professeur : Vincent Lacasse
 Nom du fichier: ZoomAction.java
 Date créé: 2021-11-22
 *******************************************************/
package controller.action;

import controller.command.ZoomCommand;
import controller.singleton.CommandManager;
import model.Perspective;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class ZoomAction implements MouseWheelListener {
    protected final static CommandManager COMMAND_MANAGER = CommandManager.getInstance();
    public static final int ZOOM_SPEED = 10;
    private Perspective perspective;

    public ZoomAction(Perspective perspective) {
        this.perspective = perspective;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() < 0) { // Zoom in
            COMMAND_MANAGER.execute(new ZoomCommand(perspective.getImageModel(), ZOOM_SPEED, ZOOM_SPEED));
        } else { // Zoom out
            COMMAND_MANAGER.execute(new ZoomCommand(perspective.getImageModel(), -ZOOM_SPEED, -ZOOM_SPEED));
        }
    }
}
