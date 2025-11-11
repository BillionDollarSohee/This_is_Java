package org.basic.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/*
서버 1개
여러명의 Client 가 하나의 서버 접속 : 채팅방 1개 가정
KEY POINT : HashMap > key : 사용자ID , Value : socket 객체 주소
*/

public class Ex05_TCPChatServer {

    ServerSocket serversocket = null;
    Socket socket = null;
    HashMap<String, DataOutputStream> ClientMap; 
    // key: name, value: socket outputstream

    public Ex05_TCPChatServer() {
        ClientMap = new HashMap<>();
    }

    // 1. 서버 초기화
    public void init() {
        try {
            serversocket = new ServerSocket(9999);
            System.out.println("[ 서버 시작 ... 요청 대기 ... ]");

            while (true) {
                socket = serversocket.accept();
                System.out.println("[ " + socket.getInetAddress() + " / " + socket.getPort() + " ] 접속");

                // 접속자마자 스레드를 만들어 줌
                Thread client = new MultiServerRev(socket);
                client.start();
            }

        } catch (Exception e) {
            System.out.println("Init : " + e.getMessage());
        }
    }

    // 2. 전체 broadcast
    public void sendAllMsg(String msg) {
        Iterator<String> keys = ClientMap.keySet().iterator();
        while (keys.hasNext()) {
            try {
                DataOutputStream out = ClientMap.get(keys.next());
                out.writeUTF(msg);

            } catch (Exception e) {
                System.out.println("sendAllMsg 예외 : " + e.getMessage());
            }
        }
    }

    // 3. 접속자 목록
    public String showUserList(String name) {
        StringBuilder sb = new StringBuilder("<<접속자 목록>>\n\r");
        Iterator<String> keys = ClientMap.keySet().iterator();

        while (keys.hasNext()) {
            String key = keys.next();
            if (key.equals(name)) {
                key += "(*)";
            }
            sb.append(key + "\n\r");
        }
        return sb.toString();
    }

    // 4. 귓속말
    public void sendToMsg(String from, String to, String msg) {
        try {
            ClientMap.get(to).writeUTF("귓속말 from (" + from + ") => " + msg);
            ClientMap.get(from).writeUTF("귓속말 to (" + to + ") => " + msg);

        } catch (Exception e) {
            System.out.println("sendToMsg 예외 : " + e.getMessage());
        }
    }

    // Thread
    class MultiServerRev extends Thread {
        Socket socket;
        DataInputStream in;
        DataOutputStream out;

        public MultiServerRev(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(this.socket.getInputStream());
                out = new DataOutputStream(this.socket.getOutputStream());

            } catch (Exception e) {
                System.out.println("MultiServerRev 생성자 예외 : " + e.getMessage());
            }
        }

        @Override
        public void run() {
            String name = "";

            try {
                out.writeUTF("이름을 입력하세요");
                name = in.readUTF();
                out.writeUTF("현재 채팅방에 입장하셨습니다");

                sendAllMsg(name + "님 입장^^");

                ClientMap.put(name, out);
                System.out.println("현재 접속자 수 : " + ClientMap.size() + "명");

                while (in != null) {
                    String msg = in.readUTF();

                    if (msg.startsWith("/")) {

                        if (msg.trim().equals("/접속자")) {
                            out.writeUTF(showUserList(name));

                        } else if (msg.startsWith("/귓속말")) {
                            String[] arr = msg.split(" ", 3);

                            if (arr.length < 3) {
                                out.writeUTF("HELP: /귓속말 [상대방ID] [메시지]");
                            } else {
                                String to = arr[1];
                                String tm = arr[2];

                                if (ClientMap.containsKey(to)) {
                                    sendToMsg(name, to, tm);
                                } else {
                                    out.writeUTF("해당 사용자가 없습니다.");
                                }
                            }

                        } else {
                            out.writeUTF("잘못된 명령어입니다");
                        }

                    } else {
                        sendAllMsg("[ " + name + " ] " + msg);
                    }
                }

            } catch (Exception e) {
                System.out.println("run 예외 : " + e.getMessage());

            } finally {
                ClientMap.remove(name);
                sendAllMsg(name + "님 퇴장하였습니다");
                System.out.println("현재 접속자 수 : " + ClientMap.size() + "명");
            }
        }
    }

    public static void main(String[] args) {
        Ex05_TCPChatServer server = new Ex05_TCPChatServer();
        server.init();
    }
}
