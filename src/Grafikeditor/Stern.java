/*
package Grafikeditor;

import java.awt.*;

public class Stern extends Figur {
    private int radius;
    private int anzahlSpitzen;
    private double rotation;

    public Stern(int x, int y, int radius, int anzahlSpitzen, double rotation) {
        super(x, y);
        this.radius = radius;
        this.anzahlSpitzen = anzahlSpitzen;
        this.rotation = rotation;
    }

    public int[][] calculateCoordinates(int radius, int anzahlSpitzen, int x, int y, double rotation){
        rotation -= Math.PI/2;
        double[][] coordinates = new double[2][2*anzahlSpitzen];
        for(int i = 0; i < 2*anzahlSpitzen; i++) {
            */
/*System.out.println(coordinates[0][i] = Math.cos(Math.PI/anzahlSpitzen*i + rotation));
            System.out.println(coordinates[1][i] = Math.sin(Math.PI/anzahlSpitzen*i + rotation));*//*

            coordinates[0][i] = Math.cos(Math.PI/anzahlSpitzen*i + rotation);
            coordinates[1][i] = Math.sin(Math.PI/anzahlSpitzen*i + rotation);
        }
        int [][] result = new int[2][2*anzahlSpitzen];
        for(int i = 0; i < 2*anzahlSpitzen; i++) {
            result[0][i] = (int) Math.round(coordinates[0][i]*radius) + x;
            result[1][i] = (int) Math.round(coordinates[1][i]*radius) + y;
            i++;
            //mit dem Faktor .37 sehen die Sterne halbwegs sinnvoll aus
            //koennte man natuerlich auch noch ausrechnen
            result[0][i] = (int) Math.round(coordinates[0][i]*radius*.37) + x;
            result[1][i] = (int) Math.round(coordinates[1][i]*radius*.37) + y;
        }
        return result;
    }


    @Override
    public void zeichne(Graphics g) {
        int[][] Coordinates = calculateCoordinates(radius, anzahlSpitzen, x, y, rotation);
        int[] xPolygon;
        for (int i = 0; i < Coordinates[0].length; i++){
        xPolygon[i] = Coordinates[0][i]
        g.drawPolygon();
    }
}
*/
