package database;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class MainDatabase {
    public static void main(String[] args) {

        Connection connection = new SQLConnection().getConnection();
        CRUDStatementSQL crudStatementSQL = new CRUDStatementSQL(connection);
        List<String> tools = new ArrayList<>();
        MetaData metaData = new MetaData();
        System.out.println(metaData.getColumnNamesFromDB(connection, "Meble"));

    }
}
