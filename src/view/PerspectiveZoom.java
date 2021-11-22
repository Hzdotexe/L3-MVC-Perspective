package view;

import observer.Observer;

import java.awt.*;

public class PerspectiveZoom extends Perspective implements Observer {

    public  PerspectiveZoom(String type, Point location, Dimension dimension)
    {
        super(type, location, dimension);
    }

    @Override
    public void update() {

    }
}
