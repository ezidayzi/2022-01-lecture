import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {
    Connection con;

    public DBTest() {
        String url = "jdbc:mysql://localhost/jdbctest?useUnicode=true&characterEncoding=utf8";
        String userid = "root";
        String passwd = "1126";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL Server JDBC Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Connecting to database ...");
            con = DriverManager.getConnection(url, userid, passwd);
            System.out.println("Connected ...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void sqlRun() {
        /*
        2번
         */
        String query = "SELECT * FROM Book";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("ID \t\tBook NAME \t\tPUBLISHER \tPRICE ");
            while (rs.next()) { System.out.println(
                    rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) +
                            "\t" + rs.getInt(4)); }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*
        3번
         */
//        String query = "SELECT * FROM Customer";
//        String updateQuery = "UPDATE Customer SET phone= '000-9999-9999' WHERE phone is null";
//        try {
//            Statement stmt = con.createStatement();
//            int result = stmt.executeUpdate(updateQuery);
//            ResultSet rs = stmt.executeQuery(query);
//            System.out.println("ID \t\tNAME \t\tAddress \t\tPhone ");
//            while (rs.next()) { System.out.println(
//                    rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) +
//                            "\t\t" + rs.getString(4)); }
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /*
        4번
         */
        // 특정 고객(학습자가 선택 가능) 이 구매한 책 목록 (주의: 조회 결과가 없으면 안됨)
//        String query = "select * from book inner join orders on book.id = orders.bookid where orders.custid = 1 order by book.id asc";
//        try {
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) { System.out.println(
//                    rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) +
//                            "\t\t" + rs.getString(4)); }
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        /*
        4번
        */
        //특정 책(학습자가 선택 가능) 을 구매한 고객 목록 (주의: 조회 결과가 없으면 안됨)
//        String query = "select * from orders od join customer ct on od.custid  = ct.custid where od.bookid = 10 order by od.custid";
//        try {
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) { System.out.println(
//                    rs.getInt(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3) +
//                            "\t\t" + rs.getString(4)); }
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }
    public static void main(String args[]) {
        DBTest so = new DBTest(); so.sqlRun();
    }
}