package rs.ac.bg.etf.aor2.simulator.digitalcomponents;

import rs.ac.bg.etf.aor2.simulator.*;

public class NotGate extends OneOutputGate {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(String[] data) {
		id = Integer.parseInt(data[1]);
		numInputs = 1;
		init();
	}

	@Override
	public String[] state() {
		String[] state = new String[] { this.getClass().getName(), "" + this.id };
		return state;
	}

	public boolean calculate() {
		boolean result = false;
		Port port = ports.get(0);
		result = port.getValue().getBooleanValue();
		return !result;
	}

}
