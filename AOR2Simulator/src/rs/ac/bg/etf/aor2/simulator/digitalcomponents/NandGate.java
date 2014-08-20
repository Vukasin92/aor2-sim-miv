package rs.ac.bg.etf.aor2.simulator.digitalcomponents;

import rs.ac.bg.etf.aor2.simulator.*;

public class NandGate extends OneOutputGate {

	private static final long serialVersionUID = 1L;

	public boolean calculate() {
		boolean result = true;
		for (int i = 0; i < numInputs; i++) {
			Port port = ports.get(i);
			result = result && port.getValue().getBooleanValue();
		}
		return !result;
	}

}
