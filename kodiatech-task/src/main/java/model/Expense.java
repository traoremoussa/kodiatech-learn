package model;

import jakarta.persistence.*;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @Column(name = "date")
    private Date date;

    // Getters and Setters
}
