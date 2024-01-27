package question2;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.TextArea;

/**
 * @author marounmelhem
 * @version 17-01-2024
 */
public class JMouseObserver implements MouseListener{

    private String nom;
    private TextArea contenu;

    /**
     * Créateur d'instances pour la classe JButtonObserver.
     */
    public JMouseObserver(String nom, TextArea contenu) {
        this.nom = nom;
        this.contenu = contenu;
    }

    /**
     * Affichage d'un message dans la zone de texte
     */
    public void mouseEntered(MouseEvent e) {
        String message = "observateur " + this.nom + " : souris entree en (" + e.getX() + "," + e.getY() + ")";
        contenu.append(message + "\n");
    }

    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}

}
