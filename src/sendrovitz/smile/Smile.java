package sendrovitz.smile;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.GroupLayout;
import javax.swing.JFrame;

public class Smile extends JFrame {
	private SmileComponent smile;

	public Smile() {
		setSize(550, 600);
		setTitle("SMILE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		this.smile = new SmileComponent();
		contentPane.add(smile);

	}

	public static void main(String args[]) {
		final Smile smile = new Smile();
		smile.setVisible(true);

		// animation thread- bec you are constantly calling repaint
		Thread thread = new Thread() {
			public void run() {
				while (true) {
					smile.repaint();
					try {
						Thread.sleep(1000); // stops the thread for 1 sec (1000
											// ml sec)
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
	}
}
