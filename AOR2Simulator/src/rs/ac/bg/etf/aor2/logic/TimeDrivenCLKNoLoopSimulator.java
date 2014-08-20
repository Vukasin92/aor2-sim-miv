package rs.ac.bg.etf.aor2.logic;

import java.util.*;

public class TimeDrivenCLKNoLoopSimulator extends TimeDrivenCLKSimulator {

	Map<LogicComponent, List<Signal>> connectedSignals;

	public TimeDrivenCLKNoLoopSimulator() {
		super();

	}

	public TimeDrivenCLKNoLoopSimulator(long currentTime, long endTime,
			long clkInterval) {
		super(currentTime, endTime, clkInterval);
	}

	public void simulate(long time) {
		while (currentTime < time) {

			for (LogicComponent component : sequentialComponents) {
				component.execute();
			}

			for (Signal signal : sequentialSignals) {
				signal.execute();
			}

			for (LogicComponent component : combinationalComponents) {
				component.execute();
				for (Signal signal : connectedSignals.get(component)) {
					signal.execute();
				}
			}
			currentTime += clkInterval;
		}
	}

	public void init() {

		super.init();

		topologicallySort(combinationalComponents);
		connectedSignals = extractConnectedSignals(netlist);
	}

	private Map<LogicComponent, List<Signal>> extractConnectedSignals(
			Netlist netlist) {
		// TODO Auto-generated method stub
		return null;
	}

	private void topologicallySort(List<LogicComponent> combinationalComponents) {
		// TODO Auto-generated method stub

	}

}
