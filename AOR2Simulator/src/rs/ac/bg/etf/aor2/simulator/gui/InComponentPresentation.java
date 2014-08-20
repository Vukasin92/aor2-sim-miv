package rs.ac.bg.etf.aor2.simulator.gui;

import rs.ac.bg.etf.aor2.simulator.digitalcomponents.*;

public class InComponentPresentation extends ComponentPresentation{

	@Override
	public <T> Object execute(T... data) {
		InGate ingate = (InGate) component;
		ingate.calculate();
		return this;
	}
	
}
