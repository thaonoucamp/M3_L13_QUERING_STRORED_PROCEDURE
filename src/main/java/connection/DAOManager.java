package connection;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOManager implements IDAO {
    DAOConnectionSQL connectionSQL = new DAOConnectionSQL();

    @Override
    public void insertUser(User user) {

    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUser() throws SQLException {
        List<User> userList = new ArrayList<>();
        Connection connection = connectionSQL.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from users");
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("user_id");
            String name = rs.getString("user_name");
            String email = rs.getString("user_email");
            String address = rs.getString("user_country");

            userList.add(new User(id, name, email, address));
        }

        return userList;
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
    public User getUserById(int id) throws SQLException {
        User user = null;

        String query = "{call get_user_by_id(?)}";
//1- Thiết lập kết nối;
        Connection connection = connectionSQL.getConnection();
//2- Tạo một câu lệnh bằng cách sử dụng đối tượng kết nối;
        CallableStatement callableStatement = connection.prepareCall(query);
//3- set id;
        callableStatement.setInt(1, id);
//4- thuc thi lenh truy van;
        ResultSet rs = callableStatement.executeQuery();
//5- Xử lý đối tượng ResultSet;
        while (rs.next()) {
            String name = rs.getString("user_name");
            String email = rs.getString("user_email");
            String address = rs.getString("user_country");

            user = new User(id, name, email, address);
        }
        return user;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
//1- viet cau lenh goi lai procedure de insert user;
        String query = "{call insert_user(?, ?, ?)}";
//2- ket noi database;
        Connection connection = connectionSQL.getConnection();
//3- goi lai stored va truyen query;
        CallableStatement callableStatement = connection.prepareCall(query);
        // 4- set cac property cho user moi;
        callableStatement.setString(1, user.getUser_name());
        callableStatement.setString(2, user.getUser_email());
        callableStatement.setString(3, user.getUser_country());

        System.out.println(callableStatement);
// 5- thu thi lenh update;
        callableStatement.executeUpdate();
    }
}
