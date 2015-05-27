package sendrovitz.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {
	private JComboBox<String> colorsBox;
	private JPanel options;
	private JPanel colorPanel;
	private JLabel colorLabel;
	private Color color;
	private JPanel toolPanel;
	private JLabel toolLabel;
	private ModeButton pencil;
	private ModeButton rectangle;
	private Canvas canvas;

	public PaintFrame() {
		setSize(800, 650);
		setTitle("CANVAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(550, 10);
		setLayout(new BorderLayout());

		color = Color.BLACK;
		canvas = new Canvas(600, 600, color);
		add(canvas, BorderLayout.CENTER);

		String[] list = { "Black", "Red", "Orange", "Yellow", "Green", "Blue", "Gray", "Pink", "White" };
		this.colorsBox = new JComboBox<String>(list);

	
		pencil = new ModeButton(new PencilListener(canvas));
		pencil.setText("Pencil");
		rectangle = new ModeButton(new RectangleListener(canvas));
		rectangle.setText("Rectangle");
		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				ModeButton button = (ModeButton) event.getSource();
				BrushListener listener = button.getListener();
				canvas.setBrushListener(listener);
				// these two methods tell the canvas who to notify when there is
				// motion
				
				
				MouseListener[] listener2 = canvas.getMouseListeners();
				if(listener2!=null){
					for(MouseListener l : listener2){
					canvas.removeMouseListener(l);
					}
				}
				canvas.addMouseListener(listener);
				MouseMotionListener[] listener3 = canvas.getMouseMotionListeners();
				if(listener3!=null){
					for(MouseMotionListener l : listener3){
						canvas.removeMouseMotionListener(l);
						}
				}
				canvas.addMouseMotionListener(listener);

			}

		};
		rectangle.addActionListener(actionListener);
		pencil.addActionListener(actionListener);

		colorsBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				color = getColor((String) colorsBox.getSelectedItem());
				canvas.setColor(color);
			}

		});
		colorsBox.setBackground(Color.WHITE);
		
		options = new JPanel();
		options.setLayout(new BoxLayout(options, BoxLayout.PAGE_AXIS));
		options.setBackground(Color.GRAY);
		colorPanel = new JPanel(new FlowLayout());
		colorLabel = new JLabel("Color");
		colorPanel.add(colorLabel);
		colorPanel.add(colorsBox);

		toolPanel = new JPanel(new FlowLayout());
		toolLabel = new JLabel("Tool");
		toolPanel.add(toolLabel);
		toolPanel.add(pencil);
		toolPanel.add(rectangle);
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
		case "White":
			return Color.WHITE;
		default:
			return Color.BLACK;
		}
	}
	


}
