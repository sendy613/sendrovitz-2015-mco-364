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

import org.apache.commons.io.IOUtils;

public class ChatClient {
	private JTextArea textArea;
	private PrintWriter writer;
	private Socket clientSocket;

	public ChatClient(JTextArea textArea) {

		this.clientSocket = null;
		this.textArea = textArea;
		try {

			clientSocket = new Socket("localhost", 2009);
			OutputStream out = clientSocket.getOutputStream();
			this.writer = new PrintWriter(out);

			Thread thread = new Thread() {
				public void run() {
					InputStream in;
					try {
						in = clientSocket.getInputStream();

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

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/*
		 * finally { IOUtils.closeQuietly(clientSocket); }
		 */

	}

	public void setText(String text) {
		writer.println(text);
		writer.flush();
	}

	public void append(String line) {
		this.textArea.append("Server: " + line + "\n");
	}

}
