import processing.core.PApplet;
import processing.core.PImage;

public class Arbol extends Thread {

	private PApplet app;
	private PImage[] arbol;
	private int numFrame;
	private Mundo m;
	private boolean vivo;

	public Arbol(Mundo m) {
		this.m = m;
		numFrame = 0;
		vivo = true;
		cargar();
	}

	public void run() {
		try {
			while(vivo){
			sleep(15);
			//calculo();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cargar() {
		arbol = m.getCargar().getArbol();
	}

	public void calculo() {
		numFrame++;
		if (numFrame >= arbol.length) {
			numFrame = 0;
		}
	}

	public void pintar(PApplet app) {
		this.app = app;
		System.out.println("PApplet arbol: " + app);
		app.image(arbol[numFrame], app.width / 2, app.height / 2);
	}

}
