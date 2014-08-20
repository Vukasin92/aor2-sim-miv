package rs.ac.bg.etf.aor2.logic;

import java.util.*;

public interface EventExecutable {

	public void init(String[] data);

	public List<Event> preCalculate();
	
	public List<Event> execute(Event event);

}
