import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class WelcomeScreen extends JFrame{

		/*
		 * default constructor sets the JFrame specifications
		 */
		public WelcomeScreen(){
			
		//	gameItems currentBoard = new gameItems();
			setJframeSettings();
			//teacherButton();
			//studentButton();
			setButtons();
			//exitButton();  //adds exit button to JFrame();
			//restartButton();
		}

		/*
		 * specifications for the JFrame
		 */
		private void setJframeSettings() { 
			setPreferredSize(new Dimension(1000, 1000));
			//getContentPane().add(new gameItems(), BorderLayout.NORTH);  //adds the JPanel to the JFrame
			setTitle("Welcome!");  //set the title
			pack();
			setResizable(false);  //otherwise the spacing is thrown off
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		private void setButtons(){
			JPanel One = studentButton();
			JPanel Two = teacherButton();
			JPanel Combine = new JPanel();
			
			Combine.setLayout(new GridLayout(2,1));
	        Combine.add(One);
	        Combine.add(Two);
			getContentPane().add(Combine, BorderLayout.CENTER);
		}
		
		private JPanel teacherButton(){
			final JButton teacher = new JButton();
			teacher.setFocusable(false); //this way the game can't get stuck on this after a reset
			teacher.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
				  	JFrame gameRestart = new TeacherScreen();
				  	gameRestart.setVisible(true);
			    	}
				});
			teacher.setText("Teacher");
			teacher.setVisible(true);
			
			JPanel bottomHalf = new JPanel();
			bottomHalf.setBackground(Color.MAGENTA);
			bottomHalf.add(teacher);
			return bottomHalf;
			//getContentPane().add(bottomHalf, BorderLayout.PAGE_END);
			
		
		}
		
		private JPanel studentButton(){
			final JButton student = new JButton();
			student.setFocusable(false); //this way the game can't get stuck on this after a reset
			student.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
				  	JFrame studentSelection = new StudentScreen();
				  	studentSelection.setVisible(true);
			    	}
				});
		
			student.setText("Student");
			student.setVisible(true);
			
			JPanel topHalf = new JPanel();
			topHalf.setSize(500, 500);
			topHalf.setBackground(Color.GREEN);
			topHalf.add(student);
			return topHalf;
			//getContentPane().add(topHalf, BorderLayout.PAGE_START);
		
		}
		
		/*
		* restart button.  Calls gameItems to reset the board
		*/	
		private void restartButton(){
			final JButton restart = new JButton();
			restart.setFocusable(false); //this way the game can't get stuck on this after a reset
			restart.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
				  	JFrame gameRestart = new WelcomeScreen();
				  	gameRestart.setVisible(true);
			    	}
				});
					restart.setText("Restart");
			restart.setVisible(true);
			getContentPane().add(restart, BorderLayout.PAGE_END);
		}
		
		/*
		 * Exit button.  On click closes the whole frame
		 */
		
		private void exitButton(){
			
			final JButton exit = new JButton();
			exit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
				  	System.exit(0);
			    	}
				});
					exit.setText("Exit");
			exit.setVisible(true);
			getContentPane().add(exit, BorderLayout.PAGE_END);
		
		}
		
		/*
		 * main() calls a thread that animates the game
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable(){
				@Override
				public void run(){
					JFrame game = new WelcomeScreen();
					game.setVisible(true);//want to see what is happening
				}
			});

		}
	}
