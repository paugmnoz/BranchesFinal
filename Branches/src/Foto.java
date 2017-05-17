import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Foto extends Thread {

	private PApplet app;
	private Llave llave;
	private boolean encontroLlave;
	private boolean vivo;
	private boolean animUno, animDos, animTres, animCuatro, animCinco, animSeis, animSiete, animOcho;
	private float x, y, tam;
	private Mundo m;
	private PImage[] fotoUno, fotoDos, fotoTres, fotoCuatro, fotoCinco, fotoSeis, fotoSiete, fotoOcho;
	private int numUno, numDos, numTres, numCuatro, numCinco, numSeis, numSiete, numOcho;
	private int xUno, yUno, xDos, yDos, xTres, yTres, xCuatro, yCuatro, xCinco, yCinco, xSeis, ySeis, xSiete, ySiete,
			xOcho, yOcho;
	private PImage fondo;

	public Foto(Mundo m, float x, float y, float tam) {
		encontroLlave = false;
		this.x = x;
		this.y = y;
		this.tam = tam;
		this.m = m;
		vivo = true;
		// llave = new Llave(m, 802, 547, 30);
		cargarImagen();
		iniciarVariables();
	}

	public void run() {
		try {
			while (vivo) {
				sleep(15);
				calculoAnimaciones();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void iniciarVariables() {
		xUno = 1242;
		yUno = 675;
		// Boolean
		animUno = false;
		animDos = false;
		animTres = false;
		animCuatro = false;
		animCinco = false;
		animSeis = false;
		animSiete = false;
		animOcho = false;
	}

	public void cargarImagen() {
		fondo = m.getCargar().getFondo();
		fotoUno = m.getCargar().getFotoUno();
		fotoDos = m.getCargar().getFotoDos();
		fotoTres = m.getCargar().getFotoTres();
		fotoCuatro = m.getCargar().getFotoCuatro();
		fotoCinco = m.getCargar().getFotoCinco();
		fotoSeis = m.getCargar().getFotoSeis();
		fotoSiete = m.getCargar().getFotoSiete();
		fotoOcho = m.getCargar().getFotoOcho();
	}

	// -----------------CALCULO DE LOS FRAMES DE LAS ANIMACIONES------------//
	public void calculoAnimaciones() {
		if(animUno)
		calculoFotoUno();
		if(animDos)
		calculoFotoDos();
		calculoFotoTres();
		calculoFotoCuatro();
		calculoFotoCinco();
		calculoFotoSeis();
		calculoFotoSiete();
		calculoFotoOcho();
	}

	public void activarAnimaciones(PApplet app) {
		this.app = app;
		//Uno
		if (zonaUno(app.mouseX, app.mouseY)) {
			animUno = true;
			System.out.println("Activa animación Foto Uno");
		}
		//Uno
		if (zonaDos(app.mouseX, app.mouseY))
			animDos = true;
	}

	public void calculoFotoUno() {
		numUno++;
		if (numUno >= fotoUno.length - 1) {
			numUno = fotoUno.length - 1;
		}
	}

	public void calculoFotoDos() {
		numDos++;
		if (numDos >= fotoDos.length - 1) {
			numDos = fotoDos.length - 1;
		}
	}

	public void calculoFotoTres() {
		numTres++;
		if (numTres >= fotoTres.length) {
			numTres = fotoTres.length;
		}
	}

	public void calculoFotoCuatro() {
		numCuatro++;
		if (numCuatro >= fotoCuatro.length) {
			numCuatro = fotoCuatro.length;
		}
	}

	public void calculoFotoCinco() {
		numCinco++;
		if (numCinco >= fotoCinco.length) {
			numCinco = fotoCinco.length;
		}
	}

	public void calculoFotoSeis() {
		numSeis++;
		if (numSeis >= fotoSeis.length) {
			numSeis = fotoSeis.length;
		}
	}

	public void calculoFotoSiete() {
		numSiete++;
		if (numSiete >= fotoSiete.length) {
			numSiete = fotoSiete.length;
		}
	}

	public void calculoFotoOcho() {
		numOcho++;
		if (numOcho >= fotoOcho.length) {
			numOcho = fotoOcho.length;
		}
	}

	// -----------------------PINTAR-----------------------//
	public void pintarImagen(PApplet app) {
		this.app = app;
		app.image(fondo, app.width / 2, app.height / 2);
		activarAnimaciones(app);
		animaciones(app);
	}

	// ----------------------PINTAR ANIMACIONES--------------//

	public void animaciones(PApplet app) {
		this.app = app;
		animacionFotoUno(app);
		animacionFotoDos(app);
		animacionFotoTres(app);
		animacionFotoCuatro(app);
		animacionFotoCinco(app);
		animacionFotoSeis(app);
		animacionFotoSiete(app);
		animacionFotoOcho(app);
	}

	public void animacionFotoUno(PApplet app) {
		this.app = app;
		//app.image(fotoUno[0], app.width / 2, app.height / 2);
		//if (animUno)
			app.image(fotoUno[numUno], app.width / 2, app.height / 2);
	}

	public void animacionFotoDos(PApplet app) {
		this.app = app;
		app.image(fotoDos[0], app.width / 2, app.height / 2);
		if (animDos)
			app.image(fotoDos[numDos], app.width / 2, app.height / 2);
	}

	public void animacionFotoTres(PApplet app) {
		this.app = app;
	}

	public void animacionFotoCuatro(PApplet app) {
		this.app = app;
	}

	public void animacionFotoCinco(PApplet app) {
		this.app = app;
	}

	public void animacionFotoSeis(PApplet app) {
		this.app = app;
	}

	public void animacionFotoSiete(PApplet app) {
		this.app = app;
	}

	public void animacionFotoOcho(PApplet app) {
		this.app = app;
	}

	public void click(PApplet app) {
		this.app = app;
		if (PApplet.dist(app.mouseX, app.mouseY, 802, 547) < 50) {
			encontroLlave = true;
		}
	}

	// ----------------------ZONAS SENSIBLES DE ANIMACIONES------------------//
	public boolean zonaUno(int cx, int cy) {
		return PApplet.dist(xUno, yUno, cx, cy) < 100;
	}

	public boolean zonaDos(int cx, int cy) {
		return PApplet.dist(xDos, yDos, cx, cy) < 30;
	}

	public boolean zonaTres() {
		return true;
	}

	public boolean zonaCuatro() {
		return true;
	}

	public boolean zonaCinco() {
		return true;
	}

	public boolean zonaSeisObjetivo() {
		return true;
	}

	public boolean zonaSiete() {
		return true;
	}

	public boolean zonaOcho() {
		return true;
	}

	public boolean zonaNueve() {
		return true;
	}

}
