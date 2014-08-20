package rs.ac.bg.etf.aor2.simulator.gui;

import java.awt.Graphics;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class WorkingPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	JFrame parent;

	List<Drawable> drawables;

	public WorkingPanel(JFrame guiFrame, List<Drawable> drawables) {
		super();
		this.parent = guiFrame;
		this.setSize(490, 390);
		this.addMouseListener(new MyMouseListener());

		this.drawables = drawables;
	}

	public List<Drawable> getDrawables() {
		return drawables;
	}

	public void setDrawables(List<Drawable> drawables) {
		this.drawables = drawables;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Drawable drawable : drawables) {
			drawable.draw(g);
		}
	}

	class MyMouseListener extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			if (event.getClickCount() > 1) {
				boolean result = false;
				for (Drawable drawable : drawables) {
					if (drawable.isOver(event.getX(), event.getY())) {
						Object r = drawable.execute(event);
						result = result || (r != null);
					}
				}
				if (result)
					parent.repaint();
			}
		}

	}

}
