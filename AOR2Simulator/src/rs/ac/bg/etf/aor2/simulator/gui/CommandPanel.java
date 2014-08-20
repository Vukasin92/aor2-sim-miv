package rs.ac.bg.etf.aor2.simulator.gui;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

import rs.ac.bg.etf.aor2.simulator.Simulator;

public class CommandPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	JFrame parent;

	Simulator simulator;

	public CommandPanel(JFrame guiFrame, Simulator simulator) {
		super();
		this.parent = guiFrame;
		this.setSize(490, 390);
		setBackground(Color.YELLOW);

		JButton button = new JButton("Next");
		button.addActionListener(new MyActionListener());
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

}
