import processing.core.PApplet;
import processing.core.PImage;

public class Pote {

	private PApplet app;
	private PImage pote;
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
		pote = m.getCargar().getPote();
	}

	public void pintar(PApplet app) {
		this.app = app;
		app.pushMatrix();
		app.translate(x, y);
		rotar(app);
		app.image(pote, 0, 0, 150, 150);
		app.popMatrix();
	}

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
	public void mover() {
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

	public void enderezar() {

	}

	/*
	 * Metodo para inclinar el PImage segun la direccion del movimiento
	 */
	public void inclinar(PApplet app) {

	}

	// GETTERS Y SETTERS
	public PImage getPote() {
		return pote;
	}

	public void setPote(PImage pote) {
		this.pote = pote;
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
