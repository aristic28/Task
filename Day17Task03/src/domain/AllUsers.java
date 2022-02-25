package domain;

import java.util.List;

public class AllUsers {
    List<User> userList;

    public AllUsers(List<User> userList){
        this.userList=userList;
    }

    public boolean containUser(String username){
        for(User u : userList)
            if(u.getUsername().equals(username))
                return true;
        return false;

    }

}
