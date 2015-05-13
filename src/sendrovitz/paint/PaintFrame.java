package sendrovitz.paint;

import java.awt.BorderLayout;


import javax.swing.JFrame;


public class PaintFrame extends JFrame {
	private DrawListener listener;
	
	public PaintFrame(){
	setSize(800, 600);
	setTitle("CANVAS");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocation(550,10);
	setLayout(new BorderLayout());
	
	Canvas canvas = new Canvas(600,600);
	add(canvas, BorderLayout.CENTER);
	listener =  new DrawListener(canvas);
	//these two methods tell the canvas who to notify when there is motion
	canvas.addMouseListener(listener);
	canvas.addMouseMotionListener(listener);
	}

}
