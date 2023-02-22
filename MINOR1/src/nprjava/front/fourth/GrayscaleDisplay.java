package nprjava.front.fourth;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nprjava.front.second.UserInterface;

class transformed_image {

	public transformed_image(){
		GrayscaleDisplay obj=new GrayscaleDisplay();
	}
}
@SuppressWarnings("serial")
public
class GrayscaleDisplay extends JFrame {
	public GrayscaleDisplay(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        
        
        JLabel background=new JLabel(new ImageIcon("D:\\JAVA\\Images\\Gray\\gray.png"));
        
        add(background);
        background.setLayout(new FlowLayout(FlowLayout.LEFT, 300, 100));
        JPanel panel = new JPanel();     
        JButton back = new JButton("Back");
        final UserInterface guiob = new UserInterface();
               
               back.addActionListener(new ActionListener() {
       			public void actionPerformed(ActionEvent e) {
       				guiob.GUIApp();
       				dispose();
       			}
       		});
               panel.add(back);
               getContentPane().add(BorderLayout.SOUTH, panel);
        setVisible(true);
	}
}
