//bla bla bla




import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Server extends JFrame implements ActionListener {
    JPanel p1;
    Server()
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
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/1.png"));
        Image i5 = i3.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i5);
        JLabel jl2 = new JLabel(i4);
        jl2.setBounds(40, 5, 60, 60);
        p1.add(jl2);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(450,700);
        setLocation(20, 20);
        setUndecorated(true);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){

    }
    public static void main(String[] args) throws Exception {
        new Server().setVisible(true);
        //System.out.println("Hello, World!");
    }
}