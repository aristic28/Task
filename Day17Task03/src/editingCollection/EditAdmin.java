package editingCollection;

import java.util.Scanner;

import domain.AllUsers;
import domain.Role;
import domain.User;

public class EditAdmin implements EditEditor {

	public boolean containsDigit(String s){
		for(int i=0;i<s.length();i++)
			if(Character.isDigit(s.charAt(i)))
				return true;
		return false;
	}

	@Override
	public User addUser() {
		int counterForLogin=4;
		Scanner sc = new Scanner(System.in);
		String username;
		while(true)
		{
			System.out.println("username: ");
			username = sc.next();
			try {
				if(!domain.AllUsers.containUser(username))
					break;
				counterForLogin-=1;
				System.out.println("Your username somebody use. Please try different username, you have "+counterForLogin+ " chances");
				if(counterForLogin==0) {
					System.err.println("You dont have any chances");
					System.exit(1);

				}
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
			if ((c >= 'A' && c <='Z')  && containsDigit(password))
				break;
			counterForLogin-=1;
			System.out.println("Your password is weak, try again, you have "+counterForLogin+" chances");
			if(counterForLogin==0) {
				System.err.println("You dont have any chances");
				System.exit(1);

			}
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
		Role r=null;
		switch (role){
			case "ADMIN": r=Role.ADMIN;
			case "EDITOR": r=Role.EDITOR;
		}
		User user = new User(firstname, lastname, username, password, r);
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
		if(data.equals("role")) {
			switch(change) {
				case "ADMIN":
					u.setRole(Role.ADMIN);
				case "EDITOR":
					u.setRole(Role.EDITOR);
			}
		}
		return null;
	}

	@Override
	public User deleteUser(User u) {
		AllUsers.userList.remove(u);
		return null;
	}
	
}
