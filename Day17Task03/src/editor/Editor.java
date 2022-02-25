package editor;

import domain.User;

public interface Editor {
	User addUser();
	void printAllUsers();
	void printUser(User u);
	User changeUser(User u);
	User deleteUser(User u);
}
