import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

    public static void main(String[] args) {

        try {
            //create a saver socket.
            ServerSocket serverSocket =new ServerSocket(3002);
            //accept request and move to new socket.
            Socket socket =serverSocket.accept();
            System.out.println("Client Accept !");
            //java application used inputStream to read the data.
            DataInputStream dataInputStream =new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream =new DataOutputStream(socket.getOutputStream());

            BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));

            String massage ="";
            String replye ="";

            while(!massage.equals("finish")){
                massage =dataInputStream.readUTF();
                System.out.println(massage);

                replye =bufferedReader.readLine();
                dataOutputStream.writeUTF(replye);
                dataOutputStream.flush();
            }



            socket.close();




        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}
