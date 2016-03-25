package project1;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*Matthew LaClair
 *CMSC 330 - Project 1
 */

public class CreateGui implements ActionListener {
	
	JFrame frame;
	JPanel textPanel, buttonPanel, radioPanel, labelPanel;
	Container container;
	JTextField textField;
	static ArrayList<JButton> button;
	static ArrayList<JLabel> label;
	static ArrayList<JRadioButton> radio;
	static ReadInput readInput;
	
	public static void main(String[] args) throws Exception {
		
		//Creates an instance of ReadInput & arraylist
		readInput = new ReadInput();
		button = new ArrayList<JButton>();
		label = new ArrayList<JLabel>();		
		radio = new ArrayList<JRadioButton>();
		
		//Creates an instance of GUI creator and calls display method
		CreateGui createGui = new CreateGui();
		createGui.display();
		
	}
	
	public void display() {
		
		//GUI is created
		frame = new JFrame();
		frame.setSize(readInput.width(),readInput.height());
		frame.setTitle(readInput.title());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		container = frame.getContentPane();
		container.setBackground(Color.black);
		
		//Sets flow layout
		if (readInput.windowLayout() == 0) { 
			container.setLayout(new FlowLayout());
		} else {
		//Sets grid layout
			container.setLayout(new GridLayout(readInput.numRows(),readInput.numColumns(), readInput.getHGaps(),readInput.getVGaps()));
		}
		
		//Create panels
		buttonPanel = new JPanel();
		textPanel = new JPanel();
		labelPanel = new JPanel();
		radioPanel = new JPanel();
		
		//Figure out which layout is being used
		
		//Flow layout
		if (readInput.panelLayout() == 0) {
			textPanel.setLayout(new FlowLayout());
			buttonPanel.setLayout(new FlowLayout());
			radioPanel.setLayout(new FlowLayout());
			
		//Grid layout
		} else {
			textPanel.setLayout(new GridLayout	(readInput.numRows(),readInput.numColumns(),readInput.getHGaps(),readInput.getVGaps()));
			buttonPanel.setLayout(new GridLayout(readInput.numRows(),readInput.numColumns(),readInput.getHGaps(),readInput.getVGaps()));
			radioPanel.setLayout(new GridLayout (readInput.numRows(),readInput.numColumns(),readInput.getHGaps(),readInput.getVGaps()));
			labelPanel.setLayout(new GridLayout	(readInput.numRows(),readInput.numColumns(),readInput.getHGaps(),readInput.getVGaps()));
			}
		
		//Create text field and set width
		textField = new JTextField("", readInput.textWidth());
		container.add(textField);
		textPanel.add(textField);
		textPanel.setBackground(Color.black);
		
		//Create radio buttons
		int i = 0;
		ArrayList <String> tempRadio = readInput.radioList();
		while (i < tempRadio.size()) {
			radio.add(new JRadioButton(tempRadio.get(i)));
			container.add(radio.get(i));
			radioPanel.add(radio.get(i));
			i++;
		}

		//Create buttons
		ArrayList <String> tempButton = readInput.buttonList();
		i = 0;
		while(i < tempButton.size()){
			button.add(new JButton(tempButton.get(i)));
			container.add(button.get(i));
			buttonPanel.add(button.get(i));
			buttonPanel.setBackground(Color.black);
			i++;
		}

		//Create labels
		i = 0;
		ArrayList <String> tempLabel = readInput.labelList();
		while (i < tempLabel.size()) {
			label.add(new JLabel(tempLabel.get(i)));
			container.add(label.get(i));
			labelPanel.add(label.get(i));
			i++;
		}
		
		//Add panels to frame
		frame.add(textPanel);
		frame.add(buttonPanel);
		frame.add(radioPanel);
		frame.setVisible(true);
		
	}
	
	//Event handler
	public void actionPerformed( ActionEvent action ) {}
}