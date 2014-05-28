import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel Label;
	private JLabel user1;
	private JButton button;
	private JButton button2;
	
	public Main()	{
		setLayout(new FlowLayout());
		final Checkbox check1 = new Checkbox("8h sleep");
		final Checkbox check2 = new Checkbox("regular eating");
		final Checkbox check3 = new Checkbox("fun with friends");
		final Checkbox check4 = new Checkbox("alcohol");
		final Checkbox check5 = new Checkbox("cigarets");
		final Checkbox check6 = new Checkbox("sweets");
		final Checkbox check7 = new Checkbox("play on computer/consol");
		final Checkbox check8 = new Checkbox("play outside");
		Label = new JLabel("Do you want to feel good? :)");
		add(Label);
		user1 = new JLabel("User name:");
		add(user1);
		final String nazwa = "User";
		final JTextField user = new JTextField(nazwa , 16);
		add(user);
		setLayout(new GridLayout(16, 1));
		add(check1);
		add(check2);
		add(check3);
		add(check4);
		add(check5);
		add(check6);
		add(check7);
		add(check8);
		final String ocena = "";
		final JTextField text = new JTextField(ocena , 2);
		add(new JLabel("Your mood from 1 to 5"));
		add(text);
		
		final JLabel res = new JLabel();
		add(res);
		button = new JButton("Check!");
		add(button);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileManagment fm = new FileManagment();
				String save = String.valueOf(check1.getState())+","+String.valueOf(check2.getState())+","+String.valueOf(check3.getState())+","+String.valueOf(check4.getState())+","+String.valueOf(check5.getState())+","+String.valueOf(check6.getState())+","+String.valueOf(check7.getState())+","+String.valueOf(check8.getState());
				fm.addNewDayToDocument("test", save);
				ClassifierWrapper cw = new ClassifierWrapper();
				try {
					res.setText(String.valueOf(cw.start(user.getText())));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		button2 = new JButton("Save");
		add(button2);
		button2.setEnabled(false);
		text.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				warn();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				warn();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				warn();
			}
			
			public void warn(){
				try{
				if(Integer.parseInt(text.getText()) > 0 && Integer.parseInt(text.getText()) < 6)
					button2.setEnabled(true);
				else
					button2.setEnabled(false);
				}
				catch (Exception e){
					button2.setEnabled(false);
				}
			}
			
		});
		Document document = user.getDocument();
		document.addDocumentListener(new JButtonStateController(button2));		/* dzia³a */
		button2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

					
				// TODO Auto-generated method stub
				String save = String.valueOf(check1.getState())+","+String.valueOf(check2.getState())+","+String.valueOf(check3.getState())+","+String.valueOf(check4.getState())+","+String.valueOf(check5.getState())+","+String.valueOf(check6.getState())+","+String.valueOf(check7.getState())+","+String.valueOf(check8.getState())+","+text.getText();
				FileManagment fm = new FileManagment();
				fm.addNewDayToDocument(user.getText(), save);
			}
			
		});
	}
	
	public static void main (String args[]){
		Main gui = new Main();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(640, 480);
		gui.setVisible(true);
		gui.setTitle("Gui");
	}
}
