
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BoardingPass extends JFrame implements ActionListener {
    
    JTextField tfpnr;
    JLabel tfname, tfnationality, lblsrc , lbldest, labelfname, labelfcode, labeldate;
    JButton  fetchButton;
         
    public BoardingPass() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(430, 10, 450, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
        
        JLabel subheading = new JLabel("Boarind Pass");
        subheading.setBounds(435, 50, 300, 30);
        subheading.setForeground(Color.BLUE);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(subheading);
        
        //pnr
        JLabel lblpnr = new JLabel("PNR DETAILS");
        lblpnr.setBounds(60, 100, 150, 25);
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpnr);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);
        
        //button
        fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.black);
        fetchButton.setForeground(Color.white);
        fetchButton.setBounds(400, 100, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        //name
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 140, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        add(tfname);
        
        //nationality
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
        
        
        JLabel lblsource = new JLabel("SRC");
        lblsource.setBounds(60, 220, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);
        
        lblsrc = new JLabel();
        lblsrc.setBounds(220, 220, 150, 25);
        add(lblsrc );
        
        //des
        JLabel dest = new JLabel("DEST");
        dest.setBounds(380, 220, 150, 25);
        dest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(dest);
        
        lbldest = new JLabel();
        lbldest.setBounds(540, 220, 150, 25);       
        add(lbldest);
                  
     
        JLabel lblfname = new JLabel("FLIGHT NAME");
        lblfname.setBounds(60, 260, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 260, 150, 25);
        add(labelfname);
        
                    
        //flight code
        JLabel lblfcode = new JLabel("FLIGHT CODE");
        lblfcode.setBounds(380, 260, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(540, 260, 150, 25);
        add(labelfcode);
        
        //date of flight
        JLabel lbldate = new JLabel("DATE");
        lbldate.setBounds(60, 300, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        labeldate = new JLabel();
        labeldate.setBounds(220, 300, 150, 25);
        add(labeldate);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 80, 300, 300);
        add(lblimage);
        
       
        
        
        setSize(1000, 450);
        setLocation(300, 150);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == fetchButton) {
           
            String pnr = tfpnr.getText();
          
            try {
                Conn conn = new Conn();

                String query = "select * from reservation where PNR = '"+pnr+"'";
                
                ResultSet rs = conn.s.executeQuery(query);
                
                if(rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfnationality.setText(rs.getString("nationality"));
                    lblsrc.setText(rs.getString("src"));
                    lbldest.setText(rs.getString("des"));
                    labelfname.setText(rs.getString("flightname"));
                    labelfcode.setText(rs.getString("flightcode"));
                    labeldate.setText(rs.getString("ddate"));
                    
                    } else {
                     JOptionPane.showMessageDialog(null, "Please enter correct PNR");
                }


            } catch(Exception e) {

                e.printStackTrace();
            }
        }
        
    }
    
    public static void main(String args[]) {
        new BoardingPass();
    }
    
}

