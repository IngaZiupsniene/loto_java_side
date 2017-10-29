package demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LotoDao {
    private Connection connection;

    public LotoDao() {
        connection = LotoDBUtils.getConnection();
    }


    public List<LotoModel> getAllLotoUsers() {
        List<LotoModel> list = new ArrayList<>();
        try {
            String selectall = "SELECT * FROM loto";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectall);
            while (rs.next()) {

                LotoModel loto= new LotoModel();
                loto.setId(rs.getInt("id"));
                loto.setName(rs.getString("name"));
                loto.setAmount(rs.getInt("amount"));

                list.add(loto);
            }
        } catch (SQLException e) {
            System.out.println("klaida " + e);
        }
        return list;
    }

    public List<LotoModel> getTopWins() {
        List<LotoModel> list = new ArrayList<>();
        try {
            String selectall = "select lower(name), sum(amount) from loto group by lower(name)";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectall);
            while (rs.next()) {

                LotoModel loto= new LotoModel();
              //  loto.setId(rs.getInt("id"));
                loto.setName(rs.getString("lower"));
                loto.setAmount(rs.getInt("sum"));

                list.add(loto);
            }
        } catch (SQLException e) {
            System.out.println("klaida " + e);
        }
        return list;
    }

    public void addloto(LotoModel lotoModel) {
        String insertsql = "INSERT INTO loto (name, amount) VALUES (?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertsql);
            preparedStatement.setString(1, lotoModel.getName());
            preparedStatement.setInt(2, lotoModel.getAmount());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e){
            System.out.println("klaida" +e);
        }
    }
}
