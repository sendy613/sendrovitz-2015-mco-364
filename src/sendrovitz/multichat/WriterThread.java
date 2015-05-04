package sendrovitz.multichat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class WriterThread implements Runnable {
	private LinkedBlockingQueue<String> queue;
	private ArrayList<Socket> sockets;

	public WriterThread(LinkedBlockingQueue<String> queue, ArrayList<Socket> sockets) {
		this.queue = queue;
		this.sockets = sockets;
	}

	@Override
	public void run() {
		OutputStream out;
		PrintWriter writer;
		while(true){
		try {
			
			String s = queue.take();
			for (Socket sck : sockets) {
				out = sck.getOutputStream();
				writer = new PrintWriter(out);
				writer.println(s);
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	}
}
