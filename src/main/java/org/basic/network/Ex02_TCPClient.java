package org.basic.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

// 클라이언트는 서버의 IP와 port 번호가 필요하다.  192.168.2.29:9999
// 서버가 보낸 메세지를 소켓으로 연결된 통로로 받고 싶음
// 메세지 받으면서 동시에 보내고 싶으면 보조 스트림이 필요하다.
public class Ex02_TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.2.29",9999);
        System.out.println("서버와 연결 되었습니다.");

        InputStream in = socket.getInputStream();
        DataInputStream dis = new DataInputStream(in);

        String msg = dis.readUTF();
        System.out.println("서버에서 보낸 메세지 : " + msg);

        dis.close();
        in.close();
        socket.close();
    }
}
