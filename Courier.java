package com.niit.courier;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;


public class Courier {
    //Declare appropriate variables

    private int courierOrderId;
    private CourierType courierType;
    private Address sender;
    private Address receiver;
    private float shipmentWeight;
    private String shipmentDimensions;
    private PaymentMode paymentMode;
    private Date courierReceiptDateTime;




    // Provide appropriate getters and setters


    public Address getSender() {
        return sender;
    }

    public void setSender(Address sender) {
        this.sender = sender;
    }

    public Address getReceiver() {
        return receiver;
    }

    public void setReceiver(Address receiver) {
        this.receiver = receiver;
    }


    // Parameterized constructor
    public Courier(int courierOrderId, CourierType courierType, Address sender, Address receiver, float shipmentWeight,
                   String shipmentDimensions, PaymentMode paymentMode, Date courierReceiptDateTime) {
        //Initialize values

        this.courierOrderId=courierOrderId;
        this.courierType=courierType;
        this.sender=sender;
        this.receiver=receiver;
        this.shipmentWeight=shipmentWeight;
        this.shipmentDimensions=shipmentDimensions;
        this.paymentMode=paymentMode;
        this.courierReceiptDateTime=courierReceiptDateTime;
    }


    //  final String to hold the courier charges from source city to destination city
    // do not change the values

    private final String charges[] = { "Chennai,Coimbatore,50", "Chennai,Trichy,50", "Chennai,Bangalore,100" };

    // calculate the cost of the courier depending on the weight and extract the cost from charges array
    // the calculateCost() method cannot be accessed outside the class, provide appropriate access specifiers

    public double calculateCost() {

        double cost=0;


        String [] diff1 = new String[3];
        String [] diff2 = new String[3];
        String [] diff3 = new String[3];

        diff1=charges[0].split(",");
        diff2=charges[1].split(",");
        diff3=charges[2].split(",");

        String senderL=diff1[0];
        String receiverC=diff1[1];
        String receiverT=diff2[1];
        String receiverB=diff3[1];

        int v1 =Integer.parseInt(diff1[2]);
        int v2 =Integer.parseInt(diff2[2]);
        int v3 =Integer.parseInt(diff3[2]);

        if (senderL.equals(sender.city) && receiverC.equals(receiver.city))
        {
            cost=v1;
        }
        else if (senderL.equals(sender.city) && receiverT.equals(receiver.city))
        {
            cost=v2;
        }
        else if (senderL.equals(sender.city) && receiverB.equals(receiver.city))
        {
            cost=v3;
        }
        else
        {
            return cost;
        }
        return cost;

    }
    // generate a random number between 100000 and 900000 to be sent back as acknowledgement,
    // provide appropriate access specifiers since this method will not be used outside this class

    public int generateAcknowledgementNumber()
    {
        Random random = new Random();
        int min=100001;
        int max=900000;
        int ackNo;
        ackNo = min + random.nextInt(max);
        return ackNo;
    }


    // return the acknowledgement number, if cost is = 0, then return a message 'no services to the area'
    public String acknowledgementGenerator() {


        int ackNo1=generateAcknowledgementNumber();
        String s= "ACK"+String.valueOf(ackNo1);
        String msg= "no services to the area";
        String res=null;


        if(calculateCost()>0)
        {
            res=s;
        }
        else if(calculateCost()<=0)
        {
            res=msg;
        }
     return res;
    }

    // Display the details of the courier, cost of dispatch and acknowledgement number
    //
    public void displayCourierDetails() {
    }


    // Display courier details in desired format as below
//    Courier [charges=xxx, cost=xxx, courierOrderId=xxx, courierReceiptDateTime=xxx, courierType=xxx
//                ,paymentMode=xxx, receiver=xxx, sender=xxx,
//               shipmentDimensions=xxxx, shipmentWeight=xxx]
    @Override
    public String toString() {
        return ("Courier [charges="+charges+", cost="+calculateCost()+", courierOrderId="+courierOrderId+"," +
                " courierReceiptDateTime="+courierReceiptDateTime+", courierType="+courierType+", " +
                "paymentMode="+paymentMode+", receiver="+receiver+", sender="+sender+", shipmentDimensions="+shipmentDimensions+", " +
                "shipmentWeight="+shipmentWeight+"]");

    }
} 