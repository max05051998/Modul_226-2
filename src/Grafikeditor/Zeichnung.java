package Grafikeditor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class Zeichnung {

    private List<Figur> figures = new ArrayList<>();

    void addFigure(Figur figur) {
        figures.add(figur);
    }

    void drawFigure(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        for (Figur figur: figures) {
            figur.zeichne(g2d);
        }
    }

    public void deleteAll() {
        figures.clear();
    }
}