package org.projekt2_gruppe_2.repository;

import org.projekt2_gruppe_2.model.Onskeseddel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Repository
public class OnskeseddelRepository {



    @Autowired
    DataSource dataSource;

    public ArrayList<Onskeseddel> getAllSeddel(){
    ArrayList<Onskeseddel> seddelList = new ArrayList<>();
    String sql="SELECT * FROM onskeseddel";

    try(Connection connection=dataSource.getConnection();
        PreparedStatement statement=connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery()){

        while(resultSet.next()){
            Onskeseddel onskeseddel = new Onskeseddel();
            onskeseddel.setId(resultSet.getInt("id"));
            onskeseddel.setNavn(resultSet.getString("navn"));
            onskeseddel.setDato(resultSet.getDate("dato").toLocalDate());
            seddelList.add(onskeseddel);
        }

    }catch (SQLException e){
        e.printStackTrace();
    }
    return seddelList;
    }


    public Onskeseddel getSeddelbyID(int id){
      Onskeseddel seddel = new Onskeseddel();
      String sql ="SELECT *FROM onskeseddel WHERE id=?";

      try(Connection connection = dataSource.getConnection();
      PreparedStatement statement = connection.prepareStatement(sql)){
          statement.setInt(1,id);

          try(ResultSet resultSet=statement.executeQuery()){
              if(resultSet.next()){
                  seddel.setId(resultSet.getInt("id"));
                  seddel.setNavn(resultSet.getString("navn"));
                  seddel.setDato(resultSet.getDate("dato").toLocalDate());
              }
          }
      }catch (SQLException e){
          e.printStackTrace();
      }
      return seddel;
    }

    public void deleteSeddel(int id){
        String sql="DELETE FROM onskeseddel WHERE id=?";

        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)){

            statement.setInt(1,id);

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

public void save (Onskeseddel seddel){
     String sql="INSERT INTO onskeseddel(navn, dato, bruger_id) VALUES (?,?,?)";

     try(Connection connection =dataSource.getConnection();
     PreparedStatement statement = connection.prepareStatement(sql)){
        statement.setString(1,seddel.getNavn());
        statement.setDate(2, Date.valueOf(seddel.getDato()));
        statement.setInt(3, 1);

        statement.executeUpdate();

    }catch(SQLException e){
         e.printStackTrace();
     }
}

}
