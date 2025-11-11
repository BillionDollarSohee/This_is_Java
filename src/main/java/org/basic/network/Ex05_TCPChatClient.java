package org.basic.network;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Ex05_TCPChatClient extends JFrame implements ActionListener, Runnable {

    JTextArea ta;      // 출력창
    JTextField txtinput; // 입력창
    DataInputStream in;
    DataOutputStream out;

    public Ex05_TCPChatClient() {

        this.setTitle("Multi 채팅");

        ta = new JTextArea();
        txtinput = new JTextField();

        JScrollPane sp = new JScrollPane(
                ta,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
        );

        ta.setBackground(Color.yellow);
        ta.setLineWrap(true);
        ta.setEditable(false);

        txtinput.setText("이름 입력");
        txtinput.requestFocus();
        txtinput.selectAll();

        this.add(sp, "Center");
        this.add(txtinput, "South");

        this.setSize(400, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtinput.addActionListener(this);

        try {
            Socket socket = new Socket("192.168.0.46", 9999);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            ta.append("서버에 접속 되었습니다\n\r");

            Thread client = new Thread(this);
            client.start();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(txtinput)) {
            String msg = txtinput.getText();
            try {
                out.writeUTF(msg);
                txtinput.setText("");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void run() {
        try {
            String msg = in.readUTF();
            ta.append(msg + "\n\r");

            while (in != null) {
                msg = in.readUTF();
                ta.append(msg + "\n\r");
            }

        } catch (Exception e) {
            System.out.println("접속중 서버와 연결 종료");
        }
    }

    public static void main(String[] args) {
        new Ex05_TCPChatClient();
    }
}
