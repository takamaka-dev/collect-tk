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
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import static java.lang.Thread.sleep;
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
import java.util.concurrent.atomic.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
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
    public static final String WALLET_PARAM_STRING = "^[0-9a-zA-Z-_.]+$";
    public static Pattern WALLET_PARAM_PATTERN;
    private static AtomicBoolean continueMining = new AtomicBoolean(false);
    private static final ConcurrentSkipListSet<Boolean> stopPolling = new ConcurrentSkipListSet<>();

    /**
     * Creates new form MainFraine
     */
    public MainFrame() throws IOException {
        initComponents();
        WALLET_PARAM_PATTERN = Pattern.compile(WALLET_PARAM_STRING);
        numOfThreads.set(Runtime.getRuntime().availableProcessors());
        jCheckBoxContinueMining.setSelected(continueMining.get());
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
        jButtonVerifyAddress = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jButtonClaim = new javax.swing.JButton();
        jButtonStopMining = new javax.swing.JButton();
        jButtonStartMining = new javax.swing.JButton();
        jTextFieldWalletAddress = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jCheckBoxContinueMining = new javax.swing.JCheckBox();
        jLabelTakamakaLogo = new javax.swing.JLabel();
        jButtonPasteFromClipboard = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabelClaimStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Wallet Addres");

        jButtonVerifyAddress.setText("Verify Address");
        jButtonVerifyAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerifyAddressActionPerformed(evt);
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

        jButtonClaim.setText("Claim");
        jButtonClaim.setEnabled(false);
        jButtonClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClaimActionPerformed(evt);
            }
        });

        jButtonStopMining.setText("Stop Mining");
        jButtonStopMining.setEnabled(false);
        jButtonStopMining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopMiningActionPerformed(evt);
            }
        });

        jButtonStartMining.setText("Start Mining");
        jButtonStartMining.setEnabled(false);
        jButtonStartMining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartMiningActionPerformed(evt);
            }
        });

        jTextFieldWalletAddress.setText("Wallet Address");
        jTextFieldWalletAddress.setToolTipText("");
        jTextFieldWalletAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldWalletAddressActionPerformed(evt);
            }
        });

        jLabel1.setText("pwd/s:");

        jTextField2.setEnabled(false);
        jTextField2.setFocusable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jCheckBoxContinueMining.setText(" Continue Mining");
        jCheckBoxContinueMining.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxContinueMiningActionPerformed(evt);
            }
        });

        jLabelTakamakaLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        jButtonPasteFromClipboard.setText("Paste Address");
        jButtonPasteFromClipboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPasteFromClipboardActionPerformed(evt);
            }
        });

        jLabel5.setText("Solutions not claimed:");

        jTextField3.setEnabled(false);
        jTextField3.setFocusable(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabelClaimStatus.setForeground(new java.awt.Color(0, 153, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jButtonPasteFromClipboard, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldWalletAddress)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonVerifyAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxContinueMining)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonStartMining, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(116, 116, 116)
                                        .addComponent(jLabel1)))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonStopMining, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(213, 213, 213)
                                .addComponent(jButtonClaim, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField3)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 128, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelTakamakaLogo)
                        .addGap(347, 347, 347))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelClaimStatus)
                        .addGap(271, 271, 271))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabelTakamakaLogo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonVerifyAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelClaimStatus)
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonPasteFromClipboard, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldWalletAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jCheckBoxContinueMining)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonStartMining, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonStopMining, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonClaim, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVerifyAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerifyAddressActionPerformed
        walletAddress = jTextFieldWalletAddress.getText();
        if (WALLET_PARAM_PATTERN.matcher(walletAddress.trim()).find()) {
            System.out.println("text: " + walletAddress);
            jButtonStartMining.setEnabled(true);
            jButtonClaim.setEnabled(true);
        }

    }//GEN-LAST:event_jButtonVerifyAddressActionPerformed


    private void jButtonStopMiningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopMiningActionPerformed
        buttonKill.add(Boolean.TRUE);
        stopPolling.add(Boolean.TRUE);
        jButtonStartMining.setEnabled(true);
        jCheckBoxContinueMining.setSelected(false);
    }//GEN-LAST:event_jButtonStopMiningActionPerformed

    private void jButtonStartMiningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartMiningActionPerformed
        jButtonStartMining.setEnabled(false);
        jButtonStopMining.setEnabled(true);
        /*
            Require a challenge from server

         */
        try {
            Map<String, String> parameters = new HashMap<>();
            parameters.put("walletAddress", walletAddress);
            String get = ProjectHelper.doPost(
                    "http://192.168.2.143:8080/requirechallenge", parameters);
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

        final int threadScale = availableProcessors
                * availableProcessors
                * availableProcessors
                * availableProcessors
                * availableProcessors * 8;

        ConcurrentSkipListMap<Long, String> sol = new ConcurrentSkipListMap<>();
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

                } while (curr < maxRange
                        & !killClausole.contains(Boolean.TRUE)
                        & !buttonKill.contains(Boolean.TRUE));
                if (!buttonKill.contains(Boolean.TRUE)) {
                    Map<String, String> parameters = new HashMap<>();
//                    parameters.put("challengeID", String.valueOf(challengeID));
                    parameters.put("walletAddress", walletAddress);
                    parameters.put("challenge", challenge);
                    parameters.put("interoSoluzione", sol.firstEntry().getKey() + "");
                    try {
                        String get = ProjectHelper.doPost(
                                "http://192.168.2.143:8080/checkresult", parameters);
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
                jButtonStartMining.setEnabled(true);
                if (jCheckBoxContinueMining.isSelected()) {
                    jButtonStartMining.doClick();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stopPolling.contains(Boolean.TRUE)) {
                    Map<String, String> parameters = new HashMap<>();
                    parameters.put("walletAddress", walletAddress);
                    try {
                        String numberOfClaims = ProjectHelper.doPost("http://192.168.2.143:8080/checkclamingsolutions", parameters);
                        jTextField3.setText(numberOfClaims);
                        sleep(5000);
                    } catch (IOException | InterruptedException ex) {
                        log.error(ex.getLocalizedMessage());
                    }
                }
            }
        }
        ).start();
    }//GEN-LAST:event_jButtonStartMiningActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        //availableProcessors = jSlider1.getValue();
        numOfThreads.set(jSlider1.getValue());
        log.info("Num of threads set by user: " + numOfThreads.get());
    }//GEN-LAST:event_jSlider1StateChanged

    private void jTextFieldWalletAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldWalletAddressActionPerformed
        jTextFieldWalletAddress.setText(jTextFieldWalletAddress.getText());
    }//GEN-LAST:event_jTextFieldWalletAddressActionPerformed

    private void jButtonClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClaimActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, String> parameters = new HashMap<>();

                parameters.put("walletAddress", walletAddress);
                try {
                    ProjectHelper.doPost("http://192.168.2.143:8080/claimsolutions", parameters);
                    jLabelClaimStatus.setText("The solutions has been properly claimed! Check your balance!");
                    sleep(10000);
                    jLabelClaimStatus.setText("");
                } catch (IOException ex) {
                    log.error(ex.getLocalizedMessage());
                    jLabelClaimStatus.setText(ex.getLocalizedMessage());
                    try {
                        sleep(10000);
                    } catch (InterruptedException ex1) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    jLabelClaimStatus.setText("");
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }//GEN-LAST:event_jButtonClaimActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jCheckBoxContinueMiningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxContinueMiningActionPerformed
        continueMining.set(!continueMining.get());
        jCheckBoxContinueMining.setSelected(continueMining.get());
    }//GEN-LAST:event_jCheckBoxContinueMiningActionPerformed

    private void jButtonPasteFromClipboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPasteFromClipboardActionPerformed
        jTextFieldWalletAddress.setText(pasteFromClipboard());
    }//GEN-LAST:event_jButtonPasteFromClipboardActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

    }//GEN-LAST:event_jTextField3ActionPerformed

    public Clipboard getClipboard() {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        return defaultToolkit.getSystemClipboard();
    }

    public String pasteFromClipboard() {
        String res = null;
        Clipboard clipboard = getClipboard();
        Transferable contents = clipboard.getContents(null);
        if (contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                res = (String) contents.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException ex) {
                log.error(ex.getLocalizedMessage());
            }
        }
        return res;
    }

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

                try {
                    mainFrame = new MainFrame();
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    private javax.swing.JButton jButtonClaim;
    private javax.swing.JButton jButtonPasteFromClipboard;
    private javax.swing.JButton jButtonStartMining;
    private javax.swing.JButton jButtonStopMining;
    private javax.swing.JButton jButtonVerifyAddress;
    private javax.swing.JCheckBox jCheckBoxContinueMining;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelClaimStatus;
    private javax.swing.JLabel jLabelTakamakaLogo;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextFieldWalletAddress;
    // End of variables declaration//GEN-END:variables
}
