package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Classe Controleur.
 * @author marounmelhem
 * @version 27-01-2024
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());

        boutons.add(push);
        boutons.add(add);
        boutons.add(sub);
        boutons.add(mul);
        boutons.add(div);
        boutons.add(clear);
        add(boutons);
        boutons.setBackground(Color.red);

        addActionListeners();
        actualiserInterface();
    }

    private void addActionListeners() {
        donnee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer value = operande();
                    pile.empiler(value);
                    donnee.setText("");
                    actualiserInterface();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Number Format");
                } catch (PilePleineException ex) {
                    JOptionPane.showMessageDialog(null, "Stack Full");
                }
            }
        });
        push.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer value = operande();
                    pile.empiler(value);
                    donnee.setText("");
                    actualiserInterface();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Number Format");
                } catch (PilePleineException ex) {
                    JOptionPane.showMessageDialog(null, "Stack Full");
                }
            }
        });

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation((a, b) -> a + b);
            }
        });

        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation((a, b) -> a - b);
            }
        });

        mul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation((a, b) -> a * b);
            }
        });

        div.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performOperation((a, b) -> {
                    if (b == 0) throw new ArithmeticException("Division by Zero");
                    return a / b;
                });
            }
        });

        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                while (!pile.estVide()) {
                    try {
                        pile.depiler();
                    } catch (PileVideException ignored) {
                    }
                }
                actualiserInterface();
            }
        });
    }

    private void performOperation(BinaryOperator<Integer> operation) {
        try {
            if (pile.taille() < 2) throw new Exception("Not enough elements");
            Integer b = pile.depiler();
            Integer a = pile.depiler();
            pile.empiler(operation.apply(a, b));
            actualiserInterface();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private interface BinaryOperator<T> {
        T apply(T a, T b) throws Exception;
    }

    public void actualiserInterface() {
        boolean enableOperations = pile.taille() >= 2;
        add.setEnabled(enableOperations);
        sub.setEnabled(enableOperations);
        mul.setEnabled(enableOperations);
        div.setEnabled(enableOperations);
        clear.setEnabled(!pile.estVide());
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }


    // à compléter
    // en cas d'exception comme division par zéro,
    // mauvais format de nombre suite à l'appel de la méthode operande
    // la pile reste en l'état (intacte)

}
