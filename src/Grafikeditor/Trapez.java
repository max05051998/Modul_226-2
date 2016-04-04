package Grafikeditor;

import java.awt.*;

public class Trapez extends Figur{
    private int breite1;
    private int breite2;
    private int hoehe;
    private Polygon poly;

    public Trapez(int x, int y, int breite1, int breite2, int hoehe) {
        super(x, y);
        this.breite1 = breite1;
        this.breite2 = breite2;
        this.hoehe = hoehe;

    }

    @Override
    public void zeichne(Graphics g) {
        int xPosition[] = new int[4];
        int yPosition[] = new int[4];
        if (breite1 < breite2) {
            xPosition[0] = x + ((breite2 - breite1) / 2);
            yPosition[0] = y;
            xPosition[1] = xPosition[0] + breite1;
            yPosition[1] = y;
            xPosition[2] = x + breite2;
            yPosition[2] = y + hoehe;
            xPosition[3] = x;
            yPosition[3] = y + hoehe;
        }
        else {
            xPosition[0] = x;
            yPosition[0] = y;
            xPosition[1] = x + breite1;
            yPosition[1] = y;
            xPosition[2] = x + breite1 + ((breite1 - breite2) / 2);
            yPosition[2] = y + hoehe;
            xPosition[3] = x + ((breite1 - breite2) / 2);
            yPosition[3] = y + hoehe;
        }
        poly = new Polygon(xPosition, yPosition, xPosition.length);
        g.drawPolygon(poly);
    }
}
