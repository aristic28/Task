package editingCollection;

import domain.User;

public interface EditEditor {
	User addUser();
	void printAllUsers();
	void printUser(User u);
	User changeUser(User u);
	User deleteUser(User u);
}
