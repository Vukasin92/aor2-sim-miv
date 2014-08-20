package rs.ac.bg.etf.aor2.mojindex;

import java.awt.Color;
import java.awt.Graphics;

import rs.ac.bg.etf.aor2.simulator.ColorSignalConverter;
import rs.ac.bg.etf.aor2.simulator.Port;
import rs.ac.bg.etf.aor2.simulator.digitalcomponents.NandGate;
import rs.ac.bg.etf.aor2.simulator.gui.ComponentPresentation;

public class RegisterComponentPresentation extends ComponentPresentation {

	public <T> Object execute(T... data) {
		Register register = (Register) component;
		register.calculate();
		return this;
	}
	
}
