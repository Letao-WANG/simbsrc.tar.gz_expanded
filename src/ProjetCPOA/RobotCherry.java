package ProjetCPOA;

import javax.vecmath.Vector3d;

import simbad.sim.Agent;
import simbad.sim.Plan;
import simbad.sim.RangeSensorBelt;
import simbad.sim.RobotFactory;
import simbad.sim.SimpleAgent;

public class RobotCherry extends Agent {

	Controle controle;
	
	public RobotCherry(Vector3d position, String name, Controle controle) {
		super(position, name);
		this.controle = controle;
	}

	public void initBehavior() {
		// plan.reset();
	}

	public void performBehavior() {
		SimpleAgent agent = getVeryNearAgent();
		if (agent instanceof Robot) {
			this.detach();
			controle.disposeMain();
			controle.ShowSuccessMessage();
		}
	}
}