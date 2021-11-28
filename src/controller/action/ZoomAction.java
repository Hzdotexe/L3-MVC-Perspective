package controller.action;

import controller.command.ZoomCommand;
import controller.singleton.CommandManager;
import view.Perspective;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/******************************************************
 Cours:   LOG121
 Session: A2021
 Groupe:  02
 Projet: Laboratoire #3
 Étudiant(e)s: Anyin Zhang, Isaac David Zolana,
               Hanz Sami, Fatsy Ramampiarison,
               Nureddin Aida
 Professeur :  Vincent Lacasse
 Nom du fichier: PerspectiveZoomAction.java
 Date créé: 2021-11-22
 *******************************************************/
public class ZoomAction implements MouseWheelListener {
    protected final static CommandManager cm = CommandManager.getInstance();
    private Perspective perspective;

    public ZoomAction(Perspective perspective) {
        this.perspective = perspective;
    }


    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() < 0) { // Zoom in
            cm.execute(new ZoomCommand(perspective.getImageModel(), 1, 1));
        } else { // Zoom out
            cm.execute(new ZoomCommand(perspective.getImageModel(), -1, -1));
        }
    }
}
