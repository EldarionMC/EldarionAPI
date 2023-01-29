package fr.eldarion.api.storage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

public class SQLite {

	private JavaPlugin instance;
	private String dbName;
	private Connection connection;
	
	
	public SQLite(JavaPlugin instance, String dbName) {
		this.instance = instance;
		this.dbName = dbName;
		
		this.connection = initializeConnection();
	}
	
	
	public Connection getConnection() {
		return this.connection;
	}
	
	
	private Connection initializeConnection() {
		File dataFolder = new File(instance.getDataFolder(), dbName + ".db");
		
        if (!dataFolder.exists()){
            try {
                dataFolder.createNewFile();
            } catch (IOException e) {
                instance.getLogger().log(Level.SEVERE, "File write error: " + dbName + ".db");
            }
        }
        
        try {
            if(connection != null && !connection.isClosed()) {
                return connection;
            }
            
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dataFolder);
            
            return connection;
        } catch (SQLException ex) {
            instance.getLogger().log(Level.SEVERE, "SQLite exception on initialize", ex);
        } catch (ClassNotFoundException ex) {
            instance.getLogger().log(Level.SEVERE, "You need the SQLite JBDC library. Google it. Put it in /lib folder.");
        }
        
        return null;
	}
	
	
	public void createTable(String tableName, String[] fields) {
		String query = "CREATE TABLE IF NOT EXISTS " + tableName + " (";
		
		for(String field : fields) {
			query += field;
		}
		
		query += ");";
		
		executeNotSafeUpdateQuery(query);
	}
	
	private void executeNotSafeUpdateQuery(String query) {
		try {
            Statement s = connection.createStatement();
            s.executeUpdate(query);
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public ResultSet executeQuery(PreparedStatement statement) {
		ResultSet rs = null;
		
		try {
            rs = statement.executeQuery();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return rs;
	}
	
	public void executeUpdateQuery(PreparedStatement statement) {
		try {
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
}






























