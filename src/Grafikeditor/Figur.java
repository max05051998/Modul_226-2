package Grafikeditor;

import java.awt.Graphics;

public abstract class Figur {
	protected	int x;
	protected	int y;
	public abstract void zeichne(Graphics g);
	
	public Figur(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void move(int deltaX, int deltaY){
		this.x =+ deltaX;
		this.y =+ deltaY;
	}

	
}
