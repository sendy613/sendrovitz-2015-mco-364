package sendrovitz.multichat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReaderRunnable implements Runnable {
	// read individ lines from stream and do something with it
	private Socket socket;
	private ReaderListener listener;
	
	public ReaderRunnable(Socket socket, ReaderListener listener) {
		this.socket = socket;
		this.listener = listener;
	}

	public void run() {
		InputStream in;
		try {
			in = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				// tells listener that read a line
				listener.onLineRead(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		// tell listener when program ends
		listener.onCloseSocket(socket);
	}
}
