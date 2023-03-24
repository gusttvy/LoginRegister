package com.mycompany.main;
import com.mycompany.component.Message;
import com.mycompany.component.PanelCover;
import com.mycompany.component.PanelLoading;
import com.mycompany.component.PanelLoginAndRegister;
import com.mycompany.component.PanelVerifyCode;
import com.mycompany.model.ModelUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class Main extends javax.swing.JFrame {

   private MigLayout layout;
   private PanelCover cover;
   private PanelLoading loading;
   private PanelVerifyCode verifyCode;
   private PanelLoginAndRegister loginAndRegister;
   private boolean isLogin;
   private final double addSize=30;
   private final double coverSize=40;
   private final double loginSize =  60;
   private final DecimalFormat df = new DecimalFormat("##0.###",DecimalFormatSymbols.getInstance(Locale.US));
   
    public Main() {
        initComponents();
        init();
    }
    private void init(){
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        loading = new PanelLoading();
        verifyCode = new PanelVerifyCode();
        ActionListener eventRegister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            register();
            }
        };
        loginAndRegister = new PanelLoginAndRegister(eventRegister);
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
               double fractionCover;
               double fractionLogin;
               double size = coverSize;
               if(fraction<=0.5f){
                   size+=fraction*addSize;
               }else{
                   size+=addSize-fraction*addSize;
               }
                if(isLogin){
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if(fraction>=0.5f){
                        cover.registerRight(fractionCover*100);
                    }else{
                        cover.loginRight(fractionLogin*100);
                    }
                }else{
                     fractionCover = fraction;
                     fractionLogin = 1f - fraction;
                     if(fraction<=0.5f){
                        cover.registerLeft(fraction*100);
                    }else{
                        cover.loginLeft((1f-fraction)*100);
                    }
                }
                if(fraction>=0.5f){
                    loginAndRegister.showRegister(isLogin);
                }
                fractionCover=Double.valueOf(df.format(fractionCover));
                fractionLogin=Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover,"width " +size+"%, pos "+fractionCover+"0al 0 n 100%");
                layout.setComponentConstraints(loginAndRegister,"width " +loginSize+"%, pos "+fractionLogin+"0al 0 n 100%");

                background.revalidate();
           }

            @Override
            public void end() {
                isLogin = !isLogin;
            }
            
        };
        Animator animator = new Animator(800,target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);
        background.setLayout(layout);
        background.setLayer(loading, JLayeredPane.POPUP_LAYER);
         background.setLayer(verifyCode, JLayeredPane.POPUP_LAYER);
        background.add(loading,"pos 0 0 100% 100%");
        background.add(verifyCode,"pos 0 0 100% 100%");
        
        background.add(cover,"width " +coverSize+"%, pos 0al 0 n 100%");
        background.add(loginAndRegister,"width " +loginSize+"%, pos 1al 0 n 100%");
        cover.addEvent(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(!animator.isRunning()){
                    animator.start();
                }
            }
        });
    }
    private void register(){
        ModelUser user = loginAndRegister.getUser();
        //loading.setVisible(true);
        //verifyCode.setVisible(true);
        showMessage(Message.MessageType.SUCCESS,"Test Message");
    }
    private void showMessage(Message.MessageType messageType, String message){
        Message ms = new Message();
        ms.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void begin() {
           if(!ms.isShowing()){
               background.add(ms,"pos 0.5al -30", 0);
               ms.setVisible(true);
               background.repaint();
           }
            }

            @Override
            public void timingEvent(float fraction) {
            float f;
            if(ms.isShowing()){
                f=40*(1f-fraction);
            }else{
                f=40*fraction;
            }
            layout.setComponentConstraints(ms, "pos 0.5al "+ (int) (f - 30));
            background.repaint();
            background.revalidate();
            }

            @Override
            public void end() {
             if(ms.isShowing()){
                 background.remove(ms);
                 background.repaint();
                 background.revalidate();
             }else{
                 ms.setVisible(true);
             }
            }
            
        };
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                    animator.start();
                }catch(Exception e){
                    System.err.println(e);
                } 
            }
        }).start();

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setOpaque(true);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane background;
    // End of variables declaration//GEN-END:variables
}
