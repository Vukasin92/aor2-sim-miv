package rs.ac.bg.etf.aor2.logic;

import java.util.*;

public interface Netlist {
	
	List<LogicComponent> getComponents();
	
	List<Signal> getSignals();
	
	List<Connector> getConnectors();
	
	void addComponent(String[] args);
	
	void addSignal(String[] args);
	
	void addConnection(String[] args);
	
}
