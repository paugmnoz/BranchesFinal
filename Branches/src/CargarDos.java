import processing.core.PApplet;
import processing.core.PImage;

public class CargarDos extends Thread {
	private PApplet app;
	private PImage[] finalito;
	private PImage insUno, insDos, insTres, insCuatro;
	private boolean cargado;

	public CargarDos(PApplet app) {
		this.app = app;
		cargado = false;
	}

	public void run() {
		try {
			sleep(15);
			cargarIns();
			cargarFinal();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void cargarIns() {

		insUno = app.loadImage("../data/Instrucciones_1/InsUno_80.png");

		insDos = app.loadImage("../data/Instrucciones/InstruccionesDos/InstruccionesDos_14.png");

		insTres = app.loadImage("../data/instrucciones/InstruccionesTres/instruccionesTres_24.png");

		insCuatro = app.loadImage("../data/Instrucciones/instruccionesCuatro/instruccionesCuatro_7.png");

	}

	public void cargarFinal() {
		finalito = new PImage[188];
		for (int i = 0; i < finalito.length; i++) {
			finalito[i] = app.loadImage("../data/FinalUno/Final_" + i + ".png");
		}
	}

	public PImage[] getFinalito() {
		return finalito;
	}

	public PImage getInsDos() {
		return insDos;
	}

	public PImage getInsUno() {
		return insUno;
	}

	public PImage getInsTres() {
		return insTres;
	}

	public PImage getInsCuatro() {
		return insCuatro;
	}
}
