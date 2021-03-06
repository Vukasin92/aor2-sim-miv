package rs.ac.bg.etf.aor2.logic;

import java.util.*;

public class TimeDrivenCLKSimulator extends TimeDrivenSimulator {
	List<LogicComponent> sequentialComponents;
	List<LogicComponent> combinationalComponents;
	List<Signal> sequentialSignals;
	List<Signal> combinationalSignals;
	long clkInterval;

	public TimeDrivenCLKSimulator() {
		super();
		this.clkInterval = 1;
	}

	public TimeDrivenCLKSimulator(long currentTime, long endTime,
			long clkInterval) {
		super(currentTime, endTime);
		this.clkInterval = clkInterval;
	}

	public void simulate(long time) {
		while (currentTime < time) {

			for (LogicComponent component : sequentialComponents) {
				component.execute();
			}
			for (Signal signal : sequentialSignals) {
				signal.execute();
			}

			for (int i = 0; i < clkInterval; i++) {
				for (LogicComponent component : combinationalComponents) {
					component.execute();
				}
				for (Signal signal : combinationalSignals) {
					signal.execute();
				}
				currentTime++;
			}
		}
	}

	public void init() {

		super.init();

		sequentialComponents = extractSequential(netlist);
		combinationalComponents = extractCombinational(netlist);
		sequentialSignals = extractSequentialSignals(netlist);
		combinationalSignals = extractCombinationalSignals(netlist);
	}

	public List<LogicComponent> extractSequential(Netlist netlist) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<LogicComponent> extractCombinational(Netlist netlist) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Signal> extractCombinationalSignals(Netlist netlist) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Signal> extractSequentialSignals(Netlist netlist) {
		// TODO Auto-generated method stub
		return null;
	}

}
