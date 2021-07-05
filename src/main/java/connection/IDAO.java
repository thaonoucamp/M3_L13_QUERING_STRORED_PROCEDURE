package connection;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IDAO {
    void insertUser(User user);

    User selectUser(int id);

    List<User> selectAllUser() throws SQLException;

    boolean deleteUser(int id);

    boolean update(User user);

    User getUserById(int id) throws SQLException;

    void insertUserStore(User user) throws SQLException;
}
