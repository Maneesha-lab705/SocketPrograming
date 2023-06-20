import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try {
            Socket socket =new Socket("localhost",3002);
            System.out.println("send");
            DataOutputStream dataOutputStream =new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream =new DataInputStream(socket.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));

            String massage ="";
            String ryply ="";

            while(!massage.equals("end")){

                ryply=bufferedReader.readLine();
                dataOutputStream.writeUTF(ryply);
                dataOutputStream.flush();
                massage =dataInputStream.readUTF();
                System.out.println(massage);


            }

            socket.close();

        } catch (IOException e){
            throw new RuntimeException(e);
        }


    }
}
