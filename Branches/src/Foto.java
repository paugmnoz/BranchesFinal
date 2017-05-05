import processing.core.PApplet;
import processing.core.PImage;

public class Foto implements Runnable {

	private PApplet app;
	private Llave llave;
	private boolean encontroLlave;
	private float x, y, tam;
	private Mundo m;
	private PImage fondo, fotoUno, fotoDos, fotoTres, fotoCuatro, fotoCinco, fotoSeis, fotoSiete, fotoOcho;
	
	public Foto(Mundo m, float x, float y, float tam){
		encontroLlave = false;
		this.x = x;
		this.y = y;
		this.tam = tam;
		this.m = m;
		llave = new Llave(m, 802, 547, 30);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void cargarImagen(PApplet app){
		this.app = app;
		fondo = app.loadImage("../data/PantallaFotos/fondo.png");
		fotoUno = app.loadImage("../data/PantallaFotos/fotoUno.png");
		fotoDos = app.loadImage("../data/PantallaFotos/fotoDos.png");
		fotoTres = app.loadImage("../data/PantallaFotos/fotoTres.png");
		fotoCuatro = app.loadImage("../data/PantallaFotos/fotoCuatro.png");
		fotoCinco = app.loadImage("../data/PantallaFotos/fotoCinco.png");
		fotoSeis = app.loadImage("../data/PantallaFotos/fotoSeis.png");
		fotoSiete = app.loadImage("../data/PantallaFotos/fotoSiete.png");
		fotoOcho = app.loadImage("../data/PantallaFotos/fotoOcho.png");
		llave.cargar(app);
	}
	

	public void pintarImagen(PApplet app){
		this.app = app;
		app.image(fondo, app.width/2, app.height/2);
		app.image(fotoUno, app.width/2, app.height/2);
		llave.pintar(app);
		app.image(fotoDos, app.width/2, app.height/2);
		app.image(fotoTres, app.width/2, app.height/2);
		if(!encontroLlave){
		app.image(fotoCuatro, app.width/2, app.height/2);
		}
		app.image(fotoCinco, app.width/2, app.height/2);
		app.image(fotoSeis, app.width/2, app.height/2);
		app.image(fotoSiete, app.width/2, app.height/2);
		app.image(fotoOcho, app.width/2, app.height/2);
	}
	
	public void click(PApplet app){
		this.app = app;
		if(PApplet.dist(app.mouseX, app.mouseY, 802, 547)<50){
			encontroLlave = true;
		}
	}
	

	public void animacionFotos(){
		
	}
	
	public boolean zonaUno(){
		return true;
	}
	
	public boolean zonaDos(){
		return true;
	}
	
	public boolean zonaTres(){
		return true;
	}
	
	public boolean zonaCuatro(){
		return true;
	}
	
	public boolean zonaCinco(){
		return true;
	}
	
	public boolean zonaSeisObjetivo(){
		return true;
	}
	
	public boolean zonaSiete(){
		return true;
	}
	
	public boolean zonaOcho(){
		return true;
	}
	
	public boolean zonaNueve(){
		return true;
	}
	
}


