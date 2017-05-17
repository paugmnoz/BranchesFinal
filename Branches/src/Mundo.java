import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Mundo {

	private boolean moverC, abrirC, champinonPrin, libreta, lis;
	private int pantalla, numFrame, numFrameA, numFrameAbrir, numFrameAC, numFramePuerta, numCargando;
	private int cajon, revUno;
	private float tam;
	private Libreta lib;
	private Lis liss;
	private ChampinonPrin champPrin;
	private Cargar cargar;
	private Cajon cajonClase;
	private PImage[] cargando;
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
		cargarPantallaDeCarga();
		iniciarHilo();
	}

	public void cargarPantallaDeCarga() {
		cargando = new PImage[52];
		for (int i = 0; i < cargando.length; i++) {
			cargando[i] = app.loadImage("../data/cargando/cargando_" + i + ".png");
		}
	}

	public void iniciarHilo() {
		cargar = new Cargar(app);
		cargar.start();
	}

	public void inicializarVariables() {
		lis = false;
		libreta = false;
		champinonPrin = false;
		fotos = new Foto(this, 0, 0, 30);
		pote = new Pote(this);
		champ = new ArrayList<Champinon>();
		selectorChamp = new SelectorChamp(this, app.mouseX, app.mouseY, 150);
		liss = new Lis();
		lib = new Libreta();
		cajonClase = new Cajon(app, this);
		cajonClase.start();
		champPrin = new ChampinonPrin(app, app.width / 2 + 400, app.height / 2 - 50);
		calaveritas = new ArrayList<Calaverita>();
		numFrame = 0;
		pantalla = 0;
	}

	public void cargarImagenes() {
		cargarFondo();
		cargarKuleshov();
	}

	public void anadirChampinones() {
		for (int i = 0; i < 500; i++) {
			champ.add(new Champinon(this, (float) Math.random() * app.width,
					(float) ((app.height / 2 + 200) + Math.random() * app.height)));
		}
	}

	public void recogerChampinones() {
		for (int i = 0; i < champ.size(); i++) {
			if (PApplet.dist(app.mouseX, app.mouseY, champ.get(i).getX(), champ.get(i).getY()) < 30) {
				selectorChamp.anadir(champ.get(i));
			}
		}
	}

	public void cargarKuleshov() {
		kuleshov = cargar.getKuleshov();
	}

	public void cargarFondo() {
		revUnoF = cargar.getRevUnoF();
	}

	/*
	 * metodo para visualizar la aplicación
	 */
	public void pintar(PApplet app) {
		pantallas(app);
		// System.out.println("Estado Hilo Cajón: " + cajonClase.getState());
	}

	public void pantallas(PApplet app) {
		switch (pantalla) {
		// ------------PANTALLA DE CARGA---------//
		case 0:
			app.background(52, 8, 70);
			pintarPantallaDeCarga();
			if (cargar.getState() == Thread.State.TERMINATED) {
				inicializarVariables();
				cargarImagenes();
				pantalla = 1;
			}
			break;
		// --------PANTALLA MESA FLOTANDO----------//
		case 1:
			cajonClase.pintarCajonFlotante();
			break;
		//
		case 2:
			cajonClase.pintarAcercarCajon();
			break;
		case 3:

			switch (cajon) {
			case 0:
				cajonClase.pintarAbrir();
				break;
			case 1:
				cajonClase.pintarAbrirCajon();
				if (numFrameAC >= 12) {
					// liss.pintar(app);
					// lib.pintar(app);
					// champPrin.pintar(app);
				}
				break;
			}

			break;
		// ------------------PANTALLA CALAVERITAS REV. UNO -------------------//
		case 4:
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
		case 5:
			for (int i = 0; i < champ.size(); i++) {
				champ.get(i).pintar(app);
			}
			pote.pintar(app);
			selectorChamp.pintar(app);
			recogerChampinones();
			selectorChamp.remover();
			break;
		// -----------------------PANTALLA KULESHOV ------------------//
		case 6:
			app.image(kuleshov[0], app.width / 2, app.height / 2);
			break;
		// ------------------PANTALLA FOTOS. REV TRES ------------------//
		case 7:
			fotos.pintarImagen(app);
			break;

		// --------------PANTALLA CAJON-LLAVE. REV CUATRO -----------------//
		case 8:
			break;

		case 9:
			break;
		}

	}

	// ----------------ANIMACIONES---------------//
	public void pintarPantallaDeCarga() {
		if (app.frameCount % 3 == 0 && numCargando < cargando.length) {
			numCargando++;
			if (numCargando >= cargando.length) {
				numCargando = 0;
			}
		}
		app.image(cargando[numCargando], app.width / 2, app.height / 2, cargando[numCargando].width / 2,
				cargando[numCargando].height / 2);
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

	// -----------------------MAKEY MAKEY----------------------//

	public void makey(PApplet app) {
		System.out.println(tam);
		// ------------PANTALLA DE CARGA---------//
		if (pantalla == 0) {
			//
			// --------PANTALLA MESA FLOTANDO----------//
		} else if (pantalla == 1) {
			iniciarApp(app);
		} else if (pantalla == 2) {
			if (app.keyCode == 32) {
				pantalla = 3;
			}
		}

		else if (pantalla == 3) {

			if (app.keyCode == 87) {
				cajon = 1;
			} else if (app.keyCode == 32 && cajon == 1) {
				agregarCalaveritas();
				pantalla = 4;
				numFrame = 0;
			}
		}

		else if (pantalla == 4) {

			if (app.keyCode == 32 && revUno == 1) {
				pantalla = 5;
				anadirChampinones();
			}
		}

		// -----------------PANTALLA CHAMP. REV DOS----------------------//
		else if (pantalla == 5) {
			pote.mover();

			if (app.keyCode == 32) {
				pantalla = 6;
			}
		// -----------------------PANTALLA KULESHOV ------------------//
		} else if (pantalla == 6) {

			if (app.keyCode == 32) {
				pantalla = 7;
			}
		// ------------------PANTALLA FOTOS. REV TRES ------------------//
		} else if (pantalla == 7) {

			if (app.keyCode == 32) {
				pantalla = 8;
			}
		// --------------PANTALLA CAJON-LLAVE. REV CUATRO -----------------//
		} else if (pantalla == 8) {

			if (app.keyCode == 32) {
				pantalla = 9;
			}
		}
	}

	public void agregarCalaveritas() {
		calaveritas.add(new Calaverita(this, 200, 300));
	}

	public void click() {
		fotos.click(app);
	}

	/*
	 * Metodo para cuando alguien toque el cajon, se cambie de pantalla y
	 * empiece la interaccion
	 */
	public void iniciarApp(PApplet app) {
		if (app.keyCode == 87) {
			pantalla = 2;
			numFrame = 0;
		}
	}

	// GETTERS Y SETTERS
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

	public Cargar getCargar() {
		return cargar;
	}

	public void setCargar(Cargar cargar) {
		this.cargar = cargar;
	}

	public int getPantalla() {
		return pantalla;
	}

	public void setPantalla(int pantalla) {
		this.pantalla = pantalla;
	}

	public int getCajon() {
		return cajon;
	}

	public void setCajon(int cajon) {
		this.cajon = cajon;
	}

	// -------------FINAL DE LA CLASE MUNDO--------------//

}
