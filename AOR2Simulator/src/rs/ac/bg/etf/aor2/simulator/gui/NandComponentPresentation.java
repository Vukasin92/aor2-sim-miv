package rs.ac.bg.etf.aor2.simulator.gui;

import rs.ac.bg.etf.aor2.simulator.digitalcomponents.AndGate;
import rs.ac.bg.etf.aor2.simulator.digitalcomponents.NandGate;

public class NandComponentPresentation extends ComponentPresentation {
	
	public <T> Object execute(T... data) {
		NandGate nandgate = (NandGate) component;
		nandgate.calculate();
		return this;
	}
	
}
