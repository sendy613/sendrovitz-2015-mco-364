package sendrovitz.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.commons.io.IOUtils;

public class ChatServer {
	private JTextArea textArea;
	private ServerSocket serverSocket;
	private PrintWriter writer;

	public ChatServer(JTextArea textArea) {
		this.textArea = textArea;

		try {

			this.serverSocket = new ServerSocket(2009);

			Thread thread = new Thread() {
				public void run() {
					Socket socket;
					InputStream in;
					try {
						socket = serverSocket.accept();
						OutputStream out = socket.getOutputStream();
						writer = new PrintWriter(out);

						in = socket.getInputStream();
						BufferedReader reader = new BufferedReader(new InputStreamReader(in));

						String line;
						while ((line = reader.readLine()) != null) {
							append(line);
						}

					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			};
			thread.start();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void append(String line) {
		this.textArea.append("Client: " + line + "\n");
	}

	public void setText(String text) {
		writer.println(text);
		writer.flush();
	}
}
