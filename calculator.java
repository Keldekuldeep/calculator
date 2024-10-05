import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.script.*;

import java.io.File;
import javax.sound.sampled.*;
import java.io.IOException;

class FDemo extends JFrame implements ActionListener
{
	JTextField tx1;
	JButton b1[]=new JButton[20];
	int k=0;
	String s[]={"B","C","1/x","sqrt","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
	FDemo()
	{
		Font f=new Font("Brush Script MT",Font.BOLD,25);
		setFont(f);
		
		setLayout(null);
		
	    int x=40;
		int y=150;
		int w=80;
		int h=80;
		
		tx1=new JTextField(10);
		tx1.setSize(320,100);
		tx1.setLocation(40,50);
		tx1.setFont(f);
		tx1.setBackground(Color.LIGHT_GRAY);
		tx1.setHorizontalAlignment(JTextField.RIGHT);
		add(tx1);
		int s1=0;
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<4;j++)
			{
		     b1[k]=new JButton(s[s1++]);
	       	 b1[k].setSize(w,h);
	    	 b1[k].setLocation(x,y);
		     b1[k].setBackground(Color.DARK_GRAY);
			  b1[k].setForeground(Color.white);
			 add(b1[k]);
	     	 b1[k].addActionListener(this);
			 x+=80;
			 k++;
			 }	
            x=40;
            y+=80;			
		}
	}
	
	public void actionPerformed (ActionEvent e)
	{
				
		if(e.getSource()==b1[0])
		{
			// b1[0].setBackground(Color.red);
			 String s1 =tx1.getText();
			 tx1.setText(s1.substring(0,s1.length()-1));
	    }
		else if(e.getSource()==b1[1])
		{
			tx1.setText(" ");
		}
	    else if(e.getSource()==b1[2])
		{
			String s1=tx1.getText();
			double a =Double.parseDouble(s1);
			a=1/a;
			tx1.setText(""+a);
		}
	    else if(e.getSource()==b1[3])
		{
			String s1=tx1.getText();
			double a =Double.parseDouble(s1);
			tx1.setText(""+Math.sqrt(a));
		}
	    else if(e.getSource()==b1[18])
		{
			String s1=tx1.getText();
			ScriptEngineManager sem=new ScriptEngineManager();
			ScriptEngine se= sem.getEngineByName("js");
			
			try
			{
				tx1.setText(""+se.eval(s1));
				
			}
			catch(Exception exc)
			{}
		}
	    else
		{
		JButton b1=(JButton) e.getSource();
		String s5 =tx1.getText()+b1.getLabel();
		tx1.setText(s5);
	    }
		
		
		
		
		/*--------------Button_Sound---------------*/
		
		try {
            File soundFile = new File("C:/Users/manishpc/OneDrive/Desktop/java_calc/click.wav");//sound_file_path
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error playing sound: " + ex.getMessage());
        }
		
    }
}
class calculator 
{
	public static void main (String ar[])
	{
		FDemo f=new FDemo();
		f.setVisible(true);
		f.setSize(400,600);
		f.setLocation(100,100);
		f.setBackground(Color.BLACK);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		// f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);	
	}
}