import processing.core.PApplet;

public class BranchesMain extends PApplet {
	
	private Mundo m;
	private PApplet app;
	
	
	//Hola mundo
	public static void main(String[] args) {
		PApplet.main("BranchesMain");
	}
	
	@Override
	public void settings() {
		fullScreen();
		
	}
	
	@Override
	public void setup() {
		m = new Mundo(this);
		imageMode(CENTER);

	}
	
	@Override
	public void draw() {
		background(52, 8, 70);
		m.pintar(this);
	}
	@Override
	public void keyReleased() {
		m.makey(this);
	}
	
	@Override
	public void mouseClicked() {
		println(mouseX, mouseY);
	}
	
	public void mouseReleased(){
		println(mouseX, mouseY);
		m.click();
	}
	
}
