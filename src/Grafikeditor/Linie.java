package Grafikeditor;

import java.awt.Graphics;

public class Linie extends Figur {
	private int endX;
	private int endY;
	
	public Linie(int x, int y, int endX, int endY){
		super(x, y);
		this.endX = endX;
		this.endY = endY;
	}

	@Override
	public void move(int deltaX, int deltaY) {
		// TODO Auto-generated method stub
		super.move(deltaX, deltaY);
		this.endX = this.endX + deltaX;
		this.endY = this.endY + deltaY;
	}

	@Override
	public void zeichne(Graphics g) {
		// TODO Auto-generated method stub
		g.drawLine(x, y, endX, endY);
	}
	
	
}
