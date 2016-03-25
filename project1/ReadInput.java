package project1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/*Matthew LaClair
 *CMSC 330 - Project 1
 */


public class ReadInput {
	
	String token;
	String windowName;
	int window, panel, textWidth;
	int wWidth, wHeight;
	int rows, columns, hGaps, vGaps;
	ArrayList<String> radios;
	ArrayList<String> tokens;
	ArrayList<String> buttons;
	ArrayList<String> labels;
	
	ReadInput() throws Exception {
		tokens = new ArrayList<String>();
		buttons = new ArrayList<String>();
		labels = new ArrayList<String>();
		radios = new ArrayList<String>();
		
		//Read input file
		File file = new File("input.txt");
		Scanner input = new Scanner(file);
		while(input.hasNext()) {
			tokens.add(input.next());
		}
		
		
		//File is read through until End is found
		if (!(tokens.isEmpty())) {
			for (int i = 0; i < tokens.size();i++){	
				token = tokens.get(i); 
				if (token.equals("End;") && tokens.get(i++).equals("End.")){
					break;
				}
				
				//If window is found, create window
				else if (token.equals("Window")) {
						token = tokens.get(i+1);
						token = token.replaceAll("\"", "");
						windowName = token;
						token = tokens.get(i+2);
						windowSize(token);
						token = tokens.get(i+3);
						
						//If layout is found, figure out which layout to use; return to next token
						if (token.equals("Layout")) {
							while (!token.contains(":")) {
								token = tokens.get(i+4);
								if (token.contains("Flow")) {
									window = 0;				    		
								} else if (token.equals("Grid")) {
									panel = 1;
									token = tokens.get(i+5);
					    			grid(token);
								}	
							}
						}
						
					//Create textfield if found
					} else if (token.equals("TextField")) {
						while (!token.contains(";")) {
							token = tokens.get(i+1);
							token = token.replace(";", "");
							textWidth = Integer.valueOf(token);
							token = token.replace("", ";");
						}
					
					//If panel is found, figure out which layout to use; return to next token 
					} else if (token.equals("Panel")) {
						token = tokens.get(i+2);
							if (token.contains("Flow")) {
								panel = 0;
							} else if (token.contains("Grid")) {
								panel = 1;
								grid(token);
							}
							
					//Create button if found
					} else if (token.equals("Button")) {
						while (!token.contains(";")) {
							token = tokens.get(i+1);
							buttons.add(token.replaceAll("\"|;",""));
						}
						
					//Create label if found
					} else if (token.equals("Label")) {
						while (!token.contains(";")) {
							token = tokens.get(i+1);
							labels.add(token.replaceAll("\"|;",""));
						}
					
					//Create radio group if found
					} else if (token.equals("Group")) {
						token = tokens.get(i+1);
						while (!token.contains(";")) {
							token = tokens.get(i+1);
							radios.add(token.replaceAll("\"|;",""));
						}
					}
		    	}
			}
			input.close();

		}
	
	//Create window from input
	public void windowSize(String input) {
    	input = input.replaceAll("\\(", "");
    	input = input.replaceAll("\\)", "");
    	input = input.replaceAll(";", "");
    	String [] temp;
    	String delimiter = ",";
    	temp = input.split(delimiter);
		wWidth = Integer.valueOf(temp[0]);
		wHeight = Integer.valueOf(temp[1]);
		}
	
	//Create grid from input
	public void grid(String input) {
    	input = input.replaceAll("Grid", "");
    	input = input.replaceAll("\\(", "");
    	input = input.replaceAll("\\)", "");
    	input = input.replaceAll(";", "");
    	String [] temp;
    	String delimiter = ",";
    	temp = input.split(delimiter);
    	rows = Integer.valueOf(temp[0]);
    	columns = Integer.valueOf(temp[1]);
    	hGaps = Integer.valueOf(temp[2]);
    	vGaps = Integer.valueOf(temp[3]);
	}
	
	public int numRows() {
		return rows;
	}
	
	public int numColumns() {
		return columns;
	}
	
	public int getHGaps() {
		return hGaps;
	}
	
	public int getVGaps() {
		return vGaps;
	}
	
	public int width() {
		return wWidth;
	}
	
	public int height() {
		return wHeight;
	}
	
	public String title() {
		return windowName;
	}
	public int windowLayout() {
		return window;
	}
	
	public int panelLayout() {
		return panel;
	}
	
	public int textWidth() {
		return textWidth;
	}
	
	public ArrayList<String> radioList() {
		return radios;
	}
	
	public ArrayList<String> buttonList() {
		return buttons;
	}
	
	public ArrayList<String> labelList() {
		return labels;
	}
	
}