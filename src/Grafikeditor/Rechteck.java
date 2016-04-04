package Grafikeditor;

import java.awt.Graphics;

public class Rechteck extends Figur {
	private int hoehe;
	private int breite;
	
	public  Rechteck(int x, int y, int hoehe, int breite){
		super(x, y);
		this.hoehe = hoehe;
		this.breite = breite;
	}

	@Override
	public void zeichne(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(x, y, hoehe, breite);
	}

}
