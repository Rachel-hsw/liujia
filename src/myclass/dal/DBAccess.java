package myclass.dal;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.sql.DataSource;
import javax.naming.*;

public class DBAccess {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private PreparedStatement prpSql=null;
    public DBAccess() {}

    public Connection getConn() {
        if (conn == null) {
            getConnection();
        }
        return conn;
    }
  
    public void getConnection() {
        try {
           Context InitCtxctx = new InitialContext();
           Context ctx=(Context) InitCtxctx .lookup("java:comp/env");
           Object obj=(Object)ctx.lookup("jdbc/dataExam");
           
                javax.sql.DataSource ds = (javax.sql.DataSource)obj;
                this.conn = ds.getConnection();
                this.stmt = this.conn.createStatement();
                System.out.println("数据库连接建立（连接池）！");
        }
        catch (NamingException ex1) {
            System.out.println("请检查数据库连接池配置是否正确！");
            ex1.printStackTrace();
        }
        catch (SQLException ex2) {
            System.out.println("请检查数据库是否启动！");
            ex2.printStackTrace();
        }
    }
   

    public ResultSet query(String strSql) {
       
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(strSql);
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return rs;
        }
    }
  
    public ResultSet query(PreparedStatement prpSql) {
   
        this.prpSql=prpSql;
        ResultSet rs = null;
        try {
            rs = this.prpSql.executeQuery();
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return rs;
        }
    }

    public boolean insert(String[] sqls) {
        boolean breturn = false;
        try {
            conn.setAutoCommit(false);
            for (int i = 0; i < sqls.length; i++) {
                if (sqls[i] != null) {
                    stmt.addBatch(sqls[i]);
                }
            }
            stmt.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);
            breturn = true;
        } catch (SQLException ex) {
        }
        return breturn;
    }


    public int executeSql(String strSql) {
        int result = 0;
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(strSql);            
        } catch (SQLException ex) {
            System.out.println("产生异常，：at DBAccess.executeSql()");
            ex.printStackTrace();
            result= -1;
        }
        return result;
    }

    public int executeSql(PreparedStatement prpSql){
        int result = 0;
        try {
            this.prpSql=prpSql;
            result = this.prpSql.executeUpdate();            
        } catch (SQLException ex) {
            System.out.println("产生异常，：at DBAccess.executeSql()");
            ex.printStackTrace();
            result=-1;
        }
        return result;
    	
    }


    public boolean executeSql(String[] sqls) {
        boolean breturn = false;
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            for (int i = 0; i < sqls.length; i++) {
                if (sqls[i] != null) {
                   ;
                    stmt.addBatch(sqls[i]);
                }
            }
            stmt.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);
            breturn = true;
        } catch (SQLException ex) {
            System.out.println("产生异常，：at DBAccess.executeSql()");
            ex.printStackTrace();
        }
        return breturn;
    }

 
    public void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
            if(prpSql!=null){
            	prpSql.close();
            	prpSql=null;
            }
            	
            System.out.println("数据库连接关闭！");
        } catch (SQLException ex) {
            System.out.println("产生异常，：at DBAccess.executeSql()");
            ex.printStackTrace();
        }
    }
 

    public static String getSysDate() {
        DBAccess dba = new DBAccess();
        String sql = "select sysdate() sysdate;";
        try {
            dba.getConnection();
            ResultSet rs = dba.query(sql);
            String currentDate = null;
            if (rs.next()) {
                currentDate = rs.getString("sysdate");
            }
            return currentDate;
        } catch (SQLException ex) {
            System.out.println("产生异常，：at DBAccess.executeSql()");
            ex.printStackTrace();
            return null;
        } finally {
            dba.closeConnection();
        }
    }

}
