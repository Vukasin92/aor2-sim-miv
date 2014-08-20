package rs.ac.bg.etf.aor2.simulator.gui;

import rs.ac.bg.etf.aor2.simulator.digitalcomponents.NandGate;
import rs.ac.bg.etf.aor2.simulator.digitalcomponents.OutGate;

public class OutComponentPresentation extends ComponentPresentation {

	public <T> Object execute(T... data) {
		OutGate outgate = (OutGate) component;
		outgate.calculate();
		return this;
	}
	
}
