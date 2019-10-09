package ua.flatsandroom;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class House {
    private List<Flat> list;


    public House() {

    }

    public void addHouse(List<Flat> sourselist) throws ClassNotFoundException {
        this.list = sourselist;
        DbProperties props = new DbProperties();
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection conn = DriverManager.getConnection(props.getUrl(), props.getUser(), props.getPassword())) {
            try (Statement st = conn.createStatement()) {
                st.execute("CREATE TABLE IF NOT EXISTS flats (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                        "area VARCHAR(128) DEFAULT NULL,\n" +
                        "address VARCHAR(128) DEFAULT NULL,\n" +
                        "square DOUBLE DEFAULT NULL,\n" +
                        "numberOfRooms INT DEFAULT NULL,\n" +
                        "price DOUBLE NOT NULL)");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(props.getUrl(), props.getUser(), props.getPassword())) {
            conn.setAutoCommit(false);
            try {
                try (PreparedStatement ps = conn.prepareStatement("INSERT INTO flats (area, address, square, numberOfRooms, price) VALUES (?, ?, ?, ?, ?)")) {
                    if (list.size() != 0) {
                        for (Flat fl : list) {
                            ps.setString(1, fl.getArea());
                            ps.setString(2, fl.getAddress());
                            ps.setDouble(3, fl.getSquare());
                            ps.setInt(4, fl.getNumberOfRooms());
                            ps.setDouble(5, fl.getPrice());
                            ps.executeUpdate();
                        }
                    }
                    conn.commit();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                conn.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Flat> getHouse() {
        return list;
    }

    public List<Flat> getFlats(String areain, String addressin, String squarein) throws ClassNotFoundException {
        List<Flat> setFl = new ArrayList<>();
        DbProperties props = new DbProperties();
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection conn = DriverManager.getConnection(props.getUrl(), props.getUser(), props.getPassword())) {
            if (areain.equals("") && addressin.equals("") && squarein.equals("")) {

                try (PreparedStatement ps = conn.prepareStatement("SELECT area, address, square, numberOfRooms, price FROM flats")) {
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        Flat flat = new Flat(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getDouble(5));
                        setFl.add(flat);
                    }
                    return setFl;

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (!areain.equals("") && addressin.equals("") && squarein.equals("")) {

                try (PreparedStatement ps = conn.prepareStatement("SELECT area, address, square, numberOfRooms, price FROM flats where area =? ")) {
                    ps.setString(1, areain);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        Flat flat = new Flat(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getDouble(5));
                        setFl.add(flat);
                    }
                    return setFl;

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (areain.equals("") && !addressin.equals("") && squarein.equals("")) {
                try (PreparedStatement ps = conn.prepareStatement("SELECT area, address, square, numberOfRooms, price FROM flats where address =? ")) {
                    ps.setString(1, addressin);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        Flat flat = new Flat(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getDouble(5));
                        setFl.add(flat);
                    }
                    return setFl;

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (areain.equals("") && addressin.equals("") && !squarein.equals("")) {
                try (PreparedStatement ps = conn.prepareStatement("SELECT area, address, square, numberOfRooms, price FROM flats where square =? ")) {
                    ps.setString(1, squarein);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        Flat flat = new Flat(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getDouble(5));
                        setFl.add(flat);
                    }
                    return setFl;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}