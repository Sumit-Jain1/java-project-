import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class RegistrationForm implements ActionListener {
    JFrame frame;
    JLabel nameLabel=new JLabel("Full Name");
    JLabel regnoLabel=new JLabel("Reg. No.");
    JLabel bookNameLabel=new JLabel("Book Name");
    JLabel issuedDateLabel=new JLabel("Issued Date");
    JLabel returnDateLabel=new JLabel("Return Date");
    JLabel emailLabel=new JLabel("EMAIL");
    JTextField nameTF=new JTextField();
    JTextField regnoTF=new JTextField();
    JTextField bookNameTF=new JTextField();
    JTextField issuedDateTF=new JTextField();
    JTextField returnDateTF=new JTextField();
    JTextField emailTF=new JTextField();
    JButton resetButton=new JButton("RESET");
    JButton registerButton=new JButton("SUBMIT");
  

    RegistrationForm()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    
    public void createWindow()
    {
    	frame=new JFrame();
        frame.setTitle("Registration Form");
        frame.setBounds(40,40,380,600);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    
    public void setLocationAndSize()
    {
    	nameLabel.setBounds(20,20,40,70);
        regnoLabel.setBounds(20,70,80,70);
        bookNameLabel.setBounds(20,120,100,70);
        issuedDateLabel.setBounds(20,170,100,70);
        returnDateLabel.setBounds(20,220,140,70);
        emailLabel.setBounds(20,270,100,70);
        nameTF.setBounds(180,43,165,23);
        regnoTF.setBounds(180,93,165,23);
        bookNameTF.setBounds(180,143,165,23);
        issuedDateTF.setBounds(180,193,165,23);
        returnDateTF.setBounds(180,243,165,23);
        emailTF.setBounds(180,293,165,23);
        resetButton.setBounds(70,400,100,35);
        registerButton.setBounds(220,400,100,35);
    }
    
    public void addComponentsToFrame()
    {
        frame.add(nameLabel);
        frame.add(regnoLabel);
        frame.add(bookNameLabel);
        frame.add(issuedDateLabel);
        frame.add(returnDateLabel);
        frame.add(emailLabel);
        frame.add(nameTF);
        frame.add(regnoTF);
        frame.add(bookNameTF);
        frame.add(issuedDateTF);
        frame.add(returnDateTF);
        frame.add(emailTF);
        frame.add(registerButton);
        frame.add(resetButton);
    }
    
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerButton)
        {
            try {
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root");
                PreparedStatement Pstatement=connection.prepareStatement("insert into faculty values(?,?,?,?,?,?)");
                Pstatement.setString(1,nameTF.getText());
                Pstatement.setString(2,regnoTF.getText());
                Pstatement.setString(3,bookNameTF.getText());
                Pstatement.setString(4,issuedDateTF.getText());
                Pstatement.setString(5,returnDateTF.getText());
                Pstatement.setString(6,emailTF.getText());
                int i=Pstatement.executeUpdate();
                JOptionPane.showMessageDialog(null,"Thank You!");

            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        }
        if(e.getSource()==resetButton)
        {
        	nameTF.setText("");
            regnoTF.setText("");
            bookNameTF.setText("");
            issuedDateTF.setText("");
            returnDateTF.setText("");
            emailTF.setText("");
        }

    }
}