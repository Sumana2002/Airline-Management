
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
    
    JTextField tfname, tfnationality, tfaddress, tfaadhar, tfphone;
    JRadioButton rbmale, rbfemale;
    
    public AddCustomer() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(250, 20, 500, 35);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 34));
        add(heading);
        
        //name
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(80, 80, 150,25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 80, 180, 25);
        add(tfname);
        
        //nationality
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(80, 130, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220, 130, 180, 25);
        add(tfnationality);
        
        //aadhar
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(80, 180, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 180, 180, 25);
        add(tfaadhar);
        
        //address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(80, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 180, 25);
        add(tfaddress);
        
        //gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(80, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblgender);
        
        //radio button
        ButtonGroup gendergroup = new ButtonGroup();
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 280, 70, 25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 280, 70, 25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        //phone no.
        JLabel lblphone = new JLabel("phone No.");
        lblphone.setBounds(80, 330, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 180, 25);
        add(tfphone);
        
        //save
        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(150, 400, 150, 30);
        
        save.addActionListener(this);
        add(save);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 80, 280, 400);
        add(lblimage);
        
        
        
        
        setSize(900, 600);
        setLocation(300, 100);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;
        if(rbmale.isSelected()){
            gender = "Male";
        } else {
            gender = "female";
        }
        
        try {
            Conn conn = new Conn();
            
            String query = "insert into passenger values('"+name+"', '"+nationality+"','"+phone+"', '"+address+"', '"+aadhar+"', '"+gender+"')";
           
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customar Details added Successfully!");
            
            setVisible(false);
            
        } catch(Exception e) {
            
            e.printStackTrace();
            
            }
    }
    
    public static void main(String args[]) {
        new AddCustomer();
    }
    
}
