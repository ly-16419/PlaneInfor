package PlaneInformatiom.dao.impl;

import PlaneInformatiom.bean.Flight;
import PlaneInformatiom.dao.IFlightDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class FlightDaoIml implements IFlightDao {
    @Override
    public void insertFlight(Flight flight) throws SQLException {
        //System.out.print("Dao"+flight.toString());

        String url="jdbc:oracle:thin:@localhost:1521:orcl";
        String username="opts";
        String password="opts1234";
        Connection conn=DriverManager.getConnection(url,username,password);
        String sql="insert into flight values(?,?,?,?,?,?,?)";

        PreparedStatement pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,flight.getID());
        pstmt.setString(2,flight.getFilghtID());
        pstmt.setString(3,flight.getPlaneType());
        pstmt.setInt(4,flight.getCurrentSeatsNum());
        pstmt.setString(    5,flight.getDepartureAirPort());
        pstmt.setString(6,flight.getDestinationAirPort());
        pstmt.setString(7,flight.getDepartureTime());

        pstmt.executeUpdate();
    }

    @Override
    public Set<Flight> getAllFlight() {
        return null;
    }

    @Override
    public Flight getFlightByDepartureTime(String departureTime) {
        return null;
    }

    @Override
    public Flight getFlightByDepartureAirPort(String departureAirPort) {
        return null;
    }

    @Override
    public Flight getFlightByDestinationAirPort(String destinationAirPort) {
        return null;
    }

    @Override
    public void updateFlight(Flight flight) {

    }
}
