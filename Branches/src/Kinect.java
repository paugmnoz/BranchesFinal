import SimpleOpenNI.SimpleOpenNI;
import processing.core.PVector;

public class Kinect {

	private PVector[] pos;

	public void onNewUser(SimpleOpenNI curContext, int userId) {
		System.out.println("onNewUser - userId: " + userId);
		System.out.println("\tstart tracking skeleton");

		curContext.startTrackingSkeleton(userId);
	}

	public void trackingManos(){
		
	}
	
	public void onLostUser(SimpleOpenNI curContext, int userId) {
		System.out.println("onLostUser - userId: " + userId);
	}

	public PVector[] getPos() {
		return pos;
	}

	public void setPos(PVector[] pos) {
		this.pos = pos;
	}

	// FINAL DE LA CLASE KINECT
}
