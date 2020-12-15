package simbad.gui;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import simbad.sim.EnvironmentDescription;
import simbad.sim.Simulator;
import simbad.sim.World;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnvironmentDescription ed = new simbad.demo.BaseDemo();
		World world = new World(ed);
		WorldWindow worldWindow = new WorldWindow(world);
		worldWindow.show();
		worldWindow.setLocation(300, 20);
		//Simulator(worldWindow, world, new simbad.demo.BaseDemo());
		
		JDesktopPane desktop = new JDesktopPane();
		desktop.setFocusable(true);
		world = new World(ed);
		Simulator simulator = new Simulator(desktop, world, ed);
		
		/*JFrame frame=new JFrame("first"); 
        
        // creates instance of JButton 
        JButton button = new JButton("let's see"); 
  
        button.setBounds(200, 150, 90, 50); 
          
        // setting close operation 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  
        // adds button in JFrame 
        frame.add(button); 
  
        // sets 500 width and 600 height 
        frame.setSize(500, 600); 
          
        // uses no layout managers 
        frame.setLayout(null); 
          
        // makes the frame visible 
        frame.setVisible(true); */

	}

}
