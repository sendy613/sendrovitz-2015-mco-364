package sendrovitz.paint;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {
	private DrawListener listener;
	private JComboBox<String> colorsBox;
	private JPanel options;
	private JPanel colorPanel;
	private JLabel colorLabel;
	private Color color;
	private JPanel toolPanel;
	private JLabel toolLabel;
	private JComboBox<String> toolBox;
	private String tool;

	public PaintFrame() {
		setSize(800, 650);
		setTitle("CANVAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setLayout(new BorderLayout());

		color = Color.BLACK;
		tool = "Pencil";
		Canvas canvas = new Canvas(600, 600, color, tool);
		add(canvas, BorderLayout.CENTER);
		listener = new DrawListener(canvas);
		// these two methods tell the canvas who to notify when there is motion
		canvas.addMouseListener(listener);
		canvas.addMouseMotionListener(listener);
		String[] list = { "Black", "Red", "Orange", "Yellow", "Green", "Blue","Gray", "Pink" };
		this.colorsBox = new JComboBox<String>(list);
		colorsBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				color = getColor((String) colorsBox.getSelectedItem());
				canvas.setColor(color);
			}

		});
		colorsBox.setBackground(Color.WHITE);
		this.options = new JPanel();
		options.setLayout(new BoxLayout(options, BoxLayout.PAGE_AXIS));
		this.colorPanel = new JPanel(new FlowLayout());
		colorLabel = new JLabel("Color");
		colorPanel.add(colorLabel);
		colorPanel.add(colorsBox);
	
		toolPanel = new JPanel(new FlowLayout());
		toolLabel = new JLabel("Tool");
		toolPanel.add(toolLabel);
		String[] toolList = { "Pencil", "Rectangle" };
		toolBox = new JComboBox<String>(toolList);
		toolBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tool = (String) toolBox.getSelectedItem();
				canvas.setTool(tool);
			}

		});
		toolPanel.add(toolBox);		
		options.add(colorPanel);
		options.add(toolPanel);
		add(options, BorderLayout.EAST);

	}

	private Color getColor(String selectedItem) {
		switch (selectedItem) {
		case "Red":
			return Color.RED;
		case "Orange":
			return Color.ORANGE;
		case "Yellow":
			return Color.YELLOW;
		case "Green":
			return Color.GREEN;
		case "Blue":
			return Color.BLUE;
		case "Black":
			return Color.BLACK;
		case "Gray":
			return Color.GRAY;
		case "Pink":
			return Color.PINK;
		default:
			return Color.BLACK;
		}
	}

}
