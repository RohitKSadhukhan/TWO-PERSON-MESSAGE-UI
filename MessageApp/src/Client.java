import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Client extends JFrame implements ActionListener {
    JPanel p1;
    JTextField t1;
    JButton b1;
    static JTextArea a1;
    
    static Socket skt;
    static DataInputStream din;
    static DataOutputStream dout;
    
    Client()
    {
        p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0, 0, 450, 70);
        add(p1);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/3.png")); 
        Image ig1=i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(ig1);
        JLabel jl1=new JLabel(i2);
        jl1.setBounds(5, 17, 30, 30);
       
        
        jl1.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent ae)
            {
               System.exit(0);
            }
        });
        p1.add(jl1);


        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/cat2.jpg"));
        Image i4 = i3.getImage().getScaledInstance(55, 55, Image.SCALE_DEFAULT);
        ImageIcon i5 = new ImageIcon(i4);
        JLabel jl2 = new JLabel(i5);
        jl2.setBounds(40, 10, 55, 55);
        p1.add(jl2);


        JLabel jl3=new JLabel("Bhaswata");
        jl3.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        jl3.setForeground(Color.WHITE);
        jl3.setBounds(100, 20, 100, 20);
        p1.add(jl3);


        JLabel jl4=new JLabel("Active Now");
        jl4.setFont(new Font("SAN_SERIF",Font.PLAIN,12));
        jl4.setForeground(Color.WHITE);
        jl4.setBounds(100, 40, 100, 20);
        p1.add(jl4);


        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("icon/video.png"));
        Image i7 = i6.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i8 = new ImageIcon(i7);
        JLabel jl5 = new JLabel(i8);
        jl5.setBounds(290, 20, 30, 30);
        p1.add(jl5);

        ImageIcon i9 = new ImageIcon(ClassLoader.getSystemResource("icon/phone.png"));
        Image i10 = i9.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        ImageIcon i11 = new ImageIcon(i10);
        JLabel jl6 = new JLabel(i11);
        jl6.setBounds(350, 20, 35, 30);
        p1.add(jl6);

        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("icon/3icon.png"));
        Image i13 = i12.getImage().getScaledInstance(12, 25, Image.SCALE_DEFAULT);
        ImageIcon i14 = new ImageIcon(i13);
        JLabel jl7 = new JLabel(i14);
        jl7.setBounds(410, 22, 12, 25);
        p1.add(jl7);

        a1=new JTextArea();
        a1.setBounds(5, 75, 440, 570);
        a1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        a1.setEditable(false);
        a1.setLineWrap(true);
        a1.setWrapStyleWord(true);
        
        add(a1);

        t1=new JTextField();
        t1.setBounds(5, 650, 320, 40);
        t1.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        add(t1);

        b1=new JButton("Send");
        b1.setBounds(330, 650, 100, 40);
        b1.setBackground(new Color(7,94,84));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        b1.addActionListener(this);
        add(b1);
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(450,700);
        setLocation(600, 20);
        setUndecorated(true);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
    	try {
	        String s=t1.getText();
	        //a1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	        a1.setText(a1.getText()+"\n"+s);
	        dout.writeUTF(s);
	        t1.setText("");
	        
    	}
    	catch (Exception e) {
    		
    	}
    }
    
    
    public static void main(String[] args) throws Exception {
    	try {
	        new Client().setVisible(true);
	        skt = new Socket("localhost",5000);
	        din = new DataInputStream(skt.getInputStream());
	        dout = new DataOutputStream(skt.getOutputStream());
	        while(true) {
		        //a1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		        String s = din.readUTF();
		        a1.setText(a1.getText()+"\n Rohit : "+s);
	        }
    	}
    	catch(Exception e) {
    		
    	}
    	finally {
    		skt.close();
    	}
        
    }
}


