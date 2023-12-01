package ucb.edu.bo.do_protecto_backend.ENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Category_id")
    private Long categoryId;

    @Column(name = "nameCategory", nullable = false)
    private String nameCategory;

    
}
