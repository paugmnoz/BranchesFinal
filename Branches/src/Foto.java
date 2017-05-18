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

	public Foto(Mundo m, float x, float y, float tam, PApplet app) {
		encontroLlave = false;
		this.x = x;
		this.y = y;
		this.tam = tam;
		this.m = m;
		this.app = app;
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
		xUno = 1608;
		yUno = 808;
		xDos = 1576;
		yDos = 413;
		xTres = 1171;
		yTres = 277;
		xCuatro = 1119;
		yCuatro = 679;
		xCinco = 759;
		yCinco = 311;
		xSeis = 724;
		ySeis = 681;
		xSiete = 318;
		ySiete = 216;
		xOcho = 303;
		yOcho = 667;
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
		if (animUno)
			calculoFotoUno();
		if (animDos)
			calculoFotoDos();
		if (animTres)
			calculoFotoTres();
		if (animCuatro)
			calculoFotoCuatro();
		if (animCinco)
			calculoFotoCinco();
		if (animSeis)
			calculoFotoSeis();
		if (animSiete)
			calculoFotoSiete();
		if (animOcho)
			calculoFotoOcho();
	}

	public void activarAnimaciones(PApplet app) {
		this.app = app;
		// Uno
		if (zonaUno(app.mouseX, app.mouseY)) {
			animUno = true;
			//System.out.println("Activa animación Foto Uno");
		}
		// Dos
		if (zonaDos(app.mouseX, app.mouseY))
			animDos = true;
		// Tres
		if (zonaTres(app.mouseX, app.mouseY))
			animTres = true;
		// Cuatro
		if (zonaCuatro(app.mouseX, app.mouseY))
			animCuatro = true;
		// Cinco
		if (zonaCinco(app.mouseX, app.mouseY))
			animCinco = true;
		// Seis
		if (zonaSeisObjetivo(app.mouseX, app.mouseY))
			animSeis = true;
		// Siete
		if (zonaSiete(app.mouseX, app.mouseY))
			animSiete = true;
		// Ocho
		if (zonaOcho(app.mouseX, app.mouseY))
			animOcho = true;
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
		if (numTres >= fotoTres.length - 1) {
			numTres = fotoTres.length - 1;
		}
	}

	public void calculoFotoCuatro() {
		if(app.frameCount % 10 == 0)
		numCuatro++;
		if (	numCuatro >= fotoCuatro.length - 1) {
				numCuatro = 10;
		}
	}

	public void calculoFotoCinco() {
		numCinco++;
		if (numCinco >= fotoCinco.length - 1) {
			numCinco = fotoCinco.length - 1;
		}
	}

	public void calculoFotoSeis() {
		numSeis++;
		if (numSeis >= fotoSeis.length - 1) {
			numSeis = fotoSeis.length - 1;
		}
	}

	public void calculoFotoSiete() {
		numSiete++;
		if (numSiete >= fotoSiete.length - 1) {
			numSiete = fotoSiete.length - 1;
		}
	}

	public void calculoFotoOcho() {
		numOcho++;
		if (numOcho >= fotoOcho.length - 1) {
			numOcho = fotoOcho.length - 1;
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
		app.image(fotoUno[numUno], app.width / 2, app.height / 2);
	}

	public void animacionFotoDos(PApplet app) {
		this.app = app;
		app.image(fotoDos[numDos], app.width / 2, app.height / 2);
	}

	public void animacionFotoTres(PApplet app) {
		this.app = app;
		app.image(fotoTres[numTres], app.width / 2, app.height / 2);
	}

	public void animacionFotoCuatro(PApplet app) {
		this.app = app;
		app.image(fotoCuatro[numCuatro], app.width / 2, app.height / 2);
	}

	public void animacionFotoCinco(PApplet app) {
		this.app = app;
		app.image(fotoCinco[numCinco], app.width / 2, app.height / 2);
	}

	public void animacionFotoSeis(PApplet app) {
		this.app = app;
		app.image(fotoSeis[numSeis], app.width / 2, app.height / 2);
	}

	public void animacionFotoSiete(PApplet app) {
		this.app = app;
		app.image(fotoSiete[numSiete], app.width / 2, app.height / 2);
	}

	public void animacionFotoOcho(PApplet app) {
		this.app = app;
		app.image(fotoOcho[numOcho], app.width / 2, app.height / 2);
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

	public boolean zonaTres(int cx, int cy) {
		return PApplet.dist(xTres, yTres, cx, cy) < 30;
	}

	public boolean zonaCuatro(int cx, int cy) {
		return PApplet.dist(xCuatro, yCuatro, cx, cy) < 30;
	}

	public boolean zonaCinco(int cx, int cy) {
		return PApplet.dist(xCinco, yCinco, cx, cy) < 30;
	}

	public boolean zonaSeisObjetivo(int cx, int cy) {
		return PApplet.dist(xSeis, ySeis, cx, cy) < 30;
	}

	public boolean zonaSiete(int cx, int cy) {
		return PApplet.dist(xSiete, ySiete, cx, cy) < 30;
	}

	public boolean zonaOcho(int cx, int cy) {
		return PApplet.dist(xOcho, yOcho, cx, cy) < 30;
	}

	// -----------------------FINAL DE LA CLASE FOTO--------------------//
}
