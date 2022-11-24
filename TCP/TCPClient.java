import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception{
        String sentence;
        String modifiedSentence;

        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("hostname", 6789);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        sentence = inFromServer.readLine();

        outToServer.writeBytes(sentence+'\n');
        modifiedSentence = inFromServer.readLine();

        System.out.println("From SERVER " + modifiedSentence);

        clientSocket.close();
    }
}
