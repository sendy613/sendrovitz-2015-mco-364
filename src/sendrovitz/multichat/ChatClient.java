package sendrovitz.multichat;


import java.io.IOException;

import java.io.OutputStream;
import java.io.PrintWriter;

import java.net.Socket;

import javax.swing.JTextArea;

import org.apache.commons.io.IOUtils;

public class ChatClient implements ReaderListener {
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
			ReaderThread thread = new ReaderThread(clientSocket, this);
			Thread t = new Thread(thread);
			t.start();

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

	@Override
	public void onLineRead(String line) {
		textArea.append(line +"\n");
		
	}


	@Override
	public void onCloseSocket(Socket socket) {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
