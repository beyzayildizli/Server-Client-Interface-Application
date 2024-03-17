package serverclientarayuz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @file ServerForm.java
 * @description Sunucu, aynı anda birden fazla istemcinin soketler üzerinden
 * bağlanmasına ve mesaj alışverişinde bulunmasına izin verir.
 * @assignment Chat Server Application
 * @date 17.03.2024
 * @author Beyza Yıldızlı: @beyza.yildizli@stu.fsm.edu.tr
 */
public class ServerForm extends javax.swing.JFrame {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    public static boolean isServerRunning;
    private DefaultListModel messageList = new DefaultListModel();
    private List<Socket> clientSockets = new ArrayList<>();
    private List<Socket> clientSocketsForMessage = new ArrayList<>();

    public ServerForm() {
        initComponents();
        StopServerButton.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        StartServerButton = new javax.swing.JButton();
        StopServerButton = new javax.swing.JButton();
        SendMessageButton = new javax.swing.JButton();
        BroadcastMessageButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ServerMessageList = new javax.swing.JList<>();
        PortTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sendMessageTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));

        StartServerButton.setText("Start Server");
        StartServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartServerButtonActionPerformed(evt);
            }
        });

        StopServerButton.setText("Stop Server");
        StopServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopServerButtonActionPerformed(evt);
            }
        });

        SendMessageButton.setText("Send Message");
        SendMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendMessageButtonActionPerformed(evt);
            }
        });

        BroadcastMessageButton.setText("Brodcast Message");
        BroadcastMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BroadcastMessageButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(ServerMessageList);

        PortTextField.setText("3000");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dinlenecek Port:");

        sendMessageTextArea.setColumns(20);
        sendMessageTextArea.setRows(5);
        jScrollPane2.setViewportView(sendMessageTextArea);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SERVER");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mesaj Gönder:");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Gelen Mesajlar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PortTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(StartServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(StopServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BroadcastMessageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SendMessageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(29, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(PortTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartServerButton)
                    .addComponent(StopServerButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SendMessageButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BroadcastMessageButton))
                    .addComponent(jScrollPane1))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StartServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartServerButtonActionPerformed
        try {
            ServerMessageList.setModel(messageList);

            //Serveri başlat:
            int port = Integer.parseInt(PortTextField.getText());
            serverSocket = new ServerSocket(port);
            isServerRunning = true;
            System.out.println("Server Started");
            StartServerButton.setEnabled(false);
            StopServerButton.setEnabled(true);

            // Yeni bir thread oluştur ve dinlemeyi başlat:
            Thread listenThread = new Thread(() -> Listen());
             //Thread listenThread = new Thread(this::Listen); //thread oluşturmak için diğer yol
            listenThread.start();

        } catch (NumberFormatException e) {
            System.out.println("Geçersiz sayısal biçim: " + PortTextField.getText());
        } catch (IOException e) {
            System.out.println("Port kullanımda veya başka bir giriş/çıkış hatası: " + e.getMessage());
        }
    }//GEN-LAST:event_StartServerButtonActionPerformed

    /*Sunucunun client bağlantılarını dinleyip kabul eder ve her bağlantı
    için ayrı bir thread başlatarak clientlere hizmet vermesini sağlar*/
    private void Listen() {
        while (isServerRunning) {
            try {
                if (!isServerRunning) {
                    break;
                }
                // Client bağlantısını kabul eder ve socket değerlerini konsola yazar.
                clientSocket = serverSocket.accept();
                System.out.println("Yeni istemci bağlandı: " + clientSocket);

                // Her client için ayrı bir thread oluştur
                Thread clientThread = new Thread(() -> handleClient(clientSocket));
                clientThread.start();
            } catch (IOException ex) {
                if (!isServerRunning) {
                    break;
                }
                Logger.getLogger(ServerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /*
    Her client için ayrı çalışır. Bağlantıyı kabul eder, cliente hoş geldin
    mesajı gönderir ve ardından clientten gelen mesajları dinler.
    Client bağlantısı kapatıldığında işlem sonlanır.
     */
    private void handleClient(Socket clientSocket) {
        try {
            clientSockets.add(clientSocket);
            clientSocketsForMessage.add(clientSocket);

            // Client'ten gelen mesajı okur:
            DataInputStream sInput = new DataInputStream(clientSocket.getInputStream());
            byte[] buffer = new byte[1024];
            int bytesRead = sInput.read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println(message);
            // Gelen mesajı listeye ekler:
            messageList.addElement(message);

            // İstemciye hoş geldin mesajını gönderir:
            buffer = "Server: Sunucuya bağlandınız".getBytes();
            sendMessage(buffer, clientSocket);

            while (isServerRunning) {
                bytesRead = sInput.read(buffer);
                //bytesRead değerinin -1 olması client bağlantısı kapatıldığını ve veri alımının sonlandığını gösterir.,
                if (bytesRead == -1) {
                    break;
                }
                if (!isServerRunning) {
                    break;
                }
                // İstemciden gelen mesajları okur ve listeye ekler:
                message = new String(buffer, 0, bytesRead);
                System.out.println(message);
                messageList.addElement(message);
                //client'in socketini clientSocketsForMessage listesinde tutar:
                clientSocketsForMessage.add(clientSocket);
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerForm.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void sendMessage(byte[] msg, Socket clientSocket) {
        try {
            DataOutputStream sOutput = new DataOutputStream(clientSocket.getOutputStream());
            msg[msg.length - 1] = 0x14;
            sOutput.write(msg);
        } catch (IOException err) {
            System.out.println("Exception writing to server: " + err);
        }
    }

    private void StopServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopServerButtonActionPerformed
        try {
            isServerRunning = false;
            serverSocket.close();
            System.out.println("Server stopped");
            StopServerButton.setEnabled(false);
            StartServerButton.setEnabled(true);
        } catch (IOException ex) {
            Logger.getLogger(ServerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_StopServerButtonActionPerformed

    private void SendMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendMessageButtonActionPerformed
        if (!isServerRunning) {
            JOptionPane.showMessageDialog(this, "Sunucu kapalı durumda. Mesaj göndermek için önce sunucuyu başlatın.", "Sunucu Kapalı", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (clientSockets.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bağlı istemci bulunmamaktadır. Mesaj gönderebilmek için önce bir clientin bağlanmasını bekleyin.", "Bağlı İstemci Yok", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int selectedIndex = ServerMessageList.getSelectedIndex();
        if (selectedIndex != -1) {
            String msg = "Server: " + sendMessageTextArea.getText();
            byte[] msgBytes = msg.getBytes();
            Socket selectedClientSocket = clientSocketsForMessage.get(selectedIndex);
            // Mesajı seçili cliente gönder:
            sendMessage(msgBytes, selectedClientSocket);
        } else {
            JOptionPane.showMessageDialog(this, "Mesaj gönderebilmek için mesajın gönderilmesini istediğiniz clienti yukarıdaki mesajlar bölümünden seçiniz.", "Client seçmediniz!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SendMessageButtonActionPerformed

    private void BroadcastMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BroadcastMessageButtonActionPerformed
        if (!isServerRunning) {
            JOptionPane.showMessageDialog(this, "Sunucu kapalı durumda. Mesaj göndermek için önce sunucuyu başlatın.", "Sunucu Kapalı", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (clientSockets.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bağlı istemci bulunmamaktadır. Mesaj gönderebilmek için önce bir clientin bağlanmasını bekleyin.", "Bağlı İstemci Yok", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Tüm bağlı clientlere mesajı gönder:
        String msg = "Server: " + sendMessageTextArea.getText();
        byte[] msgBytes = msg.getBytes();
        for (Socket clientSocket : clientSockets) {
            sendMessage(msgBytes, clientSocket);
        }
    }//GEN-LAST:event_BroadcastMessageButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BroadcastMessageButton;
    private javax.swing.JTextField PortTextField;
    private javax.swing.JButton SendMessageButton;
    private javax.swing.JList<String> ServerMessageList;
    private javax.swing.JButton StartServerButton;
    private javax.swing.JButton StopServerButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea sendMessageTextArea;
    // End of variables declaration//GEN-END:variables
}
