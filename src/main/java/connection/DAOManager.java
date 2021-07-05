package connection;

import model.User;

import java.util.List;

public class DAOManager implements IDAO{
    DAOConnectionSQL connectionSQL = new DAOConnectionSQL();

    @Override
    public void insertUser(User user) {

    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selctAllUser() {
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void insertUserStore(User user) {

    }
}
