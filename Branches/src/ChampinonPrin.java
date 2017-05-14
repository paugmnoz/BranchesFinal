import processing.core.PApplet;
import processing.core.PImage;
//
public class ChampinonPrin {
	private PImage champ;
	private float x, y;
	private float tam;

	public ChampinonPrin(PApplet app, float x, float y) {
		this.x = x;
		this.y = y;
		champ = app.loadImage("../data/ChampPrin.png");
		cargarInstruccion();
		tam = 50;
	}

	/*
	 * metodo para cargar las imagenes de las intrucciones
	 */
	public void cargarInstruccion() {

	}

	/*
	 * Método que nos pintara los champiñones
	 */
	public void pintar(PApplet app) {
		app.image(champ, x, y, champ.width/2 + tam, champ.height/2 + tam);
	}

	/*
	 * metodo para reproducir las animaciones cuando el usuario toca el objeto
	 * champinon
	 */
	public void animarInstruccion() {

	}
}
