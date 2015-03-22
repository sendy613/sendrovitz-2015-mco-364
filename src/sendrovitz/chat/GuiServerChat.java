package sendrovitz.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuiServerChat extends JFrame {
	private JTextField input;
	private JTextArea output;
	private JButton send;
	private JPanel panel;
	private ChatServer server;

	public GuiServerChat() {
		setSize(500, 500);
		setTitle("SERVER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(10,10);

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		panel = new JPanel(new FlowLayout());
		input = new JTextField();
		input.setColumns(35);
		output = new JTextArea();
		output.setColumns(35);
		output.setTabSize(400);
		output.setEditable(false);
		output.setBackground(Color.ORANGE);
		server= new ChatServer(output);
		send = new JButton("Enter");
		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				output.append("Me: " + input.getText()+"\n");
				server.setText(input.getText());
				input.setText("");
			}
		});
		contentPane.add(output, BorderLayout.CENTER);
		panel.add(input);
		panel.add(send);
		contentPane.add(panel, BorderLayout.SOUTH);

	}

}
