import processing.core.PApplet;
import processing.core.PImage;

public class Pote {

	private PApplet app;
	private PImage poteAtras, poteAdelante;
	private float x, y;
	private boolean rotar;
	private Mundo m;

	public Pote(Mundo m) {
		this.m = m;
		cargar();
		rotar = false;
	}

	/*
	 * Método que nos pintara el pote
	 */

	public void cargar() {
		x = 960;
		y = 540;
		poteAtras = m.getCargar().getPoteAtras();
		poteAdelante = m.getCargar().getPoteAdelante();
	}

	public void pintar(PApplet app) {
		this.app = app;
		app.pushMatrix();
		app.translate(x, y);
		rotar(app);
		app.image(poteAtras, 0, 0, 150, 150);
		app.image(poteAdelante, 0, 0, 150, 150);
		app.popMatrix();
	}

	/*
	 * Metodo para inclinar el PImage segun la direccion del movimiento
	 */
	public void rotar(PApplet app) {
		this.app = app;
		if (app.keyPressed) {
			if (app.keyCode == app.RIGHT) {
				app.rotate(app.radians(20));
			}
			if (app.keyCode == app.LEFT) {
				app.rotate(app.radians(-20));
			}
		}
	}

	/*
	 * Método para mover por la pantalla el pote
	 */
	public void mover(PApplet app) {
		this.app = app;
		if (app.keyCode == app.RIGHT) {
			x += 9;
		}
		if (app.keyCode == app.LEFT) {
			x -= 9;
		}
		if (app.keyCode == app.UP) {
			y -= 9;
		}
		if (app.keyCode == app.DOWN) {
			y += 9;
		}
	}

	// GETTERS Y SETTERS
	public PImage getPoteAtras() {
		return poteAtras;
	}

	public void setPote(PImage pote) {
		this.poteAtras = poteAtras;
	}
	
	public PImage getPoteAdelante() {
		return poteAtras;
	}

	public void setPoteAdelante(PImage pote) {
		this.poteAdelante = poteAdelante;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	// FINAL DE LA CLASE POTE
}
