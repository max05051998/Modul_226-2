package Grafikeditor;//package lektion2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * Die Klasse Display stellt ein Fenster auf dem Bildschirm zur Verf�gung, in welchem
 * Figur-Objekte dargestellt werden k�nnen.
 * Siehe auch Java-Grundkurs Abschnitt 10.2 und 10.3.
 *
 * @author Andres Scheidegger
 */
@SuppressWarnings("serial")
public class Display extends JFrame {

    /**
     * Die Liste der dargestellten Figur-Objekte
     */

    private List<Figur> figuren = new ArrayList<Figur>();

    /**
     * Konstruktor. Initialisiert das Fenster in der Mitte des Bildschirms und erzeugt ein
     * JFrame-Objekt, auf welchem die Figuren gezeichnet werden.
     */

    public Display() {
        Dimension windowSize = new Dimension(800, 600);
        setSize(windowSize);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int windowPositionX = (screenSize.width - windowSize.width) / 2;
        int windowPositionY = (screenSize.height - windowSize.height) / 2;
        Point windowPosition = new Point(windowPositionX, windowPositionY);
        setLocation(windowPosition);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createAndAddDrawingPanel();

        /** Added for design purposes */
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

    private void createAndAddDrawingPanel() {
        String figurenListe[] = {"","Bogen", "Kreis", "Trapez", "Linie", "Rechteck"};

        JPanel jPanelMain = new JPanel();
        JPanel jPanelButtons = new JPanel();
        JButton jButtonDelete = new JButton();
        JButton jButtonAdd = new JButton();
        JComboBox jComboBoxFiguren = new JComboBox(figurenListe) {
            @Override
            public Dimension getMaximumSize() {
                Dimension dim = super.getMaximumSize();
                dim.height = getPreferredSize().height;
                return dim;
            }
        };

        jPanelMain.setLayout(new BoxLayout(jPanelMain, BoxLayout.Y_AXIS));

        jPanelButtons.setLayout(new BoxLayout(jPanelButtons, BoxLayout.X_AXIS));

        jButtonDelete.setText("Alles Löschen");
        jButtonDelete.setFocusPainted(false);
        jButtonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allesLoeschen();
            }
        });

        jButtonAdd.setText("Figur hinzufügen");
        jButtonAdd.setFocusPainted(false);
        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Figur selectedObject = null;
                if (jComboBoxFiguren.getSelectedIndex() < 0) {
                    JOptionPane.showMessageDialog(jPanelMain, "Bitte wähle eine Figur aus die erstellt werden soll");
                }
                else {
                    switch (jComboBoxFiguren.getSelectedIndex()) {
                        case 0: break;
                        case 1: selectedObject = new Bogen(400, 300, 150, 150, 0, 0);
                            break;
                        case 2: selectedObject = new Kreis(400, 300, 50);
                            break;
                        case 3: selectedObject = new Trapez(400, 300, 150, 300, 100);
                            break;
                        case 4: selectedObject = new Linie(400, 300, 400, 400);
                            break;
                        case 5: selectedObject = new Rechteck(400, 300, 150, 150);
                            break;
                    }
                    hinzufuegen(selectedObject);
                }
            }
        });


        this.getContentPane().add(jPanelMain);
        // Das JPanel-Objekt ist ein Objekt einer anonymen Unterklasse von JPanel
        // Siehe Java-Grundkurs Abschnitt 3.9
        jPanelMain.add(new JPanel() {
            // Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
            // Methode beim Display aufruft.
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                zeichneFiguren(g);
            }
        });
        jPanelMain.add(jPanelButtons);

        jPanelButtons.add(jButtonDelete);
        jPanelButtons.add(jButtonAdd);
        jPanelButtons.add(jComboBoxFiguren);

        // Alle Elemente auf kleinstmögliche Grösse bringen/
        //pack();
    }

    /**
     * Zeichnet alle Figuren.
     *
     * @param g Referenz auf das Graphics-Objekt zum zeichnen.
     */

    private void zeichneFiguren(Graphics g) {
        for (Figur f : figuren) {
            f.zeichne(g);
        }
    }

    /**
     * F�gt eine weitere Figur hinzu und l�st die Auffrischung des Fensterinhaltes aus.
     *
     * @param figur Referenz auf das weitere Figur-Objekt.
     */

    public void hinzufuegen(Figur figur) {
        figuren.add(figur);
        repaint();
    }

    /**
     * L�scht alle Figuren und l�st die Auffrischung des Fensterinhaltes aus.
     */

    public void allesLoeschen() {
        figuren.clear();
        repaint();
    }
}
