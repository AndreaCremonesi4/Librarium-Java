package com.librarium.application.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.librarium.application.entity.Autore;
import com.librarium.database.generated.org.jooq.tables.Autori;

public class DatabaseHelper {
	
	private static final String DATABASE_PATH = "/data/librarium.db";
	
	public static void updateAutore(Autore autore) {
		try (Connection conn = connect()){
			DSLContext ctx = DSL.using(conn, SQLDialect.MYSQL);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static ArrayList<Autore> leggiAutori() {		
		try (Connection conn = connect()){
			
			DSLContext ctx = DSL.using(conn, SQLDialect.MYSQL);
			Result<Record> result = ctx.select().from(Autori.AUTORI).fetch();
			
			ArrayList<Autore> autori = new ArrayList<Autore>();
			for(Record r : result) {
				autori.add(new Autore((int)r.get("id"), (String)r.get("nome")));
			}
			
			return autori;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	private static Connection connect() {
		System.out.println();
		String url = "jdbc:sqlite:" + System.getProperty("user.dir") + DATABASE_PATH;
		Connection conn = null;
		
		try{
			conn = DriverManager.getConnection(url);
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
}
