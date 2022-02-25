package editor;

import java.util.Scanner;

import domain.AllUsers;
import domain.User;

public class AdminEditor implements Editor {

	@Override
	public User addUser() {
		Scanner sc = new Scanner(System.in);
		String username;
		while(true)
		{
			System.out.println("username: ");
			username = sc.next();
			try {
				if(!domain.AllUsers.containUser(username))
					break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		
		System.out.println("First name: ");
		String firstname = sc.next();
		System.out.println("Last name: ");
		String lastname = sc.next();
		System.out.println("Your role: (ADMIN or EDITOR)");
		String role = sc.next();
		
		User user = new User(firstname, lastname, username, password, role);
		AllUsers.userList.add(user);
		return user;
	}

	@Override
	public void printAllUsers() {
		
		System.out.println("All Users:");
		for(User u : AllUsers.userList)
			System.out.println(u.toString());
	}

	@Override
	public void printUser(User u) {
		System.out.println(u.toString());
		
	}

	@Override
	public User changeUser(User u) {
		System.out.println("What data do you want to change? (firstname, lastname, role)");
		Scanner sc = new Scanner(System.in);
		String data = sc.next();
		System.out.println("New value:");
		String change = sc.next();
		if(data.equals("firstname"))
			u.setFirstName(change);
		if(data.equals("lastname"))
			u.setLastName(change);
		if(data.equals("role"))
			u.setRole(change);
		
		return null;
	}

	@Override
	public User deleteUser(User u) {
		AllUsers.userList.remove(u);
		return null;
	}
	
}
