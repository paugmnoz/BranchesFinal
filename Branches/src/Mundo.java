import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class Mundo {

	// PARA CARGAR
	private Cargar cargar;
	private CargarDos cargarDos;

	private Instru instru;
	private boolean contexto;
	// ---------

	private int pantalla, numFrame, numFrameA, numFrameAbrir, numFrameAC, numFramePuerta, numCargando;
	private int cajon, revUno, revDos,revTres, revCuatro, posX, posY;

	private Libreta lib;
	private ChampinonPrin champPrin;

	private Cajon cajonClase;
	private PImage[] cargando, cajonFinal;
	private PImage  insUno, insDos, insTres, insCuatro;
	private Foto fotos;
	private Pote pote;
	private SelectorChamp selectorChamp;
	private ArrayList<Champinon> champ;
	private int contarChamps, numk, ins;
	private ArrayList<Calaverita> calaveritas;

	// para pre entrega
	int eX = 964, eY = 297;

	private PApplet app;

	private PImage[] cajonFlotante, abreCajon, acercaCajon, revUnoF, abrir, kuleshov, finalito;

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

		cargarDos = new CargarDos(app);
		cargarDos.start();

		instru = new Instru(app, this);
		instru.start();
	}

	public void inicializarVariables() {

		fotos = new Foto(this, 0, 0, 30, app);
		fotos.start();
		pote = new Pote(this);
		champ = new ArrayList<Champinon>();
		selectorChamp = new SelectorChamp(this, app.mouseX, app.mouseY, 150);
		lib = new Libreta();
		cajonClase = new Cajon(app, this);
		cajonClase.start();
		champPrin = new ChampinonPrin(app, app.width / 2 + 400, app.height / 2 - 50);
		calaveritas = new ArrayList<Calaverita>();
		numFrame = 0;
		pantalla = 0;

		posX = app.width / 2;
		posY = app.height / 2;
		contexto = false;
	}

	public void cargarImagenes() {
		cargarFondo();
		cargarKuleshov();
		cajonFinal = cargar.getAbrir();
		cargarFinal();
		cargarInstrucciones();

	}

	public void cargarInstrucciones() {
		insUno = getCargarDos().getInsUno();
		insDos = getCargarDos().getInsDos();
		insTres = getCargarDos().getInsTres();
		insCuatro = getCargarDos().getInsCuatro();
	}

	public void cargarFinal() {
		finalito = cargarDos.getFinalito();
	}

	public void anadirChampinones() {
		for (int i = 0; i < 250; i++) {
			champ.add(new Champinon(this, (float) Math.random() * app.width,
					(float) ((app.height / 2 + 200) + Math.random() * app.height)));
			System.out.println("aaaaaaaaa");
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
		revUnoF = cargar.getFondoUno();
	}

	/*
	 * metodo para visualizar la aplicación
	 */
	public void pintar(PApplet app) {
		pantallas(app);
		// System.out.println("Estado Hilo Cajón: " + cajonClase.getState());
	}

	public void pantallas(PApplet app) {
		System.out.println(revUno);
		instru.validarIns();
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
			cajonClase.setVivo(false);

			switch (revUno) {
			case 0:
				app.image(insUno, posX, posY);
				if (app.frameCount % 450 == 0) {
					revUno = 1;
				}
				break;

			case 1:

				pintarFondo();
				app.noStroke();
				app.fill(221, 40, 47);
				app.ellipse(eX, eY, 50, 50);
				pintarCalaveritas();
				avanzar(app);

				break;
			}

			break;

		// -----------------PANTALLA CHAMP. REV DOS----------------------//
		case 5:
			switch (revDos) {
			case 0:
				app.image(insDos, posX, posY);
				if (app.frameCount % 450 == 0) {
					revDos = 1;
				}
				break;

			case 1:
				for (int i = 0; i < champ.size(); i++) {
					champ.get(i).pintar(app);
				}
				pote.pintar(app);
				selectorChamp.pintar(app);
				recogerChampinones();
				selectorChamp.remover();
				break;

			}
			break;
		// -----------------------PANTALLA KULESHOV ------------------//
		case 6:
			app.image(kuleshov[numk], app.width / 2, app.height / 2);
			if (app.frameCount % 3 == 0 && numk < kuleshov.length) {
				numk++;
				if (numk >= kuleshov.length) {
					numk = 71;
					pantalla = 7;
				}
			}
			break;
		// ------------------PANTALLA FOTOS. REV TRES ------------------//
		case 7:
			switch (revTres) {
			case 0:
				app.image(insTres, posX, posY);
				if (app.frameCount % 450 == 0) {
					revTres = 1;
				}
				break;

			case 1:
				fotos.pintarImagen(app);
				break;
			}
			break;

		// --------------PANTALLA CAJON-LLAVE. REV CUATRO -----------------//
		case 8:
			switch (revCuatro) {
			case 0:
				app.image(insCuatro, posX, posY);
				if (app.frameCount % 450 == 0) {
					revCuatro = 1;
				}
				break;
			case 1:
				app.image(cajonFinal[3], app.width / 2, app.height / 2);
				break;

			}
			break;

		case 9:
			app.image(finalito[numk], app.width / 2, app.height / 2);
			if (app.frameCount % 3 == 0 && numk < finalito.length) {
				numk++;
				if (numk >= finalito.length) {
					numk = 187;
				}
			}
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
		if (PApplet.dist(eX, eY, app.mouseX, app.mouseY) < 25) {
			if (app.frameCount % 3 == 0) {
				numFrame++;
			}
			if (numFrame >= 144) {
				numFrame = 144;
				pantalla = 5;
			}
		}

	}

	// ---------- REV UNO CALAVERITAS ---------//
	public void pintarFondo() {
		app.image(revUnoF[numFrame], app.width / 2, app.height / 2);
		/*
		 * if (app.frameCount % 3 == 0) { numFrame++; if (numFrame >= 143) {
		 * numFrame = 0; } }
		 */
	}

	// -----------------------MAKEY MAKEY----------------------//

	public void makey(PApplet app) {
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
				ins = 0;
				pantalla = 4;
				numFrame = 0;
				contexto = true;
			}
		}
		// ------------------ PANTALLA CALAVERITAS -----------------//
		else if (pantalla == 4) {
			ins = 0;
			if (app.keyCode == 32) {
				anadirChampinones();
				pantalla = 5;
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
			ins = 0;
			if (app.keyCode == 32) {
				pantalla = 7;
			}
			// ------------------PANTALLA FOTOS. REV TRES ------------------//
		} else if (pantalla == 7) {
			if (app.keyCode == 32) {
				pantalla = 8;
			}
			// --------------PANTALLA CAJON-LLAVE. REV CUATRO
			// -----------------//
		} else if (pantalla == 8) {

			if (app.keyCode == 32) {
				pantalla = 9;
				numk = 0;
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

	public CargarDos getCargarDos() {
		return cargarDos;
	}

	public int getRevCuatro() {
		return revCuatro;
	}

	public int getRevUno() {
		return revUno;
	}

	public void setRevUno(int revUno) {
		this.revUno = revUno;
	}
	// -------------FINAL DE LA CLASE MUNDO--------------//

}
