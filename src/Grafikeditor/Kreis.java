package Grafikeditor;

import java.awt.Graphics;

public class Kreis extends Figur {
	private int radius;
	
	public Kreis(int x, int y, int radius){
		super(x, y);
		this.radius = radius;
	}

	@Override
	public void zeichne(Graphics g) {
		// TODO Auto-generated method stub
		g.drawOval(x, y, 2*radius, 2*radius);
	}
}
