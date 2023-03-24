package com.mycompany.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelCover extends javax.swing.JPanel {
    
    private final DecimalFormat df = new DecimalFormat("##0.###",DecimalFormatSymbols.getInstance(Locale.US));
    private ActionListener event;
    private MigLayout layout;
    private JLabel title;
    private JLabel description;
    private JLabel description1;
    private JButton button;
    private boolean isLogin;
    
    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]25[]10[]25[]push");
        setLayout(layout);
        init();
    }
    private void init(){
        title = new JLabel("Welcome back!");
        title.setFont(new Font("sansserif",1,12));
        title.setForeground(Color.red);
        add(title);
        description = new JLabel("To keep connected with us please");
        description.setForeground(new Color(245,245,245));
        add(description);
         description1 = new JLabel("login with your personal info");
        description1.setForeground(new Color(245,245,245));
        add(description1);
        button = new JButton();
        button.setBackground(Color.gray);
        button.setForeground(Color.red);
        button.setText("SIGN IN");
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
           event.actionPerformed(ae);
            }
            
        });
        add(button,"w 60%, h 40");
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        GradientPaint gra = new GradientPaint(0, 0, new Color(50, 50, 50), 0, getHeight(), new Color(100, 100, 100));
        g2.setPaint(gra);
        g2.fillRect(0,0,getWidth(),getHeight());
        super.paintComponent(graphics); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    public void addEvent(ActionListener event){
        this.event = event;
    }
    public void registerLeft(double v){
        v=Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(title,"pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(description,"pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(description1,"pad 0 -"+v+"% 0 0");
    }
    public void registerRight(double v){
        v=Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(title,"pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(description,"pad 0 -"+v+"% 0 0");
        layout.setComponentConstraints(description1,"pad 0 -"+v+"% 0 0");
    }
    public void loginLeft(double v){
        v=Double.valueOf(df.format(v));
        login(true);
                layout.setComponentConstraints(title,"pad 0 "+v+"% 0 "+v+"%");
                layout.setComponentConstraints(description,"pad 0 "+v+"% 0 "+v+"%");
                layout.setComponentConstraints(description1,"pad 0 "+v+"% 0 "+v+"%");

    }
    public void loginRight(double v){
        v=Double.valueOf(df.format(v));
        login(true);
                layout.setComponentConstraints(title,"pad 0 "+v+"% 0 "+v+"%");
                layout.setComponentConstraints(description,"pad 0 "+v+"% 0 "+v+"%");
                layout.setComponentConstraints(description1,"pad 0 "+v+"% 0 "+v+"%");

    }
    private void login(boolean login){
        if(this.isLogin!=login){
            if(login){
                title.setText("hello, friend");
                description.setText("enter your personal details");
                description1.setText("and start journey with us");
            }else{
                title.setText("Welcome back!");
                description.setText("To keep connected with us please");
                description1.setText("login with your personal info");
            }
            this.isLogin=login;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
