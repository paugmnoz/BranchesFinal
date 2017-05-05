import processing.core.PApplet;
import processing.core.PImage;

public class Arbol {

	private PApplet app;
	private PImage [] arbol;
	private int numFrame;
	private Mundo m;
	
	public Arbol(Mundo m){
		this.m = m;
	}
	
	public void cargar(PApplet app){
		this.app = app;
		arbol = new PImage[297];
		for (int i = 0; i < arbol.length; i++) {
			arbol[i] = app.loadImage("../data/PantallaArbol/Arbol/arbolCorte_" + i +".png");
		}
	}
	
	public void calculo(){
		if(numFrame>=arbol.length){
			numFrame++;
		}
	}
	
	public void pintar(PApplet app){
		this.app = app;
		app.image(arbol[numFrame], app.width / 2, app.height / 2);
	}
	
}
