/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronobjectpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.kobitxu.patronobjectpool.impl.poolable.JDBCConnectionPool;

/**
 *
 * @author joseph
 */
public class Aplicacion {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		// Do something...

		// Create the ConnectionPool:
		JDBCConnectionPool pool = new JDBCConnectionPool("org.hsqldb.jdbcDriver", "jdbc:hsqldb:mem:test", "sa", "");

		// Get a connection:
		Connection con = pool.checkOut();

		// Use the connection		
		
		try (Statement statement = con.createStatement()) {
			
			statement.execute("create table employee (name varchar(100))");
            statement.execute("insert into employee (name) values ('Joseph Reyes')");
            statement.execute("insert into employee (name) values ('Jackson Moreira')");
            statement.execute("insert into employee (name) values ('Jack v2.0')");
            
            statement.execute("select * from employee");
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		// Return the connection:
		pool.checkIn(con);
	}
}