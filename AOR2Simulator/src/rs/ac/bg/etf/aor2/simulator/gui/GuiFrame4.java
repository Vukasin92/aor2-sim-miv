package rs.ac.bg.etf.aor2.simulator.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;

import javax.swing.*;

import rs.ac.bg.etf.aor2.simulator.Loader;
import rs.ac.bg.etf.aor2.simulator.LoaderFile;
import rs.ac.bg.etf.aor2.simulator.Netlist;
import rs.ac.bg.etf.aor2.simulator.NetlistSimple;
import rs.ac.bg.etf.aor2.simulator.Simulator;
import rs.ac.bg.etf.aor2.simulator.TimeDrivenSimulator;

public class GuiFrame4 extends JFrame {
	private static final long serialVersionUID = 1L;

	String[] inFile = new String[4];

	Simulator simulator;

	WorkingPanel4 workingPanel;

	CommandPanel4 commandPanel;

	ValueTablePanel valueTablePanel;

	GraphicsPanel4 graphicsPanel;

	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuItem;

	final JFileChooser fc = new JFileChooser();

	public GuiFrame4(Simulator simulator, List<Drawable> drawables) {
		super("AOR2 Simulator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.simulator = simulator;

		setDefaultLookAndFeelDecorated(true);

		this.setSize(500, 400);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menu = new JMenu("File");
		menuBar.add(menu);

		menuItem = new JMenuItem("Open");
		menu.add(menuItem);
		menuItem.addActionListener(new MyActionListener());
		menuItem = new JMenuItem("Close");
		menu.add(menuItem);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				// setVisible(false);
				dispose();
			}

		});

		
	}

	class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			File f = new File("D:\\Java\\AOR2Sim\\AOR2Simulator\\");
			fc.setCurrentDirectory(f);
			int returnVal = fc.showOpenDialog(GuiFrame4.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				BufferedReader br = null;
				try {
					FileReader fr = new FileReader(file);
					br = new BufferedReader(fr);

					String s;
					int i = 0;
					while ((s = br.readLine()) != null) {
						inFile[i] = s;
						i++;
					}

					Loader loader = new LoaderFile();

					Netlist netlist = new NetlistSimple();
					netlist.setComponents(loader.loadComponents(inFile[0]));
					netlist.setSignals(loader.loadSignals(inFile[1]));
					netlist.setConnectors(loader.loadConnectors(inFile[2]));

					GuiFrame4.this.simulator = new TimeDrivenSimulator();
					GuiFrame4.this.simulator.setNetlist(netlist);
					GuiFrame4.this.simulator.init();

					List<Drawable> drawables = loader.loadDrawables(inFile[3]);

					Util.connect(drawables, netlist);
					
					//GuiFrame4.this.removeAll(); NEKAKO IZBRISATI STARI PRIKAZ KAD SE LOADUJE NOVI
					JPanel pane1 = new JPanel(new GridLayout(2,1));
					GuiFrame4.this.setLayout(new BorderLayout());
					
					workingPanel = new WorkingPanel4(GuiFrame4.this, drawables);
					workingPanel.setBackground(Color.GREEN);
					pane1.add(workingPanel);
					
					JPanel pane = new JPanel(new GridLayout(2,1));
					
					valueTablePanel = new ValueTablePanel(GuiFrame4.this);
					// adds all signals test only
					valueTablePanel.addSignals(simulator.getNetlist().getSignals());
					pane.add(valueTablePanel);
					commandPanel = new CommandPanel4(GuiFrame4.this, simulator);
					pane.add(commandPanel);

					GuiFrame4.this.add(pane, BorderLayout.EAST);

					// adds all signals test only
					graphicsPanel = new GraphicsPanel4(GuiFrame4.this, simulator.getNetlist().getSignals(), simulator);
					pane1.add(graphicsPanel);
					GuiFrame4.this.add(pane1, BorderLayout.CENTER);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (br != null)
						try {
							br.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
		}
	}
}
