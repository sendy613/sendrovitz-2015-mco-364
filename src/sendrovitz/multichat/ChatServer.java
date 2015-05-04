package sendrovitz.multichat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JTextArea;

public class ChatServer implements ReaderListener {
	private ServerSocket serverSocket;
	private ArrayList<Socket> sockets;
	private LinkedBlockingQueue<String> queue;
	private WriterThread writerThread;

	public ChatServer() {
		sockets = new ArrayList<Socket>();
		queue = new LinkedBlockingQueue<String>();

		try {

			this.serverSocket = new ServerSocket(2009);
			Socket socket;
			writerThread = new WriterThread(queue, sockets);
			Thread threadWrite = new Thread(writerThread);
			threadWrite.start();
			while(true){
			socket = serverSocket.accept();
			sockets.add(socket);
			ReaderThread readerThread = new ReaderThread(socket, this);
			Thread threadRead = new Thread(readerThread);
			threadRead.start();
			}
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onLineRead(String line) {
		queue.add(line);

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
