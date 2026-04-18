package org.projekt2_gruppe_2.repository;

import org.projekt2_gruppe_2.config.InitData;
import org.projekt2_gruppe_2.model.Onskeseddel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class OnskeseddelRepository {


    @Autowired
    InitData initdata;

    @Autowired
    DataSource dataSource;

    //Dette sender informationer til sql database
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
}
