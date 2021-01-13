package PlaneInformatiom.ui;

import PlaneInformatiom.bean.Flight;
import PlaneInformatiom.bll.IFlightService;
import PlaneInformatiom.bll.impl.FlightServiceImpl;
import com.sun.jndi.toolkit.ctx.StringHeadTail;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainUI0 {
            public static void main(String[] args){
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
                String id= UUID.randomUUID().toString().replace("-","");


                System.out.print( "请输入航班编号");
                String fligthId=reader.next();
                System.out.print( "请输入航班机型");
                String planeType=reader.next();
                System.out.print( "请输入座位数");
                int currentSeatsNum=reader.nextInt();
                System.out.print( "请输入起飞机场");
                String departureAirPort=reader.next();
                System.out.print( "请输入到达机场");
                String destinationAirPort=reader.next();
                System.out.print( "请输入起飞时间");
                String departureTime=reader.next();

                Flight flight=new Flight(id,fligthId,planeType,currentSeatsNum,
                        departureAirPort,destinationAirPort,departureTime);

                IFlightService iFlightService=new FlightServiceImpl();
                try {
                    iFlightService.insertFlight(flight);
                } catch (SQLException e) {
                    String errorMessage=e.getMessage();
                    if (errorMessage.startsWith("ORA-12899")) {
                        //ORA-12899: 列 "OPTS"."FLIGHT"."ID" 的值太大 (实际值: 36, 最大值: 32)
                        // 按指定模式在字符串查找
                        String pattern = "(\\w+-\\d{5}):(\\s[\\u4e00-\\u9fa5])\\s(\"\\w+\")\\.(\"\\w+\")\\.(\"\\w+\")";
                        Pattern r = Pattern.compile(pattern);
                        Matcher m = r.matcher(errorMessage);
                        if (m.find()) {
                            String tableName=m.group(4);
                            String columName=m.group(5);
                            System.out.println(tableName + "的表" + columName + "值过大,请仔细检查");
                        }else {
                            System.out.println("NO MATCH");
                        }
                }

                    }
                }else if (choice==2){
                IFlightService iFlightService=new FlightServiceImpl();
                try {
                    Set<Flight> allFlight=iFlightService.getAllFlight();

                    for (Flight flight:allFlight){
                        System.out.println(flight);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            }
        }
    }
