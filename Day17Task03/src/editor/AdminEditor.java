package editor;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;

import domain.AllUsers;
import domain.User;

public class AdminEditor implements Editor {

	@Override
	public User addUser() {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("username: ");
			String username = sc.next();
			// ako ne postoji stavi na true
			break;
		}
		String repeatPassword = "";
		String password = "";
		while(true)
		{
			System.out.println("password: ");
			password = sc.next();
			char c = password.toUpperCase().charAt(0);
			if ((c >= 'A' && c <='Z')  && password.contains("0123456789"))
				break;
		}
		
		while(!password.equals(repeatPassword))
				{
			System.out.println("repeat password: ");
			repeatPassword = sc.next();
				}
		
		
		
		return null;
	}

	@Override
	public void printAllUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printUser(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User changeUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
