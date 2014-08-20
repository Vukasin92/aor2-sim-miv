package rs.ac.bg.etf.aor2.simulator;

public interface Loadable {

	public void init(String[] data);

	public void init(Object... parameters);

	public String[] state();
}
