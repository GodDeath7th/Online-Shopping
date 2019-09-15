package daoImpl;

import dao.AddressDao;
import entity.Address;
import util.JdbcUtils;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressDaoImpl implements AddressDao {
    @Override
    public void addAddress(Address address) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JdbcUtils.getconn();
            String sql = "insert into address(id,userId,accept,province,city,area,address,zip,phoneNumber,mobile,isDefault)values(?,?,?,?,?,?,?,?,?,?,?);";
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, address.getId());
            preparedStatement.setString(2, address.getUserId());
            preparedStatement.setString(3, address.getAccept());
            preparedStatement.setString(4, address.getProvince());
            preparedStatement.setString(5, address.getCity());
            preparedStatement.setString(6,address.getArea());
            preparedStatement.setString(7,address.getAddress());
            preparedStatement.setString(8,address.getZip());
            preparedStatement.setString(9,address.getPhoneNumber());
            preparedStatement.setString(10,address.getMobile());
            preparedStatement.setString(10,address.getIsDefault());
            preparedStatement.executeUpdate();

        } catch (URISyntaxException |SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(preparedStatement, connection);
        }
    }
}
