package main;

import domain.AllUsers;
import domain.Role;
import domain.User;
import editingCollection.EditAdmin;

import java.util.ArrayList;
import java.util.List;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<User> list=new ArrayList<>(); //

		AllUsers allUsers=new AllUsers(list);
		EditAdmin editAdmin=new EditAdmin();
		editAdmin.addUser();
		editAdmin.addUser();
		//editAdmin.addUser();
		editAdmin.printAllUsers();
	}

}
