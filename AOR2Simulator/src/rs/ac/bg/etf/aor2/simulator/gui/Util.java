package rs.ac.bg.etf.aor2.simulator.gui;

import java.util.List;

import rs.ac.bg.etf.aor2.simulator.*;

public class Util {
	public static void connect(List<Drawable> drawables, Netlist netlist) {
		for (Drawable d : drawables) {
			d.init(netlist);
		}
	}

}
