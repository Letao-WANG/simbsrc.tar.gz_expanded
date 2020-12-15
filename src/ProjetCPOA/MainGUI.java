package ProjetCPOA;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.vecmath.Vector3d;

import ProjetCPOA.gui.WorldWindow;
import simbad.gui.AgentInspector;
import simbad.gui.ControlWindow;
import simbad.sim.Agent;
import simbad.sim.EnvironmentDescription;
import simbad.sim.SimpleAgent;
import simbad.sim.Simulator;
import simbad.sim.World;

public class MainGUI extends JFrame implements KeyListener{
	
	// ATTRIBUTS
	Controle controle;
	Robot robot;
	EnvironmentDescription ed;
	World world;
	WorldWindow worldWindow;
	Simulator simulator;
	JDesktopPane desktop;
	AgentInspector agentInspector=null;

	public MainGUI(Controle controle) {
		this.controle = controle;
		robot = new Robot(new Vector3d(8.5, 0, 8), "Robot", controle);
		RobotCherry robotCherry = new RobotCherry(new Vector3d(-7.5, 0, -7), "RobotCherry", controle);
		ed = new MyEnv(robot, robotCherry);
		world = new World(ed);
		simulator = new Simulator(desktop, world, ed, 0, false);
		desktop = new JDesktopPane();
		getContentPane().add(desktop);
		
		worldWindow = new WorldWindow(world);
        desktop.add(worldWindow);
        worldWindow.setRequestFocusEnabled(true);
        worldWindow.show();
        worldWindow.setLocation(300, 20);
        worldWindow.setBorder(null);
        //agentInspector = createAgentInspector(simulator, 20, 20);
        
        AgentFollower agentFollower;
        agentFollower = new AgentFollower(world, robot);
        //agentFollower.setViewPointType(World.VIEW_ABOVE_AGENT_NEAR);
        agentFollower.setViewPointType(World.VIEW_FROM_TOP);
        agentFollower.resume();
        
        setSize(1200, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        this.setAutoRequestFocus(true);
        this.setFocusable(false);
        desktop.setFocusable(true);
        addKeyListener(worldWindow);
        desktop.addKeyListener(this);
        worldWindow.addKeyListener(this);
        agentInspector.addKeyListener(this);
	}
	
	private AgentInspector createAgentInspector(Simulator simulator, int x,
            int y) {
        ArrayList agents = simulator.getAgentList();
        SimpleAgent a = ((SimpleAgent) agents.get(0));
        if (a instanceof Agent) {
            AgentInspector ai = new AgentInspector((Agent) a, true,simulator);
            desktop.add(ai);
            ai.show();
            ai.setLocation(x, y);
            return ai;
        } else
            return null;
    }

	@Override
	public void keyPressed(KeyEvent e) {
		//setTranslationalVelocity(0.5);	
		simulator.startSimulation();
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_LEFT:
			simulator.setDirection(1);
			simulator.setRobotStart(true);
			break;
		case KeyEvent.VK_UP:
			simulator.setDirection(3);
			simulator.setRobotStart(true);
			break;
		case KeyEvent.VK_DOWN:
			simulator.setDirection(2);
			simulator.setRobotStart(true);
			break;
		case KeyEvent.VK_RIGHT:
			simulator.setDirection(0);
			simulator.setRobotStart(true);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		simulator.setRobotStart(false);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
