package view;

import java.awt.*;

public class GUI {

    private static final Dimension PERSPECTIVE_DIMENSION = new Dimension(350, 350);
    private static final Point PERSPECTIVE_INIT_LOCATION = new Point(315,380);
    private static final Point PERSPECTIVE_ZOOM_LOCATION = new Point(15,10);
    private static final Point PERSPECTIVE_TRANSLATION_LOCATION = new Point(620,10);


    public static void main(String[] args){

        Perspective init = new Perspective("Original",PERSPECTIVE_INIT_LOCATION,PERSPECTIVE_DIMENSION);
        PerspectiveZoom zoom = new PerspectiveZoom("Zoom",PERSPECTIVE_ZOOM_LOCATION,PERSPECTIVE_DIMENSION);
        PerspectiveTranslation translation = new PerspectiveTranslation("Translation",PERSPECTIVE_TRANSLATION_LOCATION,PERSPECTIVE_DIMENSION);

        Fenetre fenetre = new Fenetre(init, zoom, translation);
        fenetre.addPerspective(translation);
        fenetre.addPerspective(init);
        fenetre.addPerspective(zoom);

        System.out.println(fenetre.getPerspectives().size()+" perspectives detected");

    }
}
