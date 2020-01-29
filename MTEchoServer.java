import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
 
public class MTEchoServer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the port number to start the server");
        int portNumber = sc.nextInt();
        MTEchoServer es = new MTEchoServer();
        es.startServer(portNumber);
     }

     public void startServer(int portNumber) {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while(true) {
               Socket client = serverSocket.accept();
               Connection cc = new Connection(client);
            }
        } catch(Exception e) {
           System.out.println("Exception: "+e);
        }
    }
         
  
}


class Connection extends Thread {
    Socket client;
    PrintWriter out;
    BufferedReader in;
    
    public String OverUnderGame(String guess,  int range){
    	
    	int numberAnswer, numberDuplicate;
    	String answer = null;
    	String resultRight = "Correct";
    	String resultWrong = "Wrong";
    	
    	//Setting numbers in range client picks.
    	Random rand = new Random();
    	numberAnswer = rand.nextInt(range) + 0;//Unknown number where client has guess higher or lower 
    	numberDuplicate = rand.nextInt(range) + 0;//Number shown to client where user has to guess higher or lower
    	
    	
    	if(numberDuplicate == numberAnswer){
    		numberDuplicate = rand.nextInt(range)+0;
    	}
    	else{
    		if(numberAnswer < numberDuplicate){
    			answer = "under";
    		}
    		else{
    			answer = "over";
    		}
    	}
    	
    	if(guess == answer){
    		return resultRight;
    	}
    	else{
    		return resultWrong;
    	}
    	
    }
    
    public String EvenOddGame(String guess, int range){
    	
    	String answer = null;
    	String resultRight = "Correct";
    	String resultWrong = "Wrong";
    	
    	Random rand = new Random();
    	int numberAnswer = rand.nextInt(range) + 1;
    	
    	if(numberAnswer %2 == 0){
    		answer = "even";
    	}
    	else{
    		answer = "odd";
    	}
    	if(guess == answer){
    		return resultRight;
    	}
    	else{
    		return resultWrong;
    	}
    }
 
    public Connection(Socket s) { // constructor
       client = s;
       
       //Calling the function for which game they want to play
       try {
           out = new PrintWriter(client.getOutputStream(), true);                   
           in = new BufferedReader(new InputStreamReader(client.getInputStream()));
           
                     
       } catch (IOException e) {
           try {
             client.close();
           } catch (IOException ex) {
             System.out.println("Error while getting socket streams.."+ex);
           }
           return;
       }
        this.start(); // Thread starts here...this start() will call run()
    }
 
    public void run() {
      try {

         String inputLine;
         while ((inputLine = in.readLine()) != null) {
                System.out.println("Received from: "+ client.getRemoteSocketAddress() + " Input: "+inputLine);
                out.println(inputLine);
         }
         client.close();
       } catch (IOException e) {
           System.out.println("Exception caught...");
           System.out.println(e.getMessage());
       }
    }
    
}