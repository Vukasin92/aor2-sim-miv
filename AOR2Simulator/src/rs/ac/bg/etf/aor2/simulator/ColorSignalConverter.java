package rs.ac.bg.etf.aor2.simulator;

import java.awt.*;

public class ColorSignalConverter {

	public static Color convert(Signal signal) {
		try {
			if (signal.getValue().getBooleanValue()) {
				return Color.RED;
			} else {
				return Color.BLUE;
			}
		} catch (Exception e) {
			return Color.BLACK;
		}
	}
}
