package FMS;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Exception;
class MyException extends Exception{
    MyException(String msg)
    {
        super(msg);
    }
}
public class Main {
    static FlightManagementSystem []fl=new FlightManagementSystem[100];
    static int count=0;
    public static void manageFlight()
    {

        int opt, rno, i, flag = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n### Manage Flights ###");
            System.out.println("1. Add flight");
            System.out.println("2. Search Flight");
            System.out.println("3. Back to Main Menu");
            System.out.print("\nEnter Option: ");
            opt = scanner.nextInt();

            switch (opt) {
                case 1:
                    System.out.print("\nEnter Plane Id: ");
                    rno = scanner.nextInt();
                    i = 0;
                    for (i = 0; i < count; i++) {
                        if (fl[i].FlightId == rno) {
                            flag = 1;
                        }
                    }
                    if (flag == 1) {
                        System.out.println("\nFlight is Present.\nPlease enter a unique Number");
                        flag = 0;
                    } else {
                        System.out.println("Enter Start Location: ");
                        scanner.nextLine();
                        String Source=scanner.nextLine();
                        System.out.println("Enter Destination Location: ");
                        String Destination=scanner.nextLine();
                        System.out.println("Enter Date of Leaving");
                        String Dates=scanner.next();
                        fl[count] = new FlightManagementSystem();
                        fl[count].addFlight(rno,Source,Destination,Dates,100,0);
                        count++;
                    }
                    break;
                case 2:
                    System.out.print("Enter Flight number: ");
                    rno = scanner.nextInt();
                    for(int j=0;j<count;j++)
                    {
                        if(fl[j].FlightId==rno) fl[j].DisplayFlight();
                    }
                    break;
                default:
                    System.out.println("\nPlease Enter correct option");
                    break;
            }
        } while (opt != 3);
    }

    public static void main(String []args)
    {

        Scanner sc=new Scanner(System.in);
        int opt, rno;
        String pname;
        do{
            System.out.println("############## FLIGHT MANAGEMENT SYSTEM #################");
            System.out.println("1. Manage Flight");
            System.out.println("2. Book Flight");
            System.out.println("3. Available Flights");
            System.out.println("4. Search Customer");
            System.out.println("5. Customer Summary Report");
            System.out.println("6. Exit");
            System.out.print("\nEnter Option: ");
            opt = sc.nextInt();
            switch(opt)
            {
                case 1:
                    manageFlight();
                break;
                case 2:
                    int found = 0, fno;
                    int i=0;
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter Flight Number: ");
                    fno = scanner.nextInt();
                    for(i=0;i<count;i++)
                    {
                        if(fl[i].FlightId==fno)
                        {
                            found=1;
                            break;
                        }
                    }
                    if(found==0 || fl[i].Seats<=0)
                    {
                        System.out.println("Enter Valid ID");
                        break;
                    }

                    System.out.println("Enter Your first Name");
                    String Fname=sc.next();
                    System.out.println("Enter Your Last Name");
                    String Lname=sc.next();
                    System.out.println("Enter Your Age");
                    int age=sc.nextInt();
                    System.out.println("Enter Your Phone Number");
                    String ph;

                    try{
                        ph=sc.next();
                        RuntimeException MyException = new RuntimeException("Enter Valid Number");
                        if(ph.length()!=10) throw MyException;
                    }
                    catch (RuntimeException e)
                    {
                        System.out.println(e.getMessage());
                        break;
                    }
                    System.out.println("Enter Your Address : ");
                    sc.nextLine();
                    String address=sc.nextLine();
                    System.out.println("Enter Your aadhar Number : ");
                    String aadharNum;
                    try{
                        aadharNum=sc.next();
                        RuntimeException MyException = new RuntimeException("Enter Valid Aadhar Number");
                        if(aadharNum.length()!=12) throw MyException;
                    }
                    catch (RuntimeException e)
                    {
                        System.out.println(e.getMessage());
                        break;
                    }
                    fl[i].customer[fl[i].CountCust]=new Customer(Fname,Lname,age,aadharNum,ph,address);
                    fl[i].CountCust++;
                    fl[i].Seats--;
                break;
                case 3:
                    if (count == 0) {
                    System.out.println("Flights data is not available.\nPlease add the flights first.");
                    break;
                    }
                    int k, f = 0;
                        for (k = 0; k < count; k++)
                        {
                            if (fl[k].Seats != 0)
                            {
                                fl[k].DisplayFlight();
                                f = 1;
                            }
                        }
                        if (f == 0)
                        {
                            System.out.println("All Flights Are Reserved");
                        }
                break;
                case 4:
                    System.out.println("Enter Aadhar Number :");
                    String Aadhar=sc.next();

                    for(i=0;i<count;i++)
                    {
                        for(int j=0;j<fl[i].CountCust;j++)
                        {
                            if(fl[i].customer[j].custId.equals(Aadhar))
                            {
                                System.out.println("Name : "+ fl[i].customer[j].FirstName+" "+fl[i].customer[i].LastName);
                                System.out.println("Age : "+fl[i].customer[j].age);
                                System.out.println("Address : "+fl[i].customer[j].Address);
                            }
                        }
                    }
                break;
                case 5:
                    System.out.println("Enter Flight Id :");
                    int fid=sc.nextInt();
                    for(i=0;i<count;i++)
                    {
                        if(fid==fl[i].FlightId)
                        {
                            for(int j=0;j<fl[i].CountCust;j++)
                            {

                                System.out.println("Name : "+ fl[i].customer[j].FirstName+" "+fl[i].customer[i].LastName);
                                System.out.println("Age : "+fl[i].customer[j].age);
                                System.out.println("Address : "+fl[i].customer[j].Address);
                                System.out.println("Aadhar Number :"+fl[i].customer[j].custId);
                            }
                        }
                    }
                break;
                case 6:
                    System.out.println("Thanks For Using Our Software!!!!");
                break;
                default:
                    System.out.println("Please Enter the Correct Option");
                break;
            }
        } while(opt!=6);
    }
}
