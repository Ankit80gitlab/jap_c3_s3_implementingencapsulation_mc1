package com.niit.courier;

import com.niit.courier.Address;
import com.niit.courier.Courier;
import com.niit.courier.CourierType;
import com.niit.courier.PaymentMode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class CourierTest {
    Courier courier,courier1;
    @BeforeEach
    void setUp()
    {
        courier = new Courier(101, CourierType.DOMESTIC,
                new Address("Gary",23,"Marble drive","Chennai","+917999733452"),
                new Address("Sam",23,"Marble drive","Coimbatore","+917999733452"),
                200,"10X10", PaymentMode.CASH, new Date());
        courier1 = new Courier(101, CourierType.DOMESTIC,
                new Address("Gary",23,"Marble drive","Chennai","+917999733452"),
                new Address("Sam",23,"Marble drive","Hyderabad","+917999733452"),
                100,"10X10", PaymentMode.CASH, new Date());
    }
    @AfterEach
    void tearDown()
    {
        courier = null;
        courier1 = null;
    }
    @Test
    public void whenCostIsGreaterThanZeroReturnAcknowledgement()
    {
        String ackNo = courier.acknowledgementGenerator();
        assertEquals(9,ackNo.length(),"Expected an AcknowledgementNumber that is non negative");
    }
    @Test
    public void whenCostIsLessThanZeroReturnMessage()
    {
        assertEquals("no services to the area",courier1.acknowledgementGenerator(),"the source and target cities are not connected");
    }

}
