package homework.week12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Dimension;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CircleComponent extends JComponent {

	private static final long serialVersionUID = 1L;

	static final int WIDTH = 150;
	static final int HEIGHT = 150;

	final int CIRCLE_WIDTH = 100;
	final int CIRCLE_HEIGTH = 100;

	private Random r = new Random();

	public CircleComponent() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double circle1 = new Ellipse2D.Double(
				(WIDTH-CIRCLE_WIDTH) / 2.0, (HEIGHT-CIRCLE_HEIGTH) / 2.0,
				CIRCLE_WIDTH, CIRCLE_HEIGTH);
		g2.setColor(new Color(r.nextFloat(), r.nextFloat(), r.nextFloat()));
		g2.fill(circle1);
	}



	public static void main(String[] args) {

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.add(new CircleComponent());
		frame.add(panel);
		panel.add(new CircleComponent());
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		System.out.println("main 끝.");


	}

}
