package nprjava.front.second;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Canvas;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static javax.swing.GroupLayout.Alignment.*; 
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import nprjava.front.sixth.ThresholdDisplay;
import nprjava.front.third.ConnectionForming;
import nprjava.front.fifth.EdgeDetectedDisplay;
import nprjava.front.fourth.GrayscaleDisplay;
import nprjava.front.seventh.OriginalDisplay;


@SuppressWarnings("serial")
public class UI extends JFrame implements ActionListener{
	 
	static Connection con=null;
//	static ResultSet rs=null;
	static PreparedStatement pst=null;
	
	public void profile_matching(String input) {
		   try {
			   con= ConnectionForming.connect();
			   
			   Statement st = con.createStatement();
			   Boolean b = st.execute("select * from criminal_database where LicensePlate='"+ input+"'");
			   ResultSet rs = st.getResultSet();
			   
//				   if(rs.next()) {
//						System.out.println("License Plate Number : "+rs.getString(1));
//						System.out.println("Owner's Name : "+rs.getString(2));
//						System.out.println("Registration Date : "+rs.getString(3));
//						System.out.println("Vehicle Model : "+rs.getString(4));
//						System.out.println("Vehicle Color : "+rs.getString(5));
//					}
			   
			   if(rs.next()) {
					
					JLabel name = new JLabel("Owner's Name : " + rs.getString(2));
					JLabel date = new JLabel("Registration Date : " + rs.getString(3));
					JLabel model = new JLabel("Vehicle Model : " + rs.getString(4));
					JLabel color = new JLabel("Vehicle Color : " + rs.getString(5));
				   
					
		            
		            name.setHorizontalAlignment(SwingConstants.CENTER); 
		            name.setVerticalAlignment(SwingConstants.CENTER);
		            name.setLocation(200, 200);
		            
		            date.setHorizontalAlignment(SwingConstants.CENTER); 
		            date.setVerticalAlignment(SwingConstants.CENTER);
		            date.setLocation(300, 300);
		            
		            model.setHorizontalAlignment(SwingConstants.CENTER); 
		            model.setVerticalAlignment(SwingConstants.CENTER);
		            model.setLocation(400, 400);
		            
		            color.setHorizontalAlignment(SwingConstants.CENTER); 
		            color.setVerticalAlignment(SwingConstants.CENTER);
		            color.setLocation(500, 500);
		            
		            
		            add(name);
		            add(date);
		            add(model);
		            add(color);
		            
		            this.setSize(700,700);
		            setVisible(true);
			   }
				
			   if(input.equals(rs.getString("LicensePlate"))) {
				JOptionPane.showMessageDialog(null, "Person invloved in crime");
				dispose();
				}
			   
			   
			   
			   else{
				JOptionPane.showMessageDialog(null, "Person not invloved in crime");
				dispose();
				}
		   	}
		   catch(Exception e){
			   JOptionPane.showMessageDialog(null, "Person not involved in crime");
		   } 
	}
	

	JButton b;
	JLabel l,m;
	
	public void GUIApp(){
		
//		m=new JLabel("");
		b=new JButton();
		getContentPane().setBackground(Color.LIGHT_GRAY);
//		add(m);

				
		JPanel panel = new JPanel(); 
//		panel.setLayout(null);
		panel.setBounds(60, 400, 220, 30);
		
		JButton send0 = new JButton("Attach Image");
		send0.setBounds(480, 480, 200, 100);
		
		JButton send = new JButton("Grayscaled Image");
		send.setBounds(500, 500, 200, 100);

        JButton send1 = new JButton("Edge Detected Image");
        send1.setBounds(520, 520, 200, 100);
        
        JButton send2 = new JButton("Thresholded Image");
        send2.setBounds(540, 540, 2000, 100);
        
        send0.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new OriginalDisplay();
        		dispose();
        	}
        });
        
        send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GrayscaleDisplay();
				dispose();
			}
		});
        
        send1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EdgeDetectedDisplay();
				dispose();
			}
		});
        
        send2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ThresholdDisplay();
				dispose();
			}
		});
        
        panel.add(send0);
        panel.add(send);
        panel.add(send1);
        panel.add(send2);
        add(panel);

        getContentPane().add(BorderLayout.SOUTH, panel);
		 
		b.addActionListener(this);
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(600, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public String details_method() {
		JFileChooser chooser=new JFileChooser();
		chooser.showOpenDialog(null);
		File f=chooser.getSelectedFile();
		String filename=f.getAbsolutePath();
		
		Tesseract tesseract = new Tesseract();
		
		try {
			  
            tesseract.setDatapath("D:\\JAVA\\Tesseract\\Tess4J\\tessdata"); // Set the path for Tesseract
            // so that it can use the training data that is created.

            String output
                = tesseract.doOCR(new File(filename)); // Using the doOCR method and setting path
            // for the file.
            
            output = output.replaceAll("\\s", ""); // Removing any whitespaces from the extracted output
            
            JLabel number = new JLabel("License Plate Number : " + output);
            number.setHorizontalAlignment(SwingConstants.CENTER); 
            number.setVerticalAlignment(SwingConstants.CENTER);
            number.setLocation(100, 100);
            add(number);
            
//            System.out.println("\n\nLicense Plate Number : "+output+"\n\n");
            
            profile_matching(output); // Passing output so that it can be matched in database.
            
        }
        catch (TesseractException e) {
            e.printStackTrace();
        }
		

		return filename;
	}
}


