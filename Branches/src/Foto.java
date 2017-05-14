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
		//llave = new Llave(m, 802, 547, 30);
		cargarImagen();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void cargarImagen(){
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
	

	public void pintarImagen(PApplet app){
		this.app = app;
		app.image(fondo, app.width/2, app.height/2);
		app.image(fotoUno, app.width/2, app.height/2);
		//llave.pintar(app);
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


