//package com.example.IdCard.repository.lmpl;
//
//import com.example.IdCard.model.entity.IdCard;
//import com.example.IdCard.repository.IdCardRepository;
//import org.springframework.stereotype.Repository;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Repository
//public class IdCardRepositorylmplOld implements IdCardRepository {
//
//
//    @Override
//    public List<IdCard> getAll() {
//        try {
//            Connection conn = getConnection();
//
//            String query = "select i.id, i.name, i.surname, i.fin_code, i.series, i.serialnumber from id_card i;";
//            Statement statement = conn.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//
//            List<IdCard> idCards = new ArrayList<>();
//
//            while (resultSet.next()) {
//                IdCard idCard = IdCard.builder()
//                        .id(resultSet.getLong("id"))
//                        .name(resultSet.getString("name"))
//                        .surname(resultSet.getString("surname"))
//                        .age(resultSet.getInt("age"))
//                        .finCode(resultSet.getString("fin_code"))
//                        .series(resultSet.getString("series"))
//                        .serialNumber(resultSet.getString("serialnumber"))
//                        .build();
//                idCards.add(idCard);
//            }
//
//            conn.close();
//            return idCards;
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return Collections.emptyList();
//        }
//
//
//    }
//
//    @Override
//    public IdCard getById(Long id) {
//        try {
//            Connection conn = getConnection();
//
//            String query = "SELECT i.id, i.name, i.surname, i.age, i.fin_code, i.series, i.serialnumber FROM vs_learning.id_card i;";
//            Statement statement = conn.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//
//            IdCard idCard = IdCard.builder()
//                    .id(resultSet.getLong("id"))
//                    .name(resultSet.getString("name"))
//                    .surname(resultSet.getString("surname"))
//                    .age(resultSet.getInt("age"))
//                    .finCode(resultSet.getString("fin_code"))
//                    .series(resultSet.getString("series"))
//                    .serialNumber(resultSet.getString("serialnumber"))
//                    .build();
//
//            conn.close();
//            return idCard;
//
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public boolean insert(IdCard idCard) {
//
//        try {
//            Connection conn = getConnection();
//
//            String query = """
//                    insert into id_card(name, surname, age, fin_code, series, serialnumber)
//                    values( ?, ?, ?, ?, ?, ?);
//                    """;
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//            preparedStatement.setString(1, idCard.getName());
//            preparedStatement.setString(2, idCard.getSurname());
//            preparedStatement.setInt(3, idCard.getAge());
//            preparedStatement.setString(4, idCard.getFinCode());
//            preparedStatement.setString(5, idCard.getSeries());
//            preparedStatement.setString(6, idCard.getSerialNumber());
//
//            preparedStatement.executeUpdate();
//
//            conn.close();
//            return true;
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return false;
//        }
//
//
//
//
//    }
//
//    @Override
//    public boolean update(IdCard idCard) {
//        try {
//            Connection conn = getConnection();
//            String query = "update id_card i\n" +
//                    "set  i.name = ?,i.surname = ?, i.age = ?, i.fin_code = ?,series = ?, serialnumber =? \n" +
//                    "where i.id =?";
//
//
//         PreparedStatement preparedStatement = conn.prepareStatement(query);
//        preparedStatement.setString(1, idCard.getName());
//        preparedStatement.setString(2, idCard.getSurname());
//        preparedStatement.setInt(3, idCard.getAge());
//        preparedStatement.setString(4, idCard.getFinCode());
//        preparedStatement.setString(5, idCard.getSeries());
//        preparedStatement.setString(6, idCard.getSerialNumber());
//        preparedStatement.setLong(7, idCard.getId());
//
//        preparedStatement.executeUpdate();
//
//        conn.close();
//        return true;
//
//    } catch(
//    Exception ex)
//
//    {
//        ex.printStackTrace();
//        return false;
//    }
//
//}
//
//    @Override
//    public boolean updateAge(Long id, Integer age) {
//
//
//        try {
//            Connection conn = getConnection();
//
//            String query = """
//                    UPDATE vs_learning.id_card i  SET i.age = ? WHERE i.id = ?;
//                    """;
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//            preparedStatement.setInt(1, age);
//            preparedStatement.setLong(2, id);
//
//            preparedStatement.executeUpdate();
//
//            conn.close();
//            return true;
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return false;
//        }
//
//    }
//
//    @Override
//    public boolean delete(Long id) {
//        try {
//            Connection conn = getConnection();
//
//            String query = "delete from id_card i \n" +
//                    "where i.id = ?";
//            PreparedStatement preparedStatement = conn.prepareStatement(query);
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//
//            conn.close();
//            return true;
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return false;
//        }
//    }
//
//
//    private Connection getConnection() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            String url = "jdbc:mysql://localhost:3306/vs_learning?useSSL=false";
//            String username = "root";
//            String pasword = "Sem@2024";
//            return DriverManager.getConnection(url, username, pasword);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            throw new RuntimeException("exception occurred");
//        }
//    }
//}
//
//
//
