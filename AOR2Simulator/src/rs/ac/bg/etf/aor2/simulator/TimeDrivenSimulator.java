package rs.ac.bg.etf.aor2.simulator;

import java.util.*;

public class TimeDrivenSimulator extends Simulator {

	public TimeDrivenSimulator() {
		super();
	}

	public TimeDrivenSimulator(long currentTime, long endTime) {
		super(currentTime, endTime);
	}

	public void simulate(long time) {
		while (currentTime < time) {
			List<LogicComponent> components = netlist.getComponents();
			for (LogicComponent component : components) {
				component.execute();
			}

			List<Signal> signals = netlist.getSignals();
			for (Signal signal : signals) {
				signal.execute();
			}
			currentTime++;
		}
	}

	public void init() {
		List<LogicComponent> components = netlist.getComponents();
		for (LogicComponent component : components) {
			component.preCalculateTime();
		}

		List<Signal> signals = netlist.getSignals();
		for (Signal signal : signals) {
			signal.preCalculateTime();
		}
	}

}
