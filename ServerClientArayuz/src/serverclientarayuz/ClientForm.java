package serverclientarayuz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * @file ClientForm.java
 * @description İstemci, sunucuya bağlanarak mesaj gönderebilir ve alabilir.
 * @assignment Chat Server Application
 * @date 17.03.2024
 * @author Beyza Yıldızlı: @beyza.yildizli@stu.fsm.edu.tr
 */
public class ClientForm extends javax.swing.JFrame {

    private Socket clientSocket;
    private DataInputStream sInput;
    private DefaultListModel list = new DefaultListModel();

    public ClientForm() {
        initComponents();
        DisconnectServerButton.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ConnectServerButton = new javax.swing.JButton();
        DisconnectServerButton = new javax.swing.JButton();
        SendMessageButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ClientList = new javax.swing.JList<>();
        ServerIPTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sendMessageTextArea = new javax.swing.JTextArea();
        ServerPortTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Server IP:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        ConnectServerButton.setText("Connect Server");
        ConnectServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectServerButtonActionPerformed(evt);
            }
        });

        DisconnectServerButton.setText("Disconnect Server");
        DisconnectServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisconnectServerButtonActionPerformed(evt);
            }
        });

        SendMessageButton.setText("Send Message");
        SendMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendMessageButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(ClientList);

        ServerIPTextField.setText("127.0.0.1");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Server IP:");

        sendMessageTextArea.setColumns(20);
        sendMessageTextArea.setRows(5);
        jScrollPane2.setViewportView(sendMessageTextArea);

        ServerPortTextField.setText("3000");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Server Port:");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CLIENT");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gelen Mesajlar:");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mesaj Gönder:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ServerIPTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(ServerPortTextField)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ConnectServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DisconnectServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SendMessageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ServerIPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ServerPortTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConnectServerButton)
                    .addComponent(DisconnectServerButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SendMessageButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConnectServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectServerButtonActionPerformed
        try {
            ClientList.setModel(list);

            //socket için port ve ip değerleri:
            int port = Integer.parseInt(ServerPortTextField.getText()); // "127.0.0.1";
            String ip = ServerIPTextField.getText();

            try {
                //Sunucuya bağlantı isteği gönderir:
                clientSocket = new Socket(ip, port);
                String msg = "Client: Baglantı -> " + clientSocket.getInetAddress().toString() + "  :  " + clientSocket.getPort() + " ";
                SendMessage(msg.getBytes());

                ConnectServerButton.setEnabled(false);
                DisconnectServerButton.setEnabled(true);

                //Sunucudan gelen hoşgeldin mesajını okur
                sInput = new DataInputStream(clientSocket.getInputStream());

                // Yeni bir thread oluştur ve dinlemeyi başlat:
                Thread listenThread = new Thread(() -> Listen());
                listenThread.start();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Sunucuya bağlanılamadı!", "Bağlantı Hatası", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            System.out.println("Geçersiz sayısal biçim: " + ServerIPTextField.getText());
        }
    }//GEN-LAST:event_ConnectServerButtonActionPerformed

    /*Sürekli olarak sunucudan gelen mesajları bekler ve bu mesajları listeye yazar.
    Eğer sunucu kapanırsa veya bir hata oluşursa, dinleme işlemi sonlandırılır.*/
    private void Listen() {
        while (true) {
            try {
                if (clientSocket.isClosed()) {
                    System.out.println("Socket kapalı dinleme durdu.");
                    break;
                }
                // Sunucudan gelen mesajlar byte dizisi olarak okunur:
                byte[] messageByte = new byte[1024];
                int bytesRead = sInput.read(messageByte);
                // Sunucu kapanırsa bytesRead -1 olur:
                if (bytesRead == -1) {
                    disconnectServer("Server kapandı mesajınız gönderilemedi.");
                    JOptionPane.showMessageDialog(this, "Server kapandı mesajınız gönderilemedi.", "Bağlantı Hatası", JOptionPane.ERROR_MESSAGE);
                    break;
                }
                // Okunan byte dizisi String'e dönüştürülür ve bu mesaj listeye eklenir:
                String message = new String(messageByte, 0, bytesRead);
                System.out.println(message);
                list.addElement(message);
            } catch (IOException ex) {
                if (clientSocket.isClosed()) {
                    System.out.println("Socket kapalı dinleme durdu.");
                    break;
                }
                Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void SendMessage(byte[] msg) {
        try {
            DataOutputStream sOutput = new DataOutputStream(clientSocket.getOutputStream());
            msg[msg.length - 1] = 0x14;
            sOutput.write(msg);
        } catch (IOException err) {
            System.out.println("Exception writing to server: " + err);
        }
    }

    private void SendMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendMessageButtonActionPerformed
        if (clientSocket == null || clientSocket.isClosed()) {
            JOptionPane.showMessageDialog(this, "Sunucuya bağlı değilsiniz. Lütfen önce sunucuya bağlanın.", "Bağlantı Hatası", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String message = "Client: " + sendMessageTextArea.getText();
        SendMessage(message.getBytes());
    }//GEN-LAST:event_SendMessageButtonActionPerformed

    private void disconnectServer(String disconnectMessage) {
        try {
            if (clientSocket != null && !clientSocket.isClosed()) {
                if (sInput != null) {
                    sInput.close();
                }
                clientSocket.close();
                System.out.println(disconnectMessage);
                list.addElement(disconnectMessage);
                ConnectServerButton.setEnabled(true);
                DisconnectServerButton.setEnabled(false);
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerForm.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
    private void DisconnectServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisconnectServerButtonActionPerformed
        disconnectServer("Sunucu bağlantısı kapatıldı");
    }//GEN-LAST:event_DisconnectServerButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ClientList;
    private javax.swing.JButton ConnectServerButton;
    private javax.swing.JButton DisconnectServerButton;
    private javax.swing.JButton SendMessageButton;
    private javax.swing.JTextField ServerIPTextField;
    private javax.swing.JTextField ServerPortTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea sendMessageTextArea;
    // End of variables declaration//GEN-END:variables
}
