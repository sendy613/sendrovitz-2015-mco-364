package sendrovitz.smile;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class Smile extends JFrame{
	public Smile(){
		setSize(800,600);
		setTitle("SMILE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		contentPane.add(new SmileComponent());
	}
	public static void main(String args[]){
		final Smile smile = new Smile();
		smile.setVisible(true);
		
		
		//animation thread- bec you are constantly calling repaint
		Thread thread = new Thread(){
			public void run(){
				while(true){
				smile.repaint();
				try {
					Thread.sleep(1000); //stops the thread for 1 sec (1000 ml sec)
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				}
			}
		};
		thread.start();
	}
}
