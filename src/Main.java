import java.awt.*;
import javax.swing.*;
public class Main extends JFrame {
	private JLabel Label;
	private JButton button;
	
	public Main()	{
		setLayout(new FlowLayout());
		
		Label = new JLabel("Hi!");
		add(Label);
		setLayout(new GridLayout(6, 4));
		add(new Checkbox("one", null, true));
		add(new Checkbox("two"));
		add(new Checkbox("three"));
		add(new Checkbox("four"));
		
		button = new JButton("Check!");
		add(button);
	}
	
	public static void main (String args[]){
		Main gui = new Main();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(300, 300);
		gui.setVisible(true);
		gui.setTitle("Gui");
	}
}
