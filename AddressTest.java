package com.niit.courier;

import com.niit.courier.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {
    Address addr1;
    Address addr2;
    @BeforeEach
    void setUp() {
        addr1 = new Address("Gary",23,"Marble drive","Chennai","+917999733452");
        addr2 = new Address("Gary",23,"Marble drive","Chennai","799733452");
    }
    @AfterEach
    void tearDown()
    {
        addr1 = null;
        addr2 = null;
    }
    @Test
    public void givenAPhoneNumberCheckIfItIsValid()
    {
        assertEquals(1,addr1.isPhoneNoValid("+917999733452"),"Give a valid phone number");
    }
    @Test
    public void givenAnInvalidPhoneNumberCheckIfItIsInValid()
    {
        assertEquals(0,addr1.isPhoneNoValid("799733452"),"Given an invalid phone number");
    }
    @Test
    public void returnAddressInDesiredFormat()
    {
        String expected = "Address [city=Chennai, houseNo=23, name=Gary, phoneNo=+917999733452, street=Marble drive]";
        assertEquals(expected,addr1.toString());
    }
}
