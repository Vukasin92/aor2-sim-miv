package rs.ac.bg.etf.aor2.logic;

public interface Value {

	public int getIntValue();

	public void setIntValue(int value);

	public long getLongValue();

	public void setLongValue(long value);

	public boolean getBooleanValue();

	public void setBooleanValue(boolean val);

	public String getStringValue();

	public void setStringValue(String val);

	public Value copy();

	public void load(Value value);

}