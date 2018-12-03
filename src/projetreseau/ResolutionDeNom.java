/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetreseau;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author pedago
 */
public class ResolutionDeNom {

	public static void main(String[] args) {
		InetAddress adress2;
		System.out.println("hello world");
		try {
			adress2 = InetAddress.getLocalHost();
			System.out.println(adress2.getHostName() + " : " + adress2.getHostAddress());
			

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
