package sendrovitz.multichat;

public class ChatMain {

	public static void main(String args[]) {
		Thread t = new Thread() {
			public void run() {
				ChatServer server = new ChatServer();
			}
		};
		t.start();
		Thread t1 = new Thread() {
			public void run() {
				GuiClientChat b = new GuiClientChat();
				b.setVisible(true);
			}
		};
		t1.start();
		Thread t2 = new Thread() {
			public void run() {
				GuiClientChat c = new GuiClientChat();
				c.setVisible(true);
			}
		};
		t2.start();

		Thread t3 = new Thread() {
			public void run() {
				GuiClientChat d = new GuiClientChat();
				d.setVisible(true);
			}
		};
		t3.start();

	}
}
