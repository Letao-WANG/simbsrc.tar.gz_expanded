package ProjetCPOA;

import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

import simbad.sim.Agent;
import simbad.sim.CameraSensor;
import simbad.sim.CherryAgent;
import simbad.sim.RangeSensorBelt;
import simbad.sim.RobotFactory;
import simbad.sim.SimpleAgent;

public class Robot extends Agent {

	RangeSensorBelt sonars;
	CameraSensor camera;
	BufferedImage cameraImage;
	Controle controle;

	public Robot(Vector3d position, String name, Controle controle) {
		super(position, name);
		// Add camera
		camera = RobotFactory.addCameraSensor(this);
		cameraImage = camera.createCompatibleImage();
		// Add sonars
		sonars = RobotFactory.addSonarBeltSensor(this);
		this.controle = controle;
	}

	/** This method is called by the simulator engine on reset. */
	public void initBehavior() {
		// nothing particular in this case
	}

	/**
	 * This method is call cyclically (20 times per second) by the simulator engine.
	 */
	public void performBehavior() {

		// progress at 0.5 m/s
		setTranslationalVelocity(2);
		if (anOtherAgentIsVeryNear()) {
			SimpleAgent agent = getVeryNearAgent();
			Color3f color = new Color3f(0.8f, 0, 0);

			/*if (agent instanceof RobotCherry) {
				agent.detach();
				controle.disposeMain();
				System.out.println("ttttttttttttt");
			}*/

			if (agent instanceof RobotHostile) {
				agent.detach();
				controle.disposeMain();
				controle.ShowMessage();

			}
		}
		
		/*if (anOtherAgentIsVeryNear()) {
			SimpleAgent agent = getVeryNearAgent();

			if (agent instanceof CherryAgent) {
				agent.detach();
				System.out.println("cerise cueillie !");
				// ((CherryAgent) agent).setColor(new Color3f(0.9f,0.7f,0.1f));
			}
		}*/

	}

	public BufferedImage getImage() {
		return this.cameraImage;
	}

}