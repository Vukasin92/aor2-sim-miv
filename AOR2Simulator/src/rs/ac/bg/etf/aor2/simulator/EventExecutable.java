package rs.ac.bg.etf.aor2.simulator;

import java.util.*;

public interface EventExecutable {

	public List<Event> preCalculateEvents();

	public List<Event> execute(Event event);

}
