package rs.ac.bg.etf.aor2.simulator;

import java.io.*;
import java.util.*;

public interface Value extends Serializable, Comparable<Value> {

	public int getIntValue();

	public void setIntValue(int value);

	public long getLongValue();

	public void setLongValue(long value);

	public boolean getBooleanValue();

	public void setBooleanValue(boolean val);

	public String getStringValue();

	public void setStringValue(String val);

	public int getSize();

	public List<Value> separateValues();

	public Value copy();

	public boolean load(Value value);

}