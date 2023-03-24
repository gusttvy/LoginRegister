package com.mycompany.component;

import com.mycompany.model.ModelUser;
import com.mycompany.swing.PlaceholderPasswordField;
import com.mycompany.swing.PlaceholderTextField;
import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class PanelLoginAndRegister extends javax.swing.JLayeredPane {

    /**
     * @return the user
     */
    public ModelUser getUser() {
        return user;
    }
    
   private ModelUser user;
    public PanelLoginAndRegister(ActionListener eventRegister) {
        initComponents();
        initRegister(eventRegister);
        initLogin();
        login.setVisible(false);
        register.setVisible(true);
        
          
    }

    private void initRegister(ActionListener eventRegister){
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Create account");
        label.setFont(new Font("sansserif",1 ,30 ));
        label.setForeground(new Color(7, 164, 121));
        register.add(label);
        PlaceholderTextField txtUser = new PlaceholderTextField();
        txtUser.setPlaceholder("Nome");
        register.add(txtUser,"w 60%");
        PlaceholderTextField txtMail = new PlaceholderTextField();
        txtMail.setPlaceholder("Email");
        register.add(txtMail,"w 60%");
        PlaceholderPasswordField txtPass = new PlaceholderPasswordField();
        txtPass.setPlaceholder("Password");
        register.add(txtPass,"w 60%");
        JButton cmd = new JButton();
        cmd.setBackground(Color.LIGHT_GRAY);
        cmd.setForeground(Color.darkGray);
        cmd.addActionListener(eventRegister);
        cmd.setText("SIGN UP");
        register.add(cmd,"w 40%, h 40");
        cmd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
           String userName = txtUser.getText().trim();
           String userMail = txtMail.getText().trim();
           String password = String.valueOf(txtPass.getPassword());
           user = new ModelUser(0, userName, userMail, password);
            }
            
        });
    }
    private void initLogin(){
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif",1 ,30 ));
        label.setForeground(new Color(7, 164, 121));
        login.add(label);
         PlaceholderTextField txtMail = new PlaceholderTextField();
        txtMail.setPlaceholder("Email");
        login.add(txtMail,"w 60%");
        PlaceholderPasswordField txtPass = new PlaceholderPasswordField();
        txtPass.setPlaceholder("Password");
        login.add(txtPass,"w 60%");
        JButton cmdForget = new JButton("Forgot your password?");
        cmdForget.setForeground(Color.darkGray);
        cmdForget.setFont(new Font("sansserif", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        login.add(cmdForget);
        JButton cmd = new JButton();
        cmd.setBackground(Color.LIGHT_GRAY);
        cmd.setForeground(Color.darkGray);
        cmd.setText("SIGN IN");
        login.add(cmd,"w 40%, h 40");
    }
    public void showRegister(boolean show){
        if(show){
            register.setVisible(true);
            login.setVisible(false);
        }else{
            register.setVisible(false);
            login.setVisible(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
