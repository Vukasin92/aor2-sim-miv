package rs.ac.bg.etf.aor2.simulator;

public class Test {

	public static void main(String[] args) {
		String componentsInFile = "components.txt";
		String signalsInFile = "signals.txt";
		String connectionsInFile = "connections.txt";

		Loader loader = new LoaderFile();

		Netlist netlist = new NetlistSimple();
		netlist.setComponents(loader.loadComponents(componentsInFile));
		netlist.setSignals(loader.loadSignals(signalsInFile));
		netlist.setConnectors(loader.loadConnectors(connectionsInFile));

		TimeDrivenSimulator simulator = new TimeDrivenSimulator();

		simulator.setNetlist(netlist);
		simulator.init();
		for (int i = 1; i < 5; i++) {
			simulator.simulate(30 * i);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		String componentsOutFile = "components1.xml";
		String signalsOutFile = "signals1.xml";
		String connectionsOutFile = "connections1.xml";

		loader = new LoaderXML();
		
		loader.storeComponents(netlist.getComponents(), componentsOutFile);
		loader.storeSignals(netlist.getSignals(), signalsOutFile);
		loader.storeConnectors(netlist.getConnectors(), connectionsOutFile);

	}

}
