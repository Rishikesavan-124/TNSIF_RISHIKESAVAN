package com.jdbc;


import java.sql.*;

public class JDBC_Connect {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/Studentsdetails";
        String username = "postgres";
        String password = "rishi";

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            // ✅ Correct table name
            String query = "SELECT * FROM student_details";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("student_id");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                int age = rs.getInt("age");
                Date dob = rs.getDate("dob");
                String dept = rs.getString("department");
                String email = rs.getString("email");

                System.out.println(id + " | " + first + " " + last + " | " + age + " | " + dob + " | " + dept + " | " + email);
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}