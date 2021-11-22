package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Perspective extends JPanel {

    public Perspective(String type, Point location, Dimension dimension){
        Border border = BorderFactory.createTitledBorder(type+ "Perspective");
        this.setBorder(border);
        this.setSize(dimension);
        this.setLocation(location);
    }
}
