package org.basic.network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
TCP 서버
소켓 객체는 I/O stream이 내장되어있다.
*/
public class Ex02_TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("접속 대기 중");
        Socket socket = serverSocket.accept(); // 요청이 오기를 기다리는 중
        System.out.println("연결 완료");        // 소켓과 소켓이 연결

        // 서버가 클라이언트의 연결된 소켓 주소를 통해서
        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out); // 보조 스트림
        dos.writeUTF("문자데이터 Byte 통신");

        System.out.println("서버종료");
        dos.close();
        out.close();
        socket.close();
        serverSocket.close();
    }
}
