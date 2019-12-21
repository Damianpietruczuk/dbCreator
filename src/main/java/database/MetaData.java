package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetaData {

        DatabaseMetaData dbmd = null;
    public List<String> getTableNamesFromDB(Connection connection){
        List<String> tableNames=new ArrayList<>();
        try {

            dbmd = connection.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = dbmd.getTables("Magazyn", "dbo", "%", types);
            while (rs.next()) {
                tableNames.addAll(Arrays.asList(rs.getString("TABLE_NAME").split("//s+")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return tableNames;
    }

    public List<String> getColumnNamesFromDB(Connection connection, String tablename){
        List<String> columnNames=new ArrayList<>();
        try {
            dbmd = connection.getMetaData();
            ResultSet rs = dbmd.getColumns("Magazyn", "dbo", tablename, "%");
            while (rs.next()) {
                columnNames.addAll(Arrays.asList(rs.getString("COLUMN_NAME").split("//s+")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return columnNames;
    }


}
