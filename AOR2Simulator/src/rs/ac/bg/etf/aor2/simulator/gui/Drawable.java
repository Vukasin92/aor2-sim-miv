package rs.ac.bg.etf.aor2.simulator.gui;

import java.awt.*;

import rs.ac.bg.etf.aor2.simulator.Loadable;

public interface Drawable extends Loadable {

	public void draw(Graphics g);

	public void drawSelected(Graphics g);

	public void moveFor(int x, int y);

	public void moveTo(int x, int y);

	public void resize(double percent);

	public void resize(double percentX, double percentY);

	public void rotate(double alfa);

	public void flip(int f);

	public void zoom(float f);

	public Point getPosition();

	public void setPosition(Point p);

	public void setPosition(int x, int y);

	public Dimension getDimension();

	public void setDimension(Dimension d);

	public void setDimension(int width, int height);

	public void calcDimension();

	public String getText();

	public void setText(String text);

	public String getImageURL();

	public void setImageURL(String url);

	public float getLineSize();

	public void setLineSize(float size);

	public int getLineType();

	public void setLineType(int type);
	
	public boolean isOver(int x, int y);

	public <T> Object execute(T... data);
}
