package connection;

import model.User;

import java.util.List;

public interface IDAO {
    void insertUser(User user);

    User selectUser(int id);

    List<User> selctAllUser();

    boolean deleteUser(int id);

    boolean update(User user);

    User getUserById(int id);

    void insertUserStore(User user);
}
