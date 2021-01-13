package PlaneInformatiom.dao.impl;

import PlaneInformatiom.bean.Flight;
import PlaneInformatiom.bll.IFlightService;
import PlaneInformatiom.bll.impl.FlightServiceImpl;
import PlaneInformatiom.dao.IFlightDao;

import java.sql.*;
import java.util.HashSet;
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
    public Set<Flight> getAllFlight() throws SQLException {
        Set<Flight> allFligth=new HashSet<Flight>();

        String url="jdbc:oracle:thin:@localhost:1521:orcl";
        String username="opts";
        String password="opts1234";
        Connection conn=DriverManager.getConnection(url,username,password);
        String sql="SELECT * FROM flight";

        PreparedStatement pstmt=conn.prepareStatement(sql);
        ResultSet re=pstmt.executeQuery();

        while (re.next()){
            String id=re.getString("ID");
            String FilghtID=re.getString("FLIGHT_ID");
            String planeType=re.getString("PLANE_TYPE");
            int currentSeatsNum=re.getInt("TOTAL_SEATS_NUM");
            String departureAirPort=re.getString("DEPARTURE_AIRPORT");
            String destinationAirPort=re.getString("DESTINATION_AIRPORT");
            String departureTime=re.getString("DEPARTURE_TIME");

            Flight flight = new Flight(id, FilghtID, planeType, currentSeatsNum,
                    departureAirPort, destinationAirPort, departureTime);
            allFligth.add(flight);

        }

        return allFligth;
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
