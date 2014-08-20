package rs.ac.bg.etf.aor2.mojindex;

import java.util.HashMap;
import java.util.HashSet;

import rs.ac.bg.etf.aor2.simulator.DigitalValue;

public class DigitalValue8Bit extends DigitalValue {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DigitalValue8Bit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DigitalValue8Bit(DigitalValue d) {
		super(d);
		// TODO Auto-generated constructor stub
	}

	public DigitalValue8Bit(int value) {
		super(value);
		// TODO Auto-generated constructor stub
	}

	public DigitalValue8Bit(String val) {
		super(val);
		// TODO Auto-generated constructor stub
	}

	static {
		for (int i = 2; i<256; i++) {
			values.add(i);
		}
	}

}
