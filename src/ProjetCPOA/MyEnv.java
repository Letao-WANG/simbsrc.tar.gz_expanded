package ProjetCPOA;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import simbad.sim.Agent;
import simbad.sim.Arch;
import simbad.sim.BallAgent;
import simbad.sim.BaseObject;
import simbad.sim.BlockWorldObject;
import simbad.sim.Box;
import simbad.sim.CherryAgent;
import simbad.sim.EnvironmentDescription;
import simbad.sim.Wall;

public class MyEnv extends EnvironmentDescription {

	ArrayList<RobotHostile> alRobotHostile;

	public MyEnv(Robot robot, RobotCherry robotCherry) {

		// this.allEnv = new HashMap<>();
		// alRobotHostile = new ArrayList<RobotHostile>();
		/*
		 * Color3f c = new Color3f(0.6f, 0.5f, 0.3f); RobotHostile robotHostile = new
		 * RobotHostile(new Vector3d(5, 0, 5), "red"); robotHostile.setColor(new
		 * Color3f(0.9f,0.7f,0.1f)); add(robotHostile);
		 */

		//setUsePhysics(false);
		//CherryAgent ca = new CherryAgent(new Vector3d(8.5, 0, 7), "cherry", 0.15f);
		
		add(robotCherry);
		//ca.setColor(new Color3f(0.9f,0.7f,0.1f));
		//add(ca);
		// add(new Arch(new Vector3d(3, 0, -3), this));
		add(robot);
		/*
		 * Wall w1 = new Wall(new Vector3d(9, 0, 0), 18, 5, this); w1.rotate90(1);
		 * add(w1); Wall w2 = new Wall(new Vector3d(-9, 0, 0), 18, 5, this);
		 * w2.rotate90(1); add(w2); Wall w3 = new Wall(new Vector3d(0, 0, 9), 18, 5,
		 * this); add(w3); Wall w4 = new Wall(new Vector3d(0, 0, -9), 18, 5, this);
		 * add(w4);
		 */

		lireFichier();
	}

	private void lireFichier() {

		// accÃ¨s au fichier dans le repertoire "donnees" vu comme rÃ©pertoire source
		// (notez bien la prÃ©sence du caractÃ¨re '/' ici pour signaler le dossier
		// racine du projet)

		try { // ouverture de la ressource vue comme flux de donnÃ©es
			String nomFichier = "myenv.txt";

			String ligne = null;
			InputStream ips = this.getClass().getResourceAsStream(nomFichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader fichier = new BufferedReader(ipsr);
			// traitement
			while ((ligne = fichier.readLine()) != null) {
				traiteLigne(ligne);
			}
			// fermeture
			fichier.close();
		} catch (Exception exc) {
			System.out.println("Erreur fichier" + exc);
		}
	}

	private void traiteLigne(String ligne) {
		String[] tabChamp = ligne.split(" ");

		BaseObject tmp = null;
		// RobotHostile robotHostile = null;

		if (tabChamp[0].charAt(0) == 'W') {

			tmp = new Wall(
					new Vector3d(Integer.parseInt(tabChamp[1]), Integer.parseInt(tabChamp[2]),
							Integer.parseInt(tabChamp[3])),
					Integer.parseInt(tabChamp[4]), Integer.parseInt(tabChamp[5]), this);
			((BlockWorldObject) tmp).rotate90(Integer.parseInt(tabChamp[6]));

		} else if (tabChamp[0].charAt(0) == 'R') {

			tmp = new RobotHostile(new Vector3d(Integer.parseInt(tabChamp[1]), Integer.parseInt(tabChamp[2]),
					Integer.parseInt(tabChamp[3])), "RobotHostile");
			tmp.setColor(new Color3f(0.9f, 0.7f, 0.1f));
		}

		if (tmp != null)
			add(tmp);

	}
}
