import processing.core.PApplet;
import processing.core.PImage;

public class Instru extends Thread {
	private PApplet app;
	private Mundo m;
	private PImage[] insUno, insDos, insTres, insCuatro;
	public boolean uno;
	private int ins;

	public Instru(PApplet app, Mundo m) {
		this.app = app;
		this.m = m;
		// cargar();
		iniciarVariables();
	}

	public void iniciarVariables() {
		uno = false;
	}

	public void cargar() {
	//	insUno = m.getCargarDos().getInsUno();
		//insDos = m.getCargarDos().getInsDos();
	//	insTres = m.getCargarDos().getInsTres();
		//insCuatro = m.getCargarDos().getInsCuatro();
	}

	public void validarIns() {
		if (m.getPantalla() == 4) {
			uno = true;
		}
	}

	@Override
	public void run() {
		while (uno) {
			try {
				calculoUno();
				sleep(33);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void calculoUno() {
		if (app.frameCount % 3 == 0 && ins < 111) {
			ins++;
			if (ins >= 111) {
				ins = 111;
				m.setRevUno(1);
			}
		} // TODO Auto-generated method stub

	}

	public void calculo() {
		// System.out.println("Pantalla: " + m.getPantalla());
		switch (m.getPantalla()) {
		case 4:
			switch (m.getRevUno()) {
			case 0:
				calculoInsUno();
				break;
			}
			break;
		case 2:
			break;
		case 3:

			break;
		}

	}

	public void calculoInsUno() {
		// TODO Auto-generated method stub

	}

	public int getIns() {
		return ins;
	}
}
