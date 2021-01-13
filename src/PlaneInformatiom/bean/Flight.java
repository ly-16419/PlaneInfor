package PlaneInformatiom.bean;

public class Flight {
    private String ID;
    private String FilghtID;//航班编号
    private String planeType;//机型
    private int currentSeatsNum;//剩余座位号
    private String departureAirPort;//离开机场
    private String destinationAirPort;//目的机场
    private String departureTime;//离开时间

    public Flight(String ID,String filghtID, String planeType, int currentSeatsNum, String departureAirPort, String destinationAirPort, String departureTime) {
        this.ID=ID;
        FilghtID = filghtID;
        this.planeType = planeType;
        this.currentSeatsNum = currentSeatsNum;
        this.departureAirPort = departureAirPort;
        this.destinationAirPort = destinationAirPort;
        this.departureTime = departureTime;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public String getDepartureAirPort() {
        return departureAirPort;
    }

    public void setDepartureAirPort(String departureAirPort) {
        this.departureAirPort = departureAirPort;
    }

    public String getDestinationAirPort() {
        return destinationAirPort;
    }

    public void setDestinationAirPort(String destinationAirPort) {
        this.destinationAirPort = destinationAirPort;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getCurrentSeatsNum() {
        return currentSeatsNum;
    }

    public void setCurrentSeatsNum(int currentSeatsNum) {
        this.currentSeatsNum = currentSeatsNum;
    }

    public String getFilghtID() {
        return FilghtID;
    }

    public void setFilghtID(String filghtID) {
        FilghtID = filghtID;
    }

    @Override
    public String toString() {
        return "Flight{"+
                "FilghtID='" + FilghtID + '\'' +
                ", planeType='" + planeType + '\'' +
                ", currentSeatsNum='" + currentSeatsNum + '\'' +
                ", departureAirPort='" + departureAirPort + '\'' +
                ", destinationAirPort='" + destinationAirPort + '\'' +
                ", departureTime='" + departureTime + '\'' +
                '}';
    }
}
