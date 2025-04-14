
package airlinemanagementsystem;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Cancel extends JFrame implements ActionListener {
    
    JTextField tfpnr;
    JLabel tfname, cancellationNo, lblflightcode,  labeldateoftravel;
    JButton fetchButton, flight;
        
    public Cancel(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random random = new Random();
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(180, 20, 250, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.png"));
        JLabel image = new JLabel(i2);
        image.setBounds(470, 100, 250, 250);
        add(image);
        
        //aadhar
        JLabel lblaadhar = new JLabel("PNR Number");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);
        
        //button
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.black);
        fetchButton.setForeground(Color.white);
        fetchButton.setBounds(400, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        //name
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
        //Cancellation
        JLabel lblcancellation = new JLabel("Cancellation");
        lblcancellation.setBounds(60, 180, 150, 25);
        lblcancellation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblcancellation);
        
        cancellationNo = new JLabel(""+random.nextInt(1000000));
        cancellationNo.setBounds(220, 180, 150, 25);
        add(cancellationNo);
        
        
        
        //flight code
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 230, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        lblflightcode = new JLabel();
        lblflightcode.setBounds(220, 230, 150, 25);
        add(lblflightcode);
        
        //date
        JLabel date = new JLabel("Date");
        date.setBounds(60, 280, 150, 25);
        date.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(date);
        
        labeldateoftravel = new JLabel();
        labeldateoftravel.setBounds(220, 280, 150, 25);       
        add( labeldateoftravel);
        
                        
        //button
        flight = new JButton("Cancel");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(220, 330, 120, 30);
        flight.addActionListener(this);
        add(flight);
                    
                    
        setSize(800, 450);
        setLocation(350, 150);
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
                    lblflightcode.setText(rs.getString("flightcode"));
                    labeldateoftravel.setText(rs.getString("ddate"));
                    
                    
                } else {
                     JOptionPane.showMessageDialog(null, "Please enter correct PNR");
                }

            } catch(Exception e) {

                e.printStackTrace();

                }
        }
        else if(ae.getSource() == flight) {
           
            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancelno = cancellationNo.getText();
            String fcode = lblflightcode.getText();
            String date = labeldateoftravel.getText();
                                                      
            try {
                Conn conn = new Conn();

                String query = "insert into cancel values('"+pnr+"', '"+name+"', '"+cancelno+"', '"+fcode+"', '"+date+"')";
                
                conn.s.executeUpdate(query);
                 
                conn.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
                
                JOptionPane.showMessageDialog(null, "Ticket Cancelled");
                setVisible(false);


            } catch(Exception e) {

                e.printStackTrace();

            }
        
        }
    }
    
    public static void main(String args[]) {
        new Cancel();
    }
    
}


