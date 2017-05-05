import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Mundo implements Runnable {

	private boolean moverC, abrirC, champinonPrin, libreta, lis;
	private int pantalla, numFrame, numFrameA, numFrameAbrir, numFrameAC, numFramePuerta;
	private int cajon, revUno;
	private float tam;
	private Libreta lib;
	private Lis liss;
	private ChampinonPrin champPrin;

	private Foto fotos;
	private Pote pote;
	private SelectorChamp selectorChamp;
	private ArrayList<Champinon> champ;
	private int contarChamps;

	private ArrayList<Calaverita> calaveritas;
	// para pre entrega
	int eX = 964, eY = 297;

	private PApplet app;

	private PImage[] cajonFlotante, abreCajon, acercaCajon, revUnoF, abrir, kuleshov;

	public Mundo(PApplet app) {
		this.app = app;
		inicializarVariables(app);
		cargarImagenes();
	}

	public void inicializarVariables(PApplet app) {
		lis = false;
		libreta = false;
		champinonPrin = false;
		// Nuevo
		fotos = new Foto(this, 0, 0, 30);
		pote = new Pote();
		champ = new ArrayList<Champinon>();
		for (int i = 0; i < 1000; i++) {
			champ.add(new Champinon((float) Math.random() * app.width,
					(float) ((app.height / 2 + 200) + Math.random() * app.height)));
		}
		selectorChamp = new SelectorChamp(this, app.mouseX, app.mouseY, 150);
		// Nuevo
		liss = new Lis();
		lib = new Libreta();
		champPrin = new ChampinonPrin(app, app.width / 2 + 400, app.height / 2 - 50);
		calaveritas = new ArrayList<Calaverita>();
		numFrame = 0;

	}

	public void cargarImagenes() {
		cargarCajonF();
		cargarAbreCajon();
		cargarCajonAbrir();
		cargarAcercarCajon();
		cargarFondo();
		cargarKuleshov();
		// Nuevo
		cargarFotos();
		cargarPantallaArbol();
		// Nuevo
	}

	// Nuevo
	public void cargarChamp() {
		for (int i = 0; i < champ.size(); i++) {
			champ.get(i).cargar(app);
		}
	}

	public void cargarFotos() {
		fotos.cargarImagen(app);
	}

	public void cargarPantallaArbol() {
		pote.cargar(app);
		cargarChamp();
	}

	public void recogerChampinones() {
		for (int i = 0; i < champ.size(); i++) {
			if (PApplet.dist(app.mouseX, app.mouseY, champ.get(i).getX(), champ.get(i).getY()) < 30) {
				selectorChamp.anadir(champ.get(i));
			}
		}
	}
	// Nuevo
	public void cargarCalaverita() {
		for (int i = 0; i < calaveritas.size(); i++) {
			calaveritas.get(i).cargarCalaverita(app);
		}
	}

	public void cargarKuleshov() {
		kuleshov = new PImage[1];
		for (int i = 0; i < kuleshov.length; i++) {
			kuleshov[i] = app.loadImage("../data/kuleshov_prueba_" + i + ".png");
		}
	}

	public void cargarCajonAbrir() {
		abrir = new PImage[12];
		for (int i = 0; i < abrir.length; i++) {
			abrir[i] = app.loadImage("../data/CajonAbrir/CajonAbrir_" + i + ".png");
		}
	}

	public void cargarFondo() {
		revUnoF = new PImage[8];
		for (int i = 0; i < revUnoF.length; i++) {
			revUnoF[i] = app.loadImage("../data/Revision1/rev1_" + i + ".png");

		}
	}

	/*
	 * Metodo que cargara con un for las imagenes para la animacion del arbol de
	 * la pantalla principal, de inicio
	 */
	public void cargarCajonF() {
		cajonFlotante = new PImage[30];
		for (int i = 0; i < cajonFlotante.length; i++) {
			cajonFlotante[i] = app.loadImage("../data/CajonFlotando/CajonFlotando_" + i + ".png");

		}
	}

	public void cargarAbreCajon() {
		abreCajon = new PImage[14];
		for (int i = 0; i < abreCajon.length; i++) {
			abreCajon[i] = app.loadImage("../data/AbreCajon/AbreCajon_" + i + ".png");
		}
	}

	public void cargarAcercarCajon() {
		acercaCajon = new PImage[17];
		System.out.println(app);
		for (int i = 0; i < acercaCajon.length; i++) {
			acercaCajon[i] = app.loadImage("../data/CajonAcercar/CajonAcercar_" + i + ".png");
		}
	}

	/*
	 * Metodo que cargara con un for las imagenes para la animacion del arbol de
	 * la pantalla de activación de la aplicación
	 */
	public void cargarMoverCajon() {

	}

	/*
	 * metodo para visualizar la aplicación
	 */
	public void pintar(PApplet app) {
		pantallas(app);
	}

	public void pantallas(PApplet app) {
		switch (pantalla) {

		// --------Pantalla Mesa Flotanto----------//
		case 0:
			pintarCajonFlotante(app);
			break;

		//
		case 1:
			pintarAcercarCajon();
			break;
		case 2:

			switch (cajon) {
			case 0:
				pintarAbrir();
				break;
			case 1:
				pintarAbrirCajon();
				if (numFrameAC >= 12) {
					liss.pintar(app);
					lib.pintar(app);
					champPrin.pintar(app);
				}
				break;
			}

			break;
		// ------------------PANTALLA CALAVERITAS REV. UNO -------------------//
		case 3:
			switch (revUno) {
			case 0:
				pintarFondo();
				app.noStroke();
				app.fill(221, 40, 47);
				app.ellipse(eX, eY, 50, 50);
				pintarCalaveritas();
				avanzar(app);

				break;

			case 1:
				if (numFramePuerta >= 20) {
					pantalla = 4;
				}
				break;
			}

			break;

		// -----------------PANTALLA CHAMP. REV DOS----------------------//
		case 4:
			for (int i = 0; i < champ.size(); i++) {
				champ.get(i).pintar(app);
			}
			pote.pintar(app);
			selectorChamp.pintar(app);
			recogerChampinones();
			selectorChamp.remover();
			break;
		// -----------------------PANTALLA KULESHOV ------------------//
		case 5:
			app.image(kuleshov[0], app.width / 2, app.height / 2);
			break;
		// ------------------PANTALLA FOTOS. REV TRES ------------------//
		case 6:
			fotos.pintarImagen(app);
			break;

		// --------------PANTALLA CAJON-LLAVE. REV CUATRO -----------------//
		case 7:
			break;

		case 8:
			break;
		}

	}

	public void pintarCalaveritas() {
		for (int i = 0; i < calaveritas.size(); i++) {
			calaveritas.get(i).pintar(app);
		}
	}

	public void avanzar(PApplet app) {
		if (PApplet.dist(eX, eY, app.mouseX, app.mouseY) < 25 && tam < 2000) {
			tam += 20;
		} else if (tam >= 2000) {
			tam = 2000;
			revUno = 1;
		}

	}

	// -------------ANIMACIONES-------------//

	/*
	 * Metodo que pintara la animacion del cajon flotando
	 */
	public void pintarCajonFlotante(PApplet app) {
		app.image(cajonFlotante[numFrame], app.width / 2, app.height / 2);
		if (app.frameCount % 5 == 0) {
			numFrame++;
			if (numFrame >= 28) {
				numFrame = 0;
			}
		}
	}

	/*
	 * Metodo que pintara la animacion de cuando el usuario abre el cajon
	 */
	public void pintarAcercarCajon() {
		app.image(acercaCajon[numFrame], app.width / 2, app.height / 2);
		if (app.frameCount % 5 == 0 && numFrame != 16) {
			if (numFrame <= 16) {
				numFrame++;
			}
		} else if (numFrame >= 16) {
			numFrame = 16;
		}

	}

	public void pintarAbrir() {
		app.image(abrir[numFrameAbrir], app.width / 2, app.height / 2);
		if (app.frameCount % 5 == 0 && numFrameAbrir != 11) {
			if (numFrameAbrir <= 11) {
				numFrameAbrir++;
			}
		} else if (numFrameAbrir >= 11) {
			numFrameAbrir = 11;
		}
	}

	public void pintarFondo() {

		app.image(revUnoF[numFrame], app.width / 2, app.height / 2, revUnoF[numFrame].width / 2 + 100 + tam,
				revUnoF[numFrame].height / 2 + tam);
		if (app.frameCount % 1 == 0) {
			numFrame++;
			if (numFrame >= 7) {
				numFrame = 0;
			}
		}
	}

	/*
	 * Metodo que pintara la animacion de cuando el usuario abre el cajon
	 */
	public void pintarAbrirCajon() {
		app.image(abreCajon[numFrameAC], app.width / 2, app.height / 2);
		if (app.frameCount % 5 == 0 && numFrameAC != 13) {
			if (numFrameAC <= 13) {
				numFrameAC++;
			}
		} else if (numFrameAC >= 13) {
			numFrameAC = 13;
		}
	}

	/*
	 * Metodo que movera el cajon cada vez que pase alguien al frente de la
	 * instalación
	 */
	public void moverCajon() {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	// -----------------------MAKEY MAKEY----------------------//

	public void makey(PApplet app) {
		System.out.println(tam);
		if (pantalla == 0) {
			iniciarApp(app);
		} else if (pantalla == 1) {
			if (app.keyCode == 32) {
				pantalla = 2;
			}
		}

		else if (pantalla == 2) {

			if (app.keyCode == 87) {
				cajon = 1;
			} else if (app.keyCode == 32 && cajon == 1) {
				cargarCalaverita();
				agregarCalaveritas();
				pantalla = 3;
				numFrame = 0;
			}
		}

		else if (pantalla == 3) {

			if (app.keyCode == 32 && revUno == 1) {
				pantalla = 4;
			}
		}

		else if (pantalla == 4) {
			pote.mover();

			if (app.keyCode == 32) {
				pantalla = 5;
			}
		} else if (pantalla == 5) {

			if (app.keyCode == 32) {
				pantalla = 6;
			}
		} else if (pantalla == 6) {

			if (app.keyCode == 32) {
				pantalla = 7;
			}
		} else if (pantalla == 7) {

			if (app.keyCode == 32) {
				pantalla = 8;
			}
		}
	}

	public void agregarCalaveritas() {
		calaveritas.add(new Calaverita(this, 200, 300));
	}

	public void abrircajon() {

	}
	public void click(){
		fotos.click(app);
	}
	/*
	 * Metodo para cuando alguien toque el cajon, se cambie de pantalla y
	 * empiece la interaccion
	 */
	public void iniciarApp(PApplet app) {
		if (app.keyCode == 87) {
			pantalla = 1;
			numFrame = 0;
		}
	}

	//GETTERS Y SETTERS
	public SelectorChamp getSelectorChamp() {
		return selectorChamp;
	}

	public void setSelectorChamp(SelectorChamp selectorChamp) {
		this.selectorChamp = selectorChamp;
	}

	public Pote getPote() {
		return pote;
	}

	public void setPote(Pote pote) {
		this.pote = pote;
	}
	
	//-------------FINAL DE LA CLASE MUNDO

}
