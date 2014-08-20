package rs.ac.bg.etf.aor2.simulator.gui;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

import rs.ac.bg.etf.aor2.simulator.Simulator;

public class CommandPanel4 extends JPanel {

	private static final long serialVersionUID = 1L;

	JFrame parent;
	JTextField jtf = new JTextField(5);
	Simulator simulator;

	public CommandPanel4(JFrame guiFrame, Simulator simulator) {
		super();
		this.parent = guiFrame;
		this.setSize(490, 390);
		setBackground(Color.YELLOW);
		
		JButton button = new JButton("Next");
		button.addActionListener(new MyActionListener());
		add(button);
		add(jtf);
		button = new JButton("Go");
		button.addActionListener(new MyActionListener2());
		add(button);

		this.simulator = simulator;
	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			simulator.simulate(simulator.getCurrentTime() + 1);
			parent.repaint();
		}
	}
	
	class MyActionListener2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//simulator.setCurrentTime(0);
			simulator.simulate(Integer.parseInt(jtf.getText())); //dodati proveru greske ako nije int
			parent.repaint();
		}
	}

}
