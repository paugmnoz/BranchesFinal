import java.util.ArrayList;

import processing.core.PApplet;

public class SelectorChamp {

	private Mundo m;
	private float x, y, tam;
	private ArrayList<Champinon> champinones;

	public SelectorChamp(Mundo m, float x, float y, float tam) {
		this.m = m;
		this.tam = tam;
		champinones = new ArrayList<Champinon>();
	}

	public void pintar(PApplet app) {
		x = app.mouseX;
		y = app.mouseY;
		app.noFill();
		app.stroke(255);
		app.strokeWeight(2);
		app.ellipse(x, y, tam, tam);
		// if (!champinones.isEmpty()) {
		for (int i = 0; i < champinones.size(); i++) {
			champinones.get(i).pintar(app, x, y);
		}
		// }
	}

	public boolean validar(int cx, int cy) {
		return PApplet.dist(cx, cy, x, y) < tam / 2;
	}

	public void anadir(Champinon champ) {
		champinones.add(champ);
	}
	
	public void remover(){
		for (int i = 0; i < champinones.size(); i++) {
		if(PApplet.dist(m.getPote().getX(), m.getPote().getY(), x, y) < 150){
				champinones.remove(i);
			}
		}
	}

	// FINAL DE LA CLASE
}
