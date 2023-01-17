package _02_Chat_Application;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import _00_Click_Chat.networking.Client;
import _00_Click_Chat.networking.Server;

/*
 * Using the Click_Chat example, write an application that allows a server computer to chat with a client computer.
 */

public class ChatApp {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	
	Server server;
	Client client;
	
	void start (){
		if (JOptionPane.showConfirmDialog(null, "Would you like to host?", "Chatting", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			server = new Server(8080);
			frame.setTitle("Server chat");
			System.out.println("New server with ip of " + server.getIPAddress() + " and the port = \n" + server.getPort());
			button.addActionListener((e) -> {
				server.sendClick();
			});
			frame.add(panel);
			panel.add(button);
			frame.setVisible(true);
			frame.setSize(500, 500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			server.start();
		}
		else {
			frame.setTitle("Client chat");
			String ip = JOptionPane.showInputDialog("What's the ip address?");
			String tempPort = JOptionPane.showInputDialog("What's the port?");
			int port = Integer.parseInt(tempPort);
			client = new Client(ip, port);
			button.addActionListener((e) -> {
				client.sendClick();
			});
			frame.add(panel);
			panel.add(button);
			frame.setVisible(true);
			frame.setSize(500, 500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			client.start();
		}
		
		

	}
	
	
	public static void main (String [] args) {
		ChatApp c = new ChatApp();
		c.start();
	}
}
