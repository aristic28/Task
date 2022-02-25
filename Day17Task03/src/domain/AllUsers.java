package domain;

import java.util.List;

public class AllUsers {
    public static List<User> userList;

    public AllUsers(List<User> userList){
        this.userList=userList;
    }

    public static boolean containUser(String username){
        for(User u : userList)
            if(u.getUsername().equals(username))
                return true;
        return false;

    }

}
