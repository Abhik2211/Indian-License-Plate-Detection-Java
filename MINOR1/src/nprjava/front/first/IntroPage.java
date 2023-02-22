package nprjava.front.first;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import nprjava.front.second.UserInterface;

import javax.swing.*;
import java.awt.*;


/*  JFrame works like the main window where components like labels, 
 * buttons, textfields are added to create a GUI.
 */
@SuppressWarnings("serial")
public
class IntroPage extends JFrame {
	// default constructor
	public IntroPage() {
		
		/*The setDefaultCloseOperation() method is used to specify one of several options for the close button.
		*JFrame.EXIT_ON_CLOSE — Exit the application.
		*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 650);
		
		//getContentPane() component to retrieve the content layer and to add the objects to our frame. 
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        //The object of JLabel class is a component for placing text in a container. 
        //It is used to display a single line of read only text.
        
        JLabel background=new JLabel(new ImageIcon("D:\\IMG_20220805_001351.jpg"));
        Border blackline = BorderFactory.createLineBorder(Color.black);
        add(background);
        background.setBorder(blackline);
       
        //The setLayout(...) method allows you to set the layout of the container,
        //A LayoutManager called FlowLayout simply places components one after the other
        
        background.setLayout(new FlowLayout());
        JLabel l1 = new JLabel("<html><font color='white'>Welcome! To our vehicle plate Recognition System </font></html>");
        background.add(l1);
        
        
        // jpanel: It provides space in which an application can attach any other component.
        JPanel panel = new JPanel(); 
        JButton send = new JButton("Continue");
        
        //The Java ActionListener is notified whenever you click on the button or menu item. 
        //It is notified against ActionEvent. 
        //The ActionListener interface is found in java.awt.event package. 
        //It has only one method: actionPerformed().
        
        
        
        //The setVisible(true) method makes the frame appear on the screen.
        setVisible(true);
        send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInterface guiobj = new UserInterface();
				guiobj.GUIApp();
				dispose();
			}
		});
        panel.add(send);
        getContentPane().add(BorderLayout.SOUTH, panel);
	}
}