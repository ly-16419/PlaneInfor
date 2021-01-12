package PlaneInformatiom.bll.impl;

import PlaneInformatiom.bean.Flight;
import PlaneInformatiom.bll.IFlightService;
import PlaneInformatiom.dao.IFlightDao;
import PlaneInformatiom.dao.impl.FlightDaoIml;

import java.util.Set;

public class FlightServiceImpl implements IFlightService {
    IFlightDao iFlightDao;

    public FlightServiceImpl(){
        iFlightDao=new FlightDaoIml();
    }

    @Override
    public void insertFlight(Flight flight) {
        iFlightDao.insertFlight(flight);
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
