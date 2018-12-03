/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreseau;

/**
 *
 * @author pedago
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurTCP {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            System.out.println("Could not listen on port 4444");
            System.out.println(-1);
        }

        Socket clientSocket = serverSocket.accept();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
        );

        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(clientSocket.getOutputStream())),
                true);

        while (true) {
            String str = in.readLine();          // lecture du message
            if (str.equals("bye")) {
                System.out.println("fermeture du servuer");
                break;
            }
            System.out.println("ECHO = " + str);   // trace locale
            out.println(str);                     // renvoi d'un écho
        }
        
        in.close();
        out.close();
        clientSocket.close();
    }

}
