package rs.ac.bg.etf.aor2.mojindex;

import java.util.ArrayList;
import java.util.List;

import rs.ac.bg.etf.aor2.simulator.DigitalValue;
import rs.ac.bg.etf.aor2.simulator.Event;
import rs.ac.bg.etf.aor2.simulator.LogicComponentSimple;
import rs.ac.bg.etf.aor2.simulator.Port;
import rs.ac.bg.etf.aor2.simulator.PortSimple;


public class Register extends LogicComponentSimple {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numInputs;
	private int value;

	@Override
	public void preCalculateTime() {
		// TODO Auto-generated method stub
		int newVal = calculate();
		Port out = ports.get(numInputs);
		out.getValue().setIntValue(newVal);
	}

	int calculate() {
	
		if (ports == null)
			return value;
		if (findPort("INC").getValue().getBooleanValue()
				&& findPort("LD").getValue().getBooleanValue() == false) {
			value++;
			if (value == 256)
				value = 0;
			return value;
		}
		if (findPort("LD").getValue().getBooleanValue()
				&& findPort("INC").getValue().getBooleanValue() == false) {
			value = findPort("IN").getValue().getIntValue();
			return value;
		}
		return value;
	}

	@Override
	public void execute() {
		if (findPort("CLK").getValue().getBooleanValue() == false) return;
		int newVal = calculate();
		Port out = ports.get(numInputs);
		out.getValue().setIntValue(newVal);
	}

	@Override
	public List<Event> preCalculateEvents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> execute(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(String[] data) {
		// TODO Auto-generated method stub
		setId(Integer.parseInt(data[1]));
		numInputs = Integer.parseInt(data[2]);

		ports = new ArrayList<Port>();
		
		Port port = new PortSimple(Port.IN, new DigitalValue8Bit(0), data[3], data[3], 0, this);
		ports.add(port);
		for (int i = 1; i < numInputs; i++) {
			port = new PortSimple(Port.IN, new DigitalValue(0),
					data[i + 3], data[i + 3], i, this);
			ports.add(port);
		}
		port = new PortSimple(Port.OUT, new DigitalValue8Bit(0), "OUT", "out",
				numInputs, this);
		ports.add(port);
	}

	@Override
	public void init(Object... parameters) {
		// TODO Auto-generated method stub

	}

	@Override
	public String[] state() {
		String[] state = new String[] { this.getClass().getName(),
				"" + this.id, "" + numInputs };
		return state;
	}

}
