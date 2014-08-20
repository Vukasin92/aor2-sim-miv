package rs.ac.bg.etf.aor2.simulator.test;

import java.util.*;

import javax.swing.*;

import rs.ac.bg.etf.aor2.simulator.*;
import rs.ac.bg.etf.aor2.simulator.gui.*;

public class TestLoadDraw {

	public static void main(String[] args) {
		System.out.println("aaa");
		String componentsInFile = "components.txt";
		String signalsInFile = "signals.txt";
		String connectionsInFile = "connections.txt";

		String guiInFile = "lines.txt";

		Loader loader = new LoaderFile();

		Netlist netlist = new NetlistSimple();
		netlist.setComponents(loader.loadComponents(componentsInFile));
		netlist.setSignals(loader.loadSignals(signalsInFile));
		netlist.setConnectors(loader.loadConnectors(connectionsInFile));

		Simulator simulator = new TimeDrivenSimulator();
		simulator.setNetlist(netlist);
		simulator.init();

		List<Drawable> drawables = loader.loadDrawables(guiInFile);

		Util.connect(drawables, netlist);

		JFrame frame = new GuiFrame4(simulator, drawables);
		frame.setVisible(true);

	}

}
