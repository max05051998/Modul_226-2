package Grafikeditor;

import java.awt.Graphics;

public class Bogen extends Figur{
	private int breite;
	private int hoehe;
	private int startWinkel;
	private int bogenWinkel;
	
	public Bogen(int x, int y, int breite, int hoehe, int startWinkel, int bogenWinkel) {
		super(x, y);
		this.breite = breite;
		this.hoehe = hoehe;
		this.startWinkel = startWinkel;
		this.bogenWinkel = bogenWinkel;
	}

	@Override
	public void zeichne(Graphics g) {
		g.drawArc(x, y, breite, hoehe, startWinkel, bogenWinkel);
	}

}
