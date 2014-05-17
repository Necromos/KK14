import javax.swing.JFrame;
public class Main extends JFrame {
	public static void main (String args[]){
		Main gui = new Main();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(300, 300);
		gui.setVisible(true);
		gui.setTitle("Gui");
	}
}
