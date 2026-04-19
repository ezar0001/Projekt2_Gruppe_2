package org.projekt2_gruppe_2.repository;

import org.projekt2_gruppe_2.config.InitData;
import org.projekt2_gruppe_2.model.Onske;
import org.projekt2_gruppe_2.model.Onskeseddel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Repository
public class OnskeRepository {
    @Autowired
    InitData initdata;

    @Autowired
    DataSource dataSource;

    //Dette sender informationer til sql database
    public ArrayList<Onske> getAllOnske(){
        ArrayList<Onske> onskeList = new ArrayList<>();
        String sql="SELECT * FROM onske";

        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){

            while(resultSet.next()){
                Onske onske = new Onske();
                onske.setId(resultSet.getInt("id"));
                onske.setOnskeSeddelId(resultSet.getInt("onskeseddel_id"));
                onske.setNavn(resultSet.getString("navn"));
                onske.setPris(resultSet.getInt("pris"));
                onske.setLink(resultSet.getString("link"));
                onske.setAntal(resultSet.getInt("antal"));
                onskeList.add(onske);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return onskeList;
    }


    public Onske getOnskebyID(int id){
        Onske onske = new Onske();
        String sql ="SELECT *FROM onske WHERE id=?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);

            try(ResultSet resultSet=statement.executeQuery()){
                if(resultSet.next()){
                    onske.setId(resultSet.getInt("id"));
                    onske.setNavn(resultSet.getString("navn"));
                    onske.setPris(resultSet.getInt("pris"));
                    onske.setLink(resultSet.getString("link"));
                    onske.setAntal(resultSet.getInt("antal"));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return onske;
    }

    public void deleteOnske(int id){
        String sql="DELETE FROM onske WHERE id=?";

        try(Connection connection=dataSource.getConnection();
            PreparedStatement statement=connection.prepareStatement(sql)){

            statement.setInt(1,id);

            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void save (Onske onske){
        String sql="INSERT INTO onske(navn, pris, link, antal, onskeseddel_id,billed) VALUES (?,?,?,?,?,?)";

        try(Connection connection =dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,onske.getNavn());
            statement.setDouble(2, onske.getPris());
            statement.setString(3, onske.getLink());
            statement.setInt(4,onske.getAntal());
            statement.setInt(5,onske.getOnskeSeddelId());
            statement.setString(6,"gave.jpg");

            statement.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
