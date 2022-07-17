package com.niit.courier;
import java.util.Date;
import java.util.Random;

import java.time.LocalDateTime;

public class CourierImpl {
    public static void main(String[] args) {
        // Declare and Initialize Address and courier objects to test your code
        // give desired values
        // call the displayCourierDetails() method to display the details of the courier
        Address obj1 = new Address("Gary",23,"Marble drive","Chennai","+917999733452");
        Address obj2 = new Address("Sam",23,"Marble drive","Coimbatore","+917999733452");

        Courier obj3= new Courier(123456,CourierType.INTERNATIONAL,obj1,obj2,200,"50X30",
                PaymentMode.CASH,new Date());

        System.out.println(obj3.toString());

    }
}
    
