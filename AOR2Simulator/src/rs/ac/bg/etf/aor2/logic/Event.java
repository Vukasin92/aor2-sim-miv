package rs.ac.bg.etf.aor2.logic;

public class Event implements Comparable<Event> {

	long time;

	Value value;

	EventExecutable dst; // destination component or signal
	int dstSignal; // port or signal id on destination

	EventExecutable src; // optional //source component or signal
	int srcSignal; // optional//port or signal id on source

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public EventExecutable getDst() {
		return dst;
	}

	public void setDst(EventExecutable dst) {
		this.dst = dst;
	}

	public int getDstSignal() {
		return dstSignal;
	}

	public void setDstSignal(int dstSignal) {
		this.dstSignal = dstSignal;
	}

	public EventExecutable getSrc() {
		return src;
	}

	public void setSrc(EventExecutable src) {
		this.src = src;
	}

	public int getSrcSignal() {
		return srcSignal;
	}

	public void setSrcSignal(int srcSignal) {
		this.srcSignal = srcSignal;
	}

	public int compareTo(Event t) {
		return time > t.time ? 1 : time < t.time ? -1 : 0;
	}

}
