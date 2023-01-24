/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package io.takamaka.app.collecttkg;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.takamaka.app.collecttkg.bean.ChallengeResponseBean;
import io.takamaka.app.collecttkg.utils.ProjectHelper;
import io.takamaka.wallet.utils.FixedParameters;
import io.takamaka.wallet.utils.TkmSignUtils;
import java.io.IOException;
import java.net.ProtocolException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author tyranneo
 */
@Slf4j
public class MainFrame extends javax.swing.JFrame {

    public static String difficulty;
    public static long challengeID;
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static String challenge;
    public static String walletAddress;
    private int availableProcessors = Runtime.getRuntime().availableProcessors();
    public static ConcurrentSkipListSet<Boolean> killClausole = new ConcurrentSkipListSet<>();
    public static MainFrame mainFrame;
    private static final ConcurrentSkipListSet<Boolean> buttonKill = new ConcurrentSkipListSet<>();
    private static AtomicInteger numOfThreads = new AtomicInteger();

    /**
     * Creates new form MainFraine
     */
    public MainFrame() {
        initComponents();
        numOfThreads.set(Runtime.getRuntime().availableProcessors());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Wallet Addres");

        jButton1.setText("Verify Address");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMaximum(Runtime.getRuntime().availableProcessors());
        jSlider1.setMinimum(1);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(Runtime.getRuntime().availableProcessors());
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel3.setText("Max Processors");

        jButton4.setText("Claim");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Stop Mining");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("Start Mining");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTextField1.setText("Wallet Address");
        jTextField1.setToolTipText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("pwd/s:");

        jTextField2.setEnabled(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(205, 205, 205))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        walletAddress = jTextField1.getText();
        System.out.println("text: " + walletAddress);
        jButton7.setEnabled(true);
        jButton4.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        buttonKill.add(Boolean.TRUE);
        jButton7.setEnabled(true);
        jButton5.setEnabled(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jButton7.setEnabled(false);
        jButton5.setEnabled(true);
        /*
            Require a challenge from server

         */
        try {
            Map<String, String> parameters = new HashMap<>();
            parameters.put("walletAddress", walletAddress);
            String get = ProjectHelper.doPost(
                    "http://192.168.2.44:8080/requirechallenge", parameters);
            ObjectMapper mapper = new ObjectMapper();
            ChallengeResponseBean crb = mapper.readValue(get, new TypeReference<ChallengeResponseBean>() {
            });
            difficulty = crb.getDifficulty();
            challengeID = crb.getChallengeId();
            challenge = crb.getChallenge();
        } catch (ProtocolException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
            Start the mining sequence
         */
        long maxRange = 20000000000L;
        //--da inserire nello slider
        System.out.println("availableProcessors:" + availableProcessors);

        final int threadScale = availableProcessors * 
                availableProcessors *
                availableProcessors * 
                availableProcessors *
                availableProcessors * 8;
        //--//
        ConcurrentSkipListMap<Long, String> sol = new ConcurrentSkipListMap<>();
//        final String post = "B6bCu6Ee9ICmsF_6Lzfs5GlB_SPl3rjMXIIE2Bb1Lpg." + challengeID + challenge;
        final String post = challenge;
        log.info("challeng: " + challenge);
        new Thread(new Runnable() {
            @Override
            public void run() {
                long curr = 0;
                ForkJoinPool fjp = new ForkJoinPool(numOfThreads.get());

                do {
                    try {
                        Date begin = new Date();
                        final LongStream range = LongStream.range(curr, curr + threadScale);
                        fjp.submit(() -> {
                            range.parallel().forEach((long i) -> {

                                byte[] hash256Byte = {};
                                try {
                                    hash256Byte = TkmSignUtils.Hash256Byte((i + post).getBytes(), FixedParameters.HASH_256_ALGORITHM);
                                } catch (NoSuchAlgorithmException | NoSuchProviderException ex) {
                                    log.error("ooooopz", ex);
                                }
                                String fromBytesToHexString = fromBytesToHexString(
                                        hash256Byte);
                                if (fromBytesToHexString.startsWith(difficulty)) {
                                    killClausole.add(Boolean.TRUE);
                                    sol.put(i, fromBytesToHexString);
                                }

                            });
                        }).get();

                        Date end = new Date();
                        double sec = ((double) (end.getTime() - begin.getTime())) / 1000;
                        if (sec == 0) {
                            sec = 1L;
                        }

                        jTextField2.setText(Math.round(threadScale / sec) + "");
                        mainFrame.invalidate();
                        mainFrame.validate();
                        mainFrame.repaint();

                        curr += threadScale;
                    } catch (InterruptedException | ExecutionException ex) {
                        Logger.getLogger(
                                MainFrame.class.getName())
                                .log(Level.SEVERE, null, ex);
                    }

                } while (curr < maxRange &
                        !killClausole.contains(Boolean.TRUE) &
                        !buttonKill.contains(Boolean.TRUE));
                if (!buttonKill.contains(Boolean.TRUE)) {
                    Map<String, String> parameters = new HashMap<>();
                    parameters.put("challengeID", String.valueOf(challengeID));
                    parameters.put("walletAddress", walletAddress);
                    parameters.put("challenge", challenge);
                    parameters.put("interoSoluzione", sol.firstEntry().getKey() + "");
                    try {
                        String get = ProjectHelper.doPost(
                                "http://192.168.2.44:8080/checkresult", parameters);
                        log.info(get);
                    } catch (IOException ex) {
                        log.error(ex.getLocalizedMessage());
                    }
                    log.info("Iterazioni eseguite " + sol.firstEntry().getKey() + " per trovare la soluzione " + sol.firstEntry().getValue());
                } else {
                    log.info("Stop by user action");
                }

                sol.clear();
                killClausole.clear();
                buttonKill.clear();
            }
        }).start();

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        //availableProcessors = jSlider1.getValue();
        numOfThreads.set(jSlider1.getValue());
        log.info("Num of threads set by user: " + numOfThreads.get());
    }//GEN-LAST:event_jSlider1StateChanged

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        jTextField1.setText(jTextField1.getText());
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                mainFrame = new MainFrame();
                mainFrame.setTitle("Takamaka Miner");
                mainFrame.setVisible(true);
            }
        });
    }

    public static final String fromBytesToHexString(byte[] bytes) {
//        StringBuffer sb = new StringBuffer(target)
        int lnC = bytes.length;
        char[] cRes = new char[lnC * 2];
        IntStream.range(0, lnC).parallel().forEach(i -> {
//             cRes[i] = (char) bytes[i];
            int v = bytes[i] & 0xFF;
            cRes[i * 2] = HEX_ARRAY[v >>> 4];
            cRes[i * 2 + 1] = HEX_ARRAY[v & 0x0F];
            //cRes[i] = String.format("", args);
        });
        return String.valueOf(cRes);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
