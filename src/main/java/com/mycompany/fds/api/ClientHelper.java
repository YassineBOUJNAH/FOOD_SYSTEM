
package com.mycompany.fds.api;

import com.mycompany.fds.model.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientHelper {
    public static ArrayList<Client> getClient(ResultSet rs) throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();

        while(rs.next()) {

            int id=rs.getInt("id_client");
            String username=rs.getString("username");
            String nom = rs.getString("nom_client");
            String password = rs.getString("password");
            Client client = new Client(id, username, password);
            clients.add(client);
        }
        return clients;
    }
}
