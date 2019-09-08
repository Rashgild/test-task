package ru.rashgild.task.model;

import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
//import java.time.LocalDate;

@Entity
@Table(name = "documents")
public class Document {
    private int id;
    private int number;
    private Date date;
    private BigDecimal sum;
}
