package question3;

import javax.swing.*;
import java.util.Observer;
/**
 * Description of class VueCalculette.
 *
 * @author marounmelhem
 * @version 27-01-2024
 */
public class VueCalculette extends JPanel implements Observer {

    private JLabel display;
    private Calculette model;

    //public VueCalculette(Calculette model)

    //public void updateDisplay(String text)   display.setText(text);

    @Override
    public void update(java.util.Observable o, Object arg) {}

    // Additional GUI components and methods...
}
