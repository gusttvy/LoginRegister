
package com.mycompany.component;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Message extends javax.swing.JPanel {

    private MessageType messageType = MessageType.SUCCESS;
    private boolean show;
    public Message() {
        initComponents();
        setOpaque(false);
        setVisible(false);
    }
    public void showMessage(MessageType messageType, String message){
        this.messageType=messageType;
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/com/mycompany/icon/148767.png"));
        Image image = imageIcon.getImage();
        Image newImg = image.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
        
        ImageIcon imageIcon1 = new ImageIcon(getClass().getResource("/com/mycompany/icon/error-icon-4.png"));
        Image image1 = imageIcon1.getImage();
        Image newImg1 = image1.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH);
        
        lbMessage.setText(message);
        if(messageType==MessageType.SUCCESS){
            lbMessage.setIcon(new ImageIcon(newImg));
        }else{
            lbMessage.setIcon(new ImageIcon(newImg1));
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbMessage = new javax.swing.JLabel();

        lbMessage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics graphic) {
        Graphics2D g2=(Graphics2D) graphic;
        if(messageType==MessageType.SUCCESS){
            g2.setColor(new Color(15,174,37));
        }else{
            g2.setColor(new Color(240,52,53));

        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.9f));
        g2.fillRect(0,0,getWidth(),getHeight());
        g2.setComposite(AlphaComposite.SrcOver);
        g2.setColor(new Color(245,245,245));
        g2.drawRect(0,0,getWidth()-1,getHeight()-1);
        super.paintComponent(graphic); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    public static enum MessageType{
        SUCCESS, ERROR
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbMessage;
    // End of variables declaration//GEN-END:variables
}
