/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Hilos.Sprints;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Alejandro Andrade
 */
public class Main extends javax.swing.JFrame {
    
    private int ordenSprint = 1;

    public int getOrdenSprint() {
        return ordenSprint;
    }

    public void setOrdenSprint(int ordenSprint) {
        this.ordenSprint = ordenSprint;
    }
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    public void advanceProgressBar() {
        int numSprints = 1;
        Semaphore semaforoSprints = new Semaphore(numSprints);

        Sprints sprint1 = new Sprints(1, semaforoSprints, "1", lblPorcentageS1, jProgressBarSprint1, lblPorcentageT, jProgressBar1);
        sprint1.start();
        dormir();
        Sprints sprint2 = new Sprints(3, semaforoSprints, "2", lblPorcentageS2, jProgressBarSprint2, lblPorcentageT, jProgressBar1);
        sprint2.start();
        dormir();
        Sprints sprint3 = new Sprints(3, semaforoSprints, "3", lblPorcentageS3, jProgressBarSprint3, lblPorcentageT, jProgressBar1);
        sprint3.start();
        dormir();
        Sprints sprint4 = new Sprints(2, semaforoSprints, "4", lblPorcentageS4, jProgressBarSprint4, lblPorcentageT, jProgressBar1);
        sprint4.start();
        dormir();
        Sprints sprint5 = new Sprints(2, semaforoSprints, "5", lblPorcentageS5, jProgressBarSprint5, lblPorcentageT, jProgressBar1);
        sprint5.start();
        dormir();
    }

    public void dormir() {
        try
        {
            Thread.sleep(10);
        } catch (InterruptedException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        top = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        lblPorcentageT = new javax.swing.JLabel();
        mid = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();
        bot = new javax.swing.JPanel();
        lblSprint1 = new javax.swing.JLabel();
        lblSprint2 = new javax.swing.JLabel();
        lblSprint3 = new javax.swing.JLabel();
        lblSprint4 = new javax.swing.JLabel();
        lblSprint5 = new javax.swing.JLabel();
        jProgressBarSprint1 = new javax.swing.JProgressBar();
        jProgressBarSprint2 = new javax.swing.JProgressBar();
        jProgressBarSprint3 = new javax.swing.JProgressBar();
        jProgressBarSprint4 = new javax.swing.JProgressBar();
        jProgressBarSprint5 = new javax.swing.JProgressBar();
        lblPorcentageS1 = new javax.swing.JLabel();
        lblPorcentageS2 = new javax.swing.JLabel();
        lblPorcentageS3 = new javax.swing.JLabel();
        lblPorcentageS4 = new javax.swing.JLabel();
        lblPorcentageS5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        top.setBackground(new java.awt.Color(0, 144, 50));

        lbl1.setBackground(new java.awt.Color(255, 255, 255));
        lbl1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 255, 255));
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setText("Avance del Proyecto");

        jProgressBar1.setForeground(new java.awt.Color(0, 153, 153));

        lblPorcentageT.setBackground(new java.awt.Color(255, 255, 255));
        lblPorcentageT.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblPorcentageT.setForeground(new java.awt.Color(255, 255, 255));
        lblPorcentageT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorcentageT.setText("0%");

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(topLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPorcentageT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPorcentageT, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(340, 340, 340))
        );

        bg.add(top, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 61));

        mid.setBackground(new java.awt.Color(0, 144, 50));

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout midLayout = new javax.swing.GroupLayout(mid);
        mid.setLayout(midLayout);
        midLayout.setHorizontalGroup(
            midLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(midLayout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(btnStart)
                .addGap(51, 51, 51)
                .addComponent(btnClear)
                .addContainerGap(219, Short.MAX_VALUE))
        );
        midLayout.setVerticalGroup(
            midLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(midLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(midLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(btnStart))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        bg.add(mid, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 610, -1));

        bot.setBackground(new java.awt.Color(153, 255, 153));

        lblSprint1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblSprint1.setForeground(new java.awt.Color(0, 0, 0));
        lblSprint1.setText("Sprint 1");

        lblSprint2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblSprint2.setForeground(new java.awt.Color(0, 0, 0));
        lblSprint2.setText("Sprint 2");

        lblSprint3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblSprint3.setForeground(new java.awt.Color(0, 0, 0));
        lblSprint3.setText("Sprint 3");

        lblSprint4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblSprint4.setForeground(new java.awt.Color(0, 0, 0));
        lblSprint4.setText("Sprint 4");

        lblSprint5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblSprint5.setForeground(new java.awt.Color(0, 0, 0));
        lblSprint5.setText("Sprint 5");

        jProgressBarSprint1.setForeground(new java.awt.Color(0, 153, 153));

        jProgressBarSprint2.setForeground(new java.awt.Color(0, 153, 153));

        jProgressBarSprint3.setForeground(new java.awt.Color(0, 153, 153));

        jProgressBarSprint4.setForeground(new java.awt.Color(0, 153, 153));

        jProgressBarSprint5.setForeground(new java.awt.Color(0, 153, 153));

        lblPorcentageS1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblPorcentageS1.setForeground(new java.awt.Color(0, 0, 0));
        lblPorcentageS1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorcentageS1.setText("0%");

        lblPorcentageS2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblPorcentageS2.setForeground(new java.awt.Color(0, 0, 0));
        lblPorcentageS2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorcentageS2.setText("0%");

        lblPorcentageS3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblPorcentageS3.setForeground(new java.awt.Color(0, 0, 0));
        lblPorcentageS3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorcentageS3.setText("0%");

        lblPorcentageS4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblPorcentageS4.setForeground(new java.awt.Color(0, 0, 0));
        lblPorcentageS4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorcentageS4.setText("0%");

        lblPorcentageS5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        lblPorcentageS5.setForeground(new java.awt.Color(0, 0, 0));
        lblPorcentageS5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorcentageS5.setText("0%");

        javax.swing.GroupLayout botLayout = new javax.swing.GroupLayout(bot);
        bot.setLayout(botLayout);
        botLayout.setHorizontalGroup(
            botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSprint1)
                    .addComponent(lblSprint2)
                    .addComponent(lblSprint3)
                    .addComponent(lblSprint4)
                    .addComponent(lblSprint5))
                .addGap(33, 33, 33)
                .addGroup(botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBarSprint1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarSprint2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarSprint3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarSprint4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarSprint5, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPorcentageS4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPorcentageS3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPorcentageS2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPorcentageS1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblPorcentageS5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        botLayout.setVerticalGroup(
            botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(botLayout.createSequentialGroup()
                        .addGroup(botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jProgressBarSprint1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblSprint1))
                            .addComponent(lblPorcentageS1))
                        .addGap(28, 28, 28)
                        .addGroup(botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jProgressBarSprint2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSprint2)))
                    .addComponent(lblPorcentageS2))
                .addGap(28, 28, 28)
                .addGroup(botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSprint3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPorcentageS3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarSprint3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSprint4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPorcentageS4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarSprint4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(botLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPorcentageS5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSprint5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarSprint5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        bg.add(bot, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 610, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        advanceProgressBar();
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        lblPorcentageS1.setText("0%");
        lblPorcentageS2.setText("0%");
        lblPorcentageS3.setText("0%");
        lblPorcentageS4.setText("0%");
        lblPorcentageS5.setText("0%");
        lblPorcentageT.setText("0%");

        jProgressBar1.setValue(0);
        jProgressBarSprint1.setValue(0);
        jProgressBarSprint2.setValue(0);
        jProgressBarSprint3.setValue(0);
        jProgressBarSprint4.setValue(0);
        jProgressBarSprint5.setValue(0);
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try
        {
            UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
        } catch (UnsupportedLookAndFeelException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Main().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel bot;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnStart;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBarSprint1;
    private javax.swing.JProgressBar jProgressBarSprint2;
    private javax.swing.JProgressBar jProgressBarSprint3;
    private javax.swing.JProgressBar jProgressBarSprint4;
    private javax.swing.JProgressBar jProgressBarSprint5;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lblPorcentageS1;
    private javax.swing.JLabel lblPorcentageS2;
    private javax.swing.JLabel lblPorcentageS3;
    private javax.swing.JLabel lblPorcentageS4;
    private javax.swing.JLabel lblPorcentageS5;
    private javax.swing.JLabel lblPorcentageT;
    private javax.swing.JLabel lblSprint1;
    private javax.swing.JLabel lblSprint2;
    private javax.swing.JLabel lblSprint3;
    private javax.swing.JLabel lblSprint4;
    private javax.swing.JLabel lblSprint5;
    private javax.swing.JPanel mid;
    private javax.swing.JPanel top;
    // End of variables declaration//GEN-END:variables

}
