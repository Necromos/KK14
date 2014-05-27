import java.awt.*;
import javax.swing.*;
public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel Label;
	private JButton button;
	
	public Main()	{
		setLayout(new FlowLayout());
		Label = new JLabel("Do you want to feel good? :)");
		add(Label);
		setLayout(new GridLayout(12, 1));
		add(new Checkbox("8h sleep"));
		add(new Checkbox("regular eating"));
		add(new Checkbox("fun with friends"));
		add(new Checkbox("alkohol"));
		add(new Checkbox("cigarets"));
		add(new Checkbox("sweets"));
		add(new Checkbox("play on computer/consol"));
		add(new Checkbox("play outside"));
		add(new JTextField("Coœ dodaæ?", 25));
		
		button = new JButton("Check!");
		add(button);
	}
	
	public static void main (String args[]){
		Main gui = new Main();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(640, 480);
		gui.setVisible(true);
		gui.setTitle("Gui");
	}
}
