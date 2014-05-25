/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devTeam.xml.converter.gui;

import fr.devTeam.xml.converter.kmlToMwc;
import fr.devTeam.xml.converter.mwcToKml;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author EUGI7210
 */
public class mainInterface extends javax.swing.JFrame {

    /**
     * Creates new form mainInterface
     */
    public mainInterface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dirChooser = new javax.swing.JFileChooser();
        fileChooser = new javax.swing.JFileChooser();
        jOptionPane1 = new javax.swing.JOptionPane();
        about = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jTextPane1 = new javax.swing.JTextPane();
        okButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        kmlFileTextField = new javax.swing.JTextField();
        browseKmlDir1 = new javax.swing.JButton();
        outFileTextField = new javax.swing.JTextField();
        browseOutFile = new javax.swing.JButton();
        generateButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        mwcInTextField = new javax.swing.JTextField();
        mwcInBrowse = new javax.swing.JButton();
        outKmlFileDirTextField = new javax.swing.JTextField();
        outDirKmlBrowse = new javax.swing.JButton();
        convertButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        dirChooser.setDialogTitle("Selection du répertoire contenant les fichiers KML");
        dirChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        about.setTitle("A propos");
        about.setMinimumSize(new java.awt.Dimension(400, 500));
        about.setPreferredSize(new java.awt.Dimension(400, 500));
        about.setResizable(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fr/devTeam/xml/converter/gui/images/Logo_rcnet_150.png"))); // NOI18N

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(238, 238, 238));
        jTextPane1.setBorder(null);
        jTextPane1.setContentType("text/html"); // NOI18N
        jTextPane1.setText("<HTML>\n<HEAD>\n</HEAD>\n<BODY LANG=\"fr-FR\" DIR=\"LTR\">\n<P ALIGN=CENTER STYLE=\"margin-bottom: 0cm\"><B>KmlConverter</B></P>\n<P ALIGN=LEFT STYLE=\"margin-bottom: 0cm; font-weight: normal\">version&nbsp;:\n1.0</P>\n<P ALIGN=LEFT STYLE=\"margin-bottom: 0cm; font-weight: normal\">Outil\nde conversion des données google earth / google maps au format kml\nvers un format texte lisible par une carte arduino ( mega 2560 ).</P>\n<P ALIGN=LEFT STYLE=\"margin-bottom: 0cm; font-weight: normal\">Cet\noutil permets également de convertir les logs GPS enregistrées sur\ncartes SD en fichier chemin compatible google earth afin de\nvisualiser le parcours de vol effectué</P>\n</BODY>\n</HTML>");

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout aboutLayout = new javax.swing.GroupLayout(about.getContentPane());
        about.getContentPane().setLayout(aboutLayout);
        aboutLayout.setHorizontalGroup(
            aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutLayout.createSequentialGroup()
                .addGroup(aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(aboutLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel2)
                        .addGap(0, 120, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(aboutLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(okButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        aboutLayout.setVerticalGroup(
            aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KmlConverter");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("kml vers mwc"));

        kmlFileTextField.setText("Chemin du répertoire des kml");
        kmlFileTextField.setToolTipText("Entrez le chemin du répertoire contenant les fichiers KML numérotés de 1 a X");

        browseKmlDir1.setText("Browse");
        browseKmlDir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseKmlDir1ActionPerformed(evt);
            }
        });

        outFileTextField.setText("Nom du fichier de sortie");
        outFileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outFileTextFieldActionPerformed(evt);
            }
        });

        browseOutFile.setText("Browse");
        browseOutFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseOutFileActionPerformed(evt);
            }
        });

        generateButton.setText("Générer");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(generateButton)
                .addGap(155, 155, 155))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(outFileTextField)
                    .addComponent(kmlFileTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(browseKmlDir1)
                    .addComponent(browseOutFile))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kmlFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseKmlDir1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseOutFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("mwc vers kml"));

        mwcInTextField.setText("Chemin du fichier d'entrée");

        mwcInBrowse.setText("Browse");
        mwcInBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mwcInBrowseActionPerformed(evt);
            }
        });

        outKmlFileDirTextField.setText("Chemin du fichier de sortie");

        outDirKmlBrowse.setText("Browse");
        outDirKmlBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outDirKmlBrowseActionPerformed(evt);
            }
        });

        convertButton.setText("Convertir");
        convertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(mwcInTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mwcInBrowse))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(outKmlFileDirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(outDirKmlBrowse)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(convertButton)
                .addGap(153, 153, 153))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mwcInTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mwcInBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outKmlFileDirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outDirKmlBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(convertButton))
        );

        jMenu1.setText("Fichier");

        jMenuItem3.setMnemonic('A');
        jMenuItem3.setText("Aide");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setMnemonic('q');
        jMenuItem1.setText("Quitter");
        jMenuItem1.setToolTipText("");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("?");

        jMenuItem2.setText("A propos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseKmlDir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseKmlDir1ActionPerformed
        int returnVal = dirChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = dirChooser.getSelectedFile();
            // What to do with the file, e.g. display it in a TextArea
            kmlFileTextField.setText(file.getAbsolutePath());
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_browseKmlDir1ActionPerformed

    private void outFileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outFileTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outFileTextFieldActionPerformed

    private void browseOutFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseOutFileActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // What to do with the file, e.g. display it in a TextArea
            outFileTextField.setText(file.getAbsolutePath());
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_browseOutFileActionPerformed

    private void mwcInBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mwcInBrowseActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // What to do with the file, e.g. display it in a TextArea
            mwcInTextField.setText(file.getAbsolutePath());
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_mwcInBrowseActionPerformed

    private void outDirKmlBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outDirKmlBrowseActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // What to do with the file, e.g. display it in a TextArea
            outKmlFileDirTextField.setText(file.getAbsolutePath());
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_outDirKmlBrowseActionPerformed

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        try {
            kmlToMwc.convert(kmlFileTextField.getText(), outFileTextField.getText());
            jOptionPane1.showMessageDialog(this, "Fichier " + outFileTextField.getText() + "Généré avec succès");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
            jOptionPane1.setMessageType(JOptionPane.ERROR_MESSAGE);
            jOptionPane1.showMessageDialog(this, "Erreur d'écriture du fichier de sortie");
        }
    }//GEN-LAST:event_generateButtonActionPerformed

    private void convertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertButtonActionPerformed
        try {
            mwcToKml.convert(mwcInTextField.getText(), outKmlFileDirTextField.getText());
            jOptionPane1.showMessageDialog(this, "Fichier " + outKmlFileDirTextField.getText() + "Généré avec succès");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
            jOptionPane1.setMessageType(JOptionPane.ERROR_MESSAGE);
            jOptionPane1.showMessageDialog(this, "Erreur d'écriture du fichier de sortie");
        }
    }//GEN-LAST:event_convertButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        about.setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        about.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            URI uri = new URI("http://www.rcnet.com");
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    desktop.browse(uri);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            /*for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName()) | "GTK+".equals(info.getName()) | "Macintosh".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }

                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                }
            }*/
            
            javax.swing.UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainInterface().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog about;
    private javax.swing.JButton browseKmlDir1;
    private javax.swing.JButton browseOutFile;
    private javax.swing.JButton convertButton;
    private javax.swing.JFileChooser dirChooser;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton generateButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField kmlFileTextField;
    private javax.swing.JButton mwcInBrowse;
    private javax.swing.JTextField mwcInTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JButton outDirKmlBrowse;
    private javax.swing.JTextField outFileTextField;
    private javax.swing.JTextField outKmlFileDirTextField;
    // End of variables declaration//GEN-END:variables
}
