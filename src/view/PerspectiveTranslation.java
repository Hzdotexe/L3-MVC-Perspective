package view;

import observer.Observer;

import java.awt.*;

public class PerspectiveTranslation extends Perspective implements Observer {

    public PerspectiveTranslation(String type, Point location, Dimension dimension)
    {
        super(type, location, dimension);
    }

    @Override
    public void update() {

    }
}
