package rs.ac.bg.etf.aor2.logic;

public interface Signal extends TimeExecutable, EventExecutable{
	public static final int NOTSET = -1;
	public static final int CONNECTED = 1;

	public static final int SIGNAL = 5;

	public void setName(String name);
	
	public String getName();

	public void setId(int id);

	public int getId();

	public void setValue(Value val);

	public Value getValue();

	public void connect(Signal signal);

	public void dissconnect(Signal signal);

	public boolean isConnected();

}
