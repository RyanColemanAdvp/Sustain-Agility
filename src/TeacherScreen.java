import java.awt.Dimension;

import javax.swing.JFrame;


@SuppressWarnings("serial")
public class TeacherScreen extends JFrame{
	
	public TeacherScreen(){
		setJFrameSettings();
	}
	
	private void setJFrameSettings() { 
		setPreferredSize(new Dimension(1000, 1000));
		//getContentPane().add(new gameItems(), BorderLayout.NORTH);  //adds the JPanel to the JFrame
		setTitle("Teacher Screen");  //set the title
		pack();
		setResizable(false);  //otherwise the spacing is thrown off
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}