package nprjava.front.seventh;

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
		OriginalDisplay obj=new OriginalDisplay();
	}
}
@SuppressWarnings("serial")
public
class OriginalDisplay extends JFrame {
	public String OriginalDisplay(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 750);
        final UserInterface guiob = new UserInterface();
        String img = guiob.details_method();
        JLabel background=new JLabel(new ImageIcon(img));
        add(background);
        background.setLayout(new GridLayout());
        JPanel panel = new JPanel();     
        JButton back = new JButton("Back");
                
               
               back.addActionListener(new ActionListener() {
       			public void actionPerformed(ActionEvent e) {
       				guiob.GUIApp();
       				dispose();
       			}
       		});
               panel.add(back);
               getContentPane().add(BorderLayout.SOUTH, panel);
        setVisible(true);
		return img;
	}
}
