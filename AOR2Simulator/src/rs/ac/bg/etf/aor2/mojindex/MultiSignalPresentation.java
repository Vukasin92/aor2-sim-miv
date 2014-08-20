package rs.ac.bg.etf.aor2.mojindex;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

import rs.ac.bg.etf.aor2.simulator.ColorSignalConverter;
import rs.ac.bg.etf.aor2.simulator.gui.SignalPresentation;

public class MultiSignalPresentation extends SignalPresentation {

	JLabel label2 = new JLabel("0");
	
	public MultiSignalPresentation() {
		super();
		lineSize = 5;
		
	}
	
	@Override
	public void draw(Graphics g) {
		Color c = g.getColor();

		Graphics2D graphics2d = (Graphics2D) g;
		

		graphics2d.setStroke(new BasicStroke(lineSize));
		
		graphics2d.drawString(Integer.toString(signal.getValue().getIntValue()), line.xpoints[0], line.ypoints[0]);
		
		g.setColor(ColorSignalConverter.convert(signal));

		g.drawPolyline(line.xpoints, line.ypoints, line.npoints);

		g.setColor(c);
	}
	
}
