import processing.core.PApplet;
import processing.core.PImage;

public class Cargar extends Thread {

	private PApplet app;
	private PImage cargarCalaverita;
	private PImage[] kuleshov;
	private PImage[] abrir, revUnoF, cajonFlotante, abreCajon, acercaCajon;
	private PImage champUno, champDos, pote, poteAtras, poteAdelante;
	private int champ;
	private boolean cargado;
	// Pantalla Fotos
	private PImage[] fotoUno, fotoDos, fotoTres, fotoCuatro, fotoCinco, fotoSeis, fotoSiete, fotoOcho;
	private PImage fondo, llave;

	public Cargar(PApplet app) {
		this.app = app;
		cargado = false;
	}

	public void run() {
		try {
			sleep(15);
			cargarKuleshov();
			cargarCajonAbrir();
			cargarFondo();
			cargarCajonF();
			cargarAbreCajon();
			cargarAcercarCajon();
			cargarChampinones();
			cargarPote();
			cargarFotos();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// -------PANTALLA CAJÓN FLOTANDO---------//
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

	public void cargarCajonF() {
		cajonFlotante = new PImage[30];
		for (int i = 0; i < cajonFlotante.length; i++)
			cajonFlotante[i] = app.loadImage("../data/CajonFlotando/CajonFlotando_" + i + ".png");
	}

	public void cargarAbreCajon() {
		abreCajon = new PImage[14];
		for (int i = 0; i < abreCajon.length; i++) {
			abreCajon[i] = app.loadImage("../data/AbreCajon/AbreCajon_" + i + ".png");
		}
	}

	public void cargarAcercarCajon() {
		acercaCajon = new PImage[17];
		for (int i = 0; i < acercaCajon.length; i++) {
			acercaCajon[i] = app.loadImage("../data/CajonAcercar/CajonAcercar_" + i + ".png");
		}
	}

	// -----------------PANTALLA CHAMP. REV DOS----------------------//
	public void cargarChampinones() {
		champUno = app.loadImage("../data/PantallaArbol/champUno.png");
		champDos = app.loadImage("../data/PantallaArbol/champDos.png");
	}

	public void cargarPote() {
		pote = app.loadImage("../data/PantallaArbol/pote.png");
		poteAtras = app.loadImage("../data/PantallaArbol/poteAtras.png");
		poteAdelante = app.loadImage("../data/PantallaArbol/poteAdelante.png");
	}

	// -----------------------PANTALLA KULESHOV ------------------//
	public void cargarKuleshov() {
		kuleshov = new PImage[1];
		for (int i = 0; i < kuleshov.length; i++) {
			kuleshov[i] = app.loadImage("../data/kuleshov_prueba_" + i + ".png");
		}
	}

	// -----------------PANTALLA FOTOS------------//
	public void cargarFotos() {
		fondo = app.loadImage("../data/PantallaFotos/fondo.png");
		
		// FOTO UNO
		fotoUno = new PImage[6];
		for (int i = 0; i < fotoUno.length; i++) {
			fotoUno[i] = app.loadImage("../data/PantallaFotos/animacionesFotos/fotoUno/fotoUno_" + i + ".png");
		}
		// FOTO DOS
		fotoDos = new PImage[9];
		for (int i = 0; i < fotoDos.length; i++) {
			fotoDos[i] = app.loadImage("../data/PantallaFotos/animacionesFotos/fotoDos/fotoDos_" + i + ".png");
		}
		// FOTO TRES
		fotoTres = new PImage[5];
		for (int i = 0; i < fotoTres.length; i++) {
			fotoTres[i] = app.loadImage("../data/PantallaFotos/animacionesFotos/fotoTres/fotoTres_" + i + ".png");
		}
		// FOTO CUATRO
		fotoCuatro = new PImage[14];
		for (int i = 0; i < fotoCuatro.length; i++) {
			fotoCuatro[i] = app.loadImage("../data/PantallaFotos/animacionesFotos/fotoCuatro/fotoCuatro_" + i + ".png");
		}
		// FOTO CINCO
		fotoCinco = new PImage[6];
		for (int i = 0; i < fotoCinco.length; i++) {
			fotoCinco[i] = app.loadImage("../data/PantallaFotos/animacionesFotos/fotoCinco/fotoCinco_" + i + ".png");
		}
		// FOTO SEIS
		fotoSeis = new PImage[7];
		for (int i = 0; i < fotoSeis.length; i++) {
			fotoSeis[i] = app.loadImage("../data/PantallaFotos/animacionesFotos/fotoSeis/fotoSeis_" + i + ".png");
		}
		// FOTO SIETE
		fotoSiete = new PImage[8];
		for (int i = 0; i < fotoSiete.length; i++) {
			fotoSiete[i] = app.loadImage("../data/PantallaFotos/animacionesFotos/fotoSiete/fotoSiete_" + i + ".png");
		}
		// FOTO OCHO
		fotoOcho = new PImage[8];
		for (int i = 0; i < fotoOcho.length; i++) {
			fotoOcho[i] = app.loadImage("../data/PantallaFotos/animacionesFotos/fotoOcho/fotoOcho_" + i + ".png");
		}

		llave = app.loadImage("../data/PantallaFotos/llave.png");
		cargado = true;
	}

	// -------------GETTERS Y SETTERS------------//
	public PImage getCargarCalaverita() {
		return cargarCalaverita;
	}

	public void setCargarCalaverita(PImage cargarCalaverita) {
		this.cargarCalaverita = cargarCalaverita;
	}

	public PImage[] getKuleshov() {
		return kuleshov;
	}

	public void setKuleshov(PImage[] kuleshov) {
		this.kuleshov = kuleshov;
	}

	public PImage[] getAbrir() {
		return abrir;
	}

	public void setAbrir(PImage[] abrir) {
		this.abrir = abrir;
	}

	public PImage[] getRevUnoF() {
		return revUnoF;
	}

	public void setRevUnoF(PImage[] revUnoF) {
		this.revUnoF = revUnoF;
	}

	public PImage[] getCajonFlotante() {
		return cajonFlotante;
	}

	public void setCajonFlotante(PImage[] cajonFlotante) {
		this.cajonFlotante = cajonFlotante;
	}

	public PImage[] getAbreCajon() {
		return abreCajon;
	}

	public void setAbreCajon(PImage[] abreCajon) {
		this.abreCajon = abreCajon;
	}

	public PImage[] getAcercaCajon() {
		return acercaCajon;
	}

	public void setAcercaCajon(PImage[] acercaCajon) {
		this.acercaCajon = acercaCajon;
	}

	public PImage getChampUno() {
		return champUno;
	}

	public void setChampUno(PImage champUno) {
		this.champUno = champUno;
	}

	public PImage getChampDos() {
		return champDos;
	}

	public void setChampDos(PImage champDos) {
		this.champDos = champDos;
	}

	public int getChamp() {
		return champ;
	}

	public void setChamp(int champ) {
		this.champ = champ;
	}

	public PImage getFondo() {
		return fondo;
	}

	public void setFondo(PImage fondo) {
		this.fondo = fondo;
	}

	public PImage getLlave() {
		return llave;
	}

	public void setLlave(PImage llave) {
		this.llave = llave;
	}

	public PImage getPote() {
		return pote;
	}

	public void setPote(PImage pote) {
		this.pote = pote;
	}

	public boolean isCargado() {
		return cargado;
	}

	public void setCargado(boolean cargado) {
		this.cargado = cargado;
	}

	public PImage getPoteAtras() {
		return poteAtras;
	}

	public void setPoteAtras(PImage poteAtras) {
		this.poteAtras = poteAtras;
	}

	public PImage getPoteAdelante() {
		return poteAdelante;
	}

	public void setPoteAdelante(PImage poteAdelante) {
		this.poteAdelante = poteAdelante;
	}

	public PImage[] getFotoUno() {
		return fotoUno;
	}

	public void setFotoUno(PImage[] fotoUno) {
		this.fotoUno = fotoUno;
	}

	public PImage[] getFotoDos() {
		return fotoDos;
	}

	public void setFotoDos(PImage[] fotoDos) {
		this.fotoDos = fotoDos;
	}

	public PImage[] getFotoTres() {
		return fotoTres;
	}

	public void setFotoTres(PImage[] fotoTres) {
		this.fotoTres = fotoTres;
	}

	public PImage[] getFotoCuatro() {
		return fotoCuatro;
	}

	public void setFotoCuatro(PImage[] fotoCuatro) {
		this.fotoCuatro = fotoCuatro;
	}

	public PImage[] getFotoCinco() {
		return fotoCinco;
	}

	public void setFotoCinco(PImage[] fotoCinco) {
		this.fotoCinco = fotoCinco;
	}

	public PImage[] getFotoSeis() {
		return fotoSeis;
	}

	public void setFotoSeis(PImage[] fotoSeis) {
		this.fotoSeis = fotoSeis;
	}

	public PImage[] getFotoSiete() {
		return fotoSiete;
	}

	public void setFotoSiete(PImage[] fotoSiete) {
		this.fotoSiete = fotoSiete;
	}

	public PImage[] getFotoOcho() {
		return fotoOcho;
	}

	public void setFotoOcho(PImage[] fotoOcho) {
		this.fotoOcho = fotoOcho;
	}
	

	// --------------FINAL DE LA CLASE CARGAR------------//
}
