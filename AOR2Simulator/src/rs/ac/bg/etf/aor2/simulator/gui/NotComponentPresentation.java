package rs.ac.bg.etf.aor2.simulator.gui;

import rs.ac.bg.etf.aor2.simulator.digitalcomponents.AndGate;
import rs.ac.bg.etf.aor2.simulator.digitalcomponents.NotGate;

public class NotComponentPresentation extends ComponentPresentation {
	
	public <T> Object execute(T... data) {
		NotGate notgate = (NotGate) component;
		notgate.calculate();
		return this;
	}
	
}
