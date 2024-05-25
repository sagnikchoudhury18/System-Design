package models;

import java.util.Date;

public class Invoice {
    private String number;
    private Date exitTime;
    private Ticket ticket;
    private Gate generatedAt;
    private Operator operator;
    private PaymentType paymentType;
}
