package Dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;


public class Dao_mascotas {
    JdbcTemplate jdbcTemplate;
    Dao con = new Dao();


    public  List consultarMAscotasAdop(){
    List datos = new ArrayList();
    this.jdbcTemplate = new JdbcTemplate(con.conDB());
    String sql = "select id ,nombre from mascotas";
    datos = this.jdbcTemplate.queryForList(sql);
    return datos;

    }
}
