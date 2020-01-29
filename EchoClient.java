import java.io.*;
import java.net.*;
import java.util.Scanner;
 
public class EchoClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    	System.out.println("Please enter the host name of server");
    	String hostName = sc.nextLine();
    	System.out.println("Please enter the port number the server is running on");
    	int portNumber = sc.nextInt();
 
 
        try {
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        
            int gameMode;
            System.out.println("Please enter which game mode you want to play. \n Over/Under for Over/Under game, \n Even/Odd for Even/Odd game");
            String userInput;
            String game1 = "Over/Under";
            String game2 = "Even/Odd";
            while((userInput = stdIn.readLine()) != null){
            	if(stdIn.readLine() == game1){
            		System.out.println("overunder");
            		gameMode = 1;
                	out.println(gameMode);
                }
                else if(userInput == game2){
                	gameMode = 2;
                	out.println(gameMode);
                }
                else{
                	System.out.println("Invalid response");
                }
            	
            }
            
            
            out.close();
            in.close();
            
           
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        } 
    }
}