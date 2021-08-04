package com.example.assignment2_su;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

//@Repository 로 써도됨
@Component
public class PizzaDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Pizza> pizzaRowMapper = new RowMapper<Pizza>() {
        @Override
        public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
            Pizza pizza = new Pizza();
            pizza.setOrderNumber(rs.getInt("OrderNumber"));
            pizza.setPizzaNumber(rs.getInt("pizzaNumber"));
            pizza.setOrderQuantity(rs.getInt("orderQuantity"));
            pizza.setOrderStatus(rs.getString("orderStatus"));
            return pizza;
        }
    };

    public void add(Pizza pizza) throws SQLException {
        this.jdbcTemplate.update("insert into pizza_order(OrderNumber, pizzaNumber,orderQuantity,orderStatus) values(?,?,?,?)",
                pizza.getOrderNumber()
                , pizza.getPizzaNumber()
                , pizza.getOrderQuantity()
                , pizza.getOrderStatus());
    }


}
