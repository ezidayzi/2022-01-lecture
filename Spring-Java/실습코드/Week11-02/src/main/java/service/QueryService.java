package service;

import model.BookInfo;
import model.CustomerInfo;

import java.util.Date;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryService {
    public static void main(String args[]) {
        QueryService so = new QueryService();
    }

    Connection con;

    String url = "jdbc:mysql://localhost/jdbctest?useUnicode=true&characterEncoding=utf8";
    String userid = "root";
    String passwd = "1126";

    {
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

    public void insertCustomer(CustomerInfo customerInfo) {
        String query =
                "INSERT INTO Customer(custid, name, address, phone) " +
                "VALUES (0, '" + customerInfo.getName()
                + "', '" + customerInfo.getAddress()
                + "', '" + customerInfo.getPhone() + "')";
        System.out.println(query);

        try {
            Statement stmt = con.createStatement();
            int result = stmt.executeUpdate(query);
            System.out.println("성공적으로 추가되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertOrder(int custId, int bookId, int saleprice) {
        Date date = new Date();
        String orderdate = String.format("%1$tY-%1$tm-%1$td", date);

        String query =
                "INSERT INTO ORDERS(orderid, custid, bookid, saleprice, orderdate) " +
                        "VALUES (0, '" + custId
                        + "', '" + bookId
                        + "', '" + saleprice
                        + "', '" + orderdate
                        + "')";
        System.out.println(query);

        try {
            Statement stmt = con.createStatement();
            int result = stmt.executeUpdate(query);
            System.out.println("성공적으로 추가되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBook(BookInfo bookInfo) {
        String query =
                "INSERT INTO book(bookid, bookname, publisher, price) " +
                        "VALUES (0, '" + bookInfo.getBookname()
                        + "', '" + bookInfo.getPublisher()
                        + "', '" + bookInfo.getPrice() + "')";

        System.out.println(query);

        try {
            Statement stmt = con.createStatement();
            int result = stmt.executeUpdate(query);
            System.out.println("성공적으로 추가되었습니다.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public BookInfo getBookInfo(int bookid) {
        String query = "select * from book where bookid = " + bookid;
        BookInfo bookInfo = new BookInfo();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                bookInfo = new BookInfo(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookInfo;
    }

    public CustomerInfo getCustomerInfo(int custid) {
        String query = "select * from customer where custid = " + custid;
        CustomerInfo customerInfo = new CustomerInfo();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                customerInfo = new CustomerInfo(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerInfo;
    }

    public List<BookInfo> getAllBooks() {
        String query = "SELECT * FROM book";
        List<BookInfo> list = new ArrayList<BookInfo>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                BookInfo bookInfo = new BookInfo(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4));
                list.add(bookInfo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<CustomerInfo> getAllCustomers(){
        String query = "SELECT * FROM customer";
        List<CustomerInfo> list = new ArrayList<CustomerInfo>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CustomerInfo customerInfo = new CustomerInfo(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
                list.add(customerInfo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
