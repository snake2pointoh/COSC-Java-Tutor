package src.other;

import java.sql.*;

public class TestProgram
{

    public static void main(String[] args)
    {
        //Note that SPIT is you saskpolytech account - including your number - the part before the @ in your email address
        String DB_URL = "jdbc:mysql://10.36.105.182/bryce";

        String user = "Bryce";
        String sPass = "Bryce";

        try (Connection con = DriverManager.getConnection(DB_URL, user, sPass))
        {
            Statement obStmt = con.createStatement();

                   String sInsert = String.format("insert into student1(firstName,lastName) values ('%s', '%s')",
                    "Jack", "Nicklaus");
                    obStmt.execute(sInsert);
                sInsert = String.format("insert into student1(firstName,lastName) values ('%s', '%s')",
                    "Gary", "Player");
              obStmt.execute(sInsert);

              ResultSet obRes = obStmt.executeQuery("select * from student1");

              while (obRes.next())
              {
                  System.out.printf("Name: %s,%s\n", obRes.getString("lastName"), obRes.getString("firstName"));

              }

              obStmt.execute("delete from student1");




        }
        catch (SQLException exp)
        {
            exp.printStackTrace();
        }

    }

}
