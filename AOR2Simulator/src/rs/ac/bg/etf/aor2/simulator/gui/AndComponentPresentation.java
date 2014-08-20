package rs.ac.bg.etf.aor2.simulator.gui;

import java.awt.Color;
import java.awt.Graphics;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import rs.ac.bg.etf.aor2.simulator.ColorSignalConverter;
import rs.ac.bg.etf.aor2.simulator.Port;
import rs.ac.bg.etf.aor2.simulator.digitalcomponents.AndGate;




public class AndComponentPresentation extends ComponentPresentation {
	
	BufferedImage img = null;
	
	public AndComponentPresentation() {
		super();
		
		try {
		    img = ImageIO.read(new File("strawberry.jpg"));
		} catch (IOException e) {
		}
	}
	
	public <T> Object execute(T... data) {
		AndGate andgate = (AndGate) component;
		andgate.calculate();
		return this;
	}
	
	@Override
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.drawRect(x, y, width - 2 * MARGIN, height);
		g.drawImage(img, x, y, width - 2 * MARGIN, height, null);
		int in = 1;
		int out = 1;
		for (Port p : component.getPorts()) {
			g.setColor(ColorSignalConverter.convert(p));
			if (p.getType() == Port.IN || p.getType() == Port.INOUT) {
				g.drawLine(x, y + MARGIN * in, x + MARGIN, y + MARGIN * in);
				in++;
			} else {
				g.drawLine(x + width - 2 * MARGIN, y + MARGIN * out, x + width
						- MARGIN, y + MARGIN * out);
				out++;
			}
		}
		g.setColor(c);
	}
}
