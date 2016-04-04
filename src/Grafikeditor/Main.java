package Grafikeditor;

public class Main {
	private static final Display display = new Display();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kreis k = new Kreis(50, 70, 75);
		Linie l = new Linie(150, 450, 700, 300);
		Rechteck r = new Rechteck(65, 200, 250, 150);
		Bogen b = new Bogen(400, 400, 200, 200, 0, 180);
		Trapez t = new Trapez(400, 75, 100, 200, 100);
		
		display.hinzufuegen(k);
		display.hinzufuegen(l);
		display.hinzufuegen(r);
		r.move(20, 150);
		display.hinzufuegen(r);
		//l.move(100, 130);
		display.hinzufuegen(b);
		//b.move(50, 50);
		display.hinzufuegen(t);

	}

}
