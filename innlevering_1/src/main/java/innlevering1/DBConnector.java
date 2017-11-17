package innlevering1;


import java.sql.*;

public class DBConnector {
    public static void main (String [] args)  {


        try {
            //db adresse, brukernavn og passord
            String DB_URL = "jdbc:mysql://localhost:8889/WesterEdit";
            String USER = "root";
            String PASSWORD = "root";
            // con oppretter DriverManager, bruker info fra stringene over
            Connection con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            // stmt oppretter en createStatement til databasen
            Statement stmt = con.createStatement();
            //rs oppretter statement som kjører query
            ResultSet rs = stmt.executeQuery("select * from Subject");

            while(rs.next())
                //så lenge det er noen resultater fra rs, så går til neste rad?
                //henter data fra kolonnene
                System.out.println(rs.getString(1) + " "
                        + rs.getString(2) + " "
                        + rs.getInt(3) + " "
                        + rs.getString(4) + " "
                        + rs.getString(5) + " "
                );
                con.close();
            } catch(Exception e) {
                System.out.println(e);
        }
    }

    static boolean persistSubject(Subject subject) {
        try {
            //db adresse, brukernavn og passord
            String DB_URL = "jdbc:mysql://localhost:8889/WesterEdit";
            String USER = "root";
            String PASSWORD = "root";
            // con oppretter DriverManager, bruker info fra stringene over
            Connection con = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            //insert sql code
            String insertTableSQL = "INSERT INTO SUBJECT"
                    + "(EmneKode, EmneNavn, AntallElever, Laerer, Rom) VALUES"
                    + "(?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
            //prepared statements, sikret mot sql injection
            preparedStatement.setString(1, subject.getEmneKode());
            preparedStatement.setString(2, subject.getEmneNavn());
            preparedStatement.setInt(3, subject.getElever());
            preparedStatement.setString(4, subject.getForeleser());
            preparedStatement.setString(5, subject.getRomNr());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
