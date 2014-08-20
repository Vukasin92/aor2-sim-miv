package rs.ac.bg.etf.aor2.simulator.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.*;

import rs.ac.bg.etf.aor2.simulator.*;

public class GuiFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	Simulator simulator;

	WorkingPanel workingPanel;

	CommandPanel commandPanel;

	ValueTablePanel valueTablePanel;

	GraphicsPanel graphicsPanel;

	public GuiFrame(Simulator simulator, List<Drawable> drawables) {
		super("AOR2 Simulator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.simulator = simulator;

		setDefaultLookAndFeelDecorated(true);

		this.setSize(500, 400);

		this.setLayout(new GridLayout());

		workingPanel = new WorkingPanel(this, drawables);
		workingPanel.setBackground(Color.GREEN);
		this.add(workingPanel);

		commandPanel = new CommandPanel(this, simulator);
		this.add(commandPanel);

		valueTablePanel = new ValueTablePanel(this);
		// adds all signals test only
		valueTablePanel.addSignals(simulator.getNetlist().getSignals());
		this.add(valueTablePanel);

		// adds all signals test only
		graphicsPanel = new GraphicsPanel(this, simulator.getNetlist()
				.getSignals(), simulator);
		this.add(graphicsPanel);
	}

}
