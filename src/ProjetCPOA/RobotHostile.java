package ProjetCPOA;

import javax.vecmath.Vector3d;

import simbad.sim.Agent;
import simbad.sim.Plan;
import simbad.sim.RangeSensorBelt;
import simbad.sim.RobotFactory;

public class RobotHostile extends Agent {

	RangeSensorBelt sonars;

	public RobotHostile(Vector3d position, String name) {
		super(position, name);
		sonars = RobotFactory.addSonarBeltSensor(this, 8);
	}

	public void initBehavior() {
		// plan.reset();
		//setTranslationalVelocity(0.5);
	}

	public void performBehavior() {
		// progress at 0.5 m/s
		setTranslationalVelocity(0.4);
		
		/*if ( sonars.getFrontQuadrantMeasurement() < 0.5 )
			setTranslationalVelocity(-0.5);
		else if ( sonars.getBackQuadrantMeasurement() < 0.5 )
			setTranslationalVelocity(0.5);*/
		
		double left = sonars.getFrontLeftQuadrantMeasurement();
		double right = sonars.getFrontRightQuadrantMeasurement();
		double front = sonars.getFrontQuadrantMeasurement();
		//if ((front > 0.5) || (left > 0.5) || (right > 0.5)) {
		if ((front < 1) || (left < 1) || (right < 1)) {
			if (left < right)
				setRotationalVelocity(-5);
			else
				setRotationalVelocity(5);
		}
		//setTranslationalVelocity(-0.5);

		// changer l'angle fréquemment
		//if ((getCounter() % 20) == 0)
			//setRotationalVelocity(Math.PI / 2 * (0.5 - Math.random()));

		/*if ((getCounter() % 10) == 0) {
			if (sonars.oneHasHit()) {
				double left = sonars.getFrontLeftQuadrantMeasurement();
				double right = sonars.getFrontRightQuadrantMeasurement();
				double front = sonars.getFrontQuadrantMeasurement();
				if ((front > 0.5) || (left > 0.5) || (right > 0.5)) {
					if (left < right)
						setRotationalVelocity(-5);
					else
						setRotationalVelocity(5);
				}
				setTranslationalVelocity(-0.5);
			

		}
		else if ((getCounter() % 10) == 1)
			setTranslationalVelocity(0.5);*/
		
	}
}