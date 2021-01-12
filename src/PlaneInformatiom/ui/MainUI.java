package PlaneInformatiom.ui;

import PlaneInformatiom.bean.Flight;
import PlaneInformatiom.bll.IFlightService;
import PlaneInformatiom.bll.impl.FlightServiceImpl;

import java.util.Scanner;
import java.util.UUID;

public class MainUI {
    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);

        int choice=0;
        while (true){
            System.out.println("请输入相应的数字进行操作：");

            System.out.println("按1，录入航班信息");
            System.out.println("按2，显示所有航班信息");
            System.out.println("按3，查询航班信息");
            System.out.println("按4，机票预订");
            System.out.println("按5，机票退订");
            System.out.println("按6，推出系统");

            choice=reader.nextInt();

            if (choice==1){
                String id= UUID.randomUUID().toString();

                System.out.print( "请输入航班编号");
                String fligthId=reader.next();
                System.out.print( "请输入航班机型");
                String planeType=reader.next();
                System.out.print( "请输入座位数");
                String currentSeatsNum=reader.next();
                System.out.print( "请输入起飞机场");
                String departureAirPort=reader.next();
                System.out.print( "请输入到达机场");
                String destinationAirPort=reader.next();
                System.out.print( "请输入起飞时间");
                String departureTime=reader.next();


                Flight flight=new Flight(fligthId,planeType,currentSeatsNum,
                        departureAirPort,destinationAirPort,departureTime);

                IFlightService iFlightService=new FlightServiceImpl();
                iFlightService.insertFlight(flight);
            }
        }
    }
}
