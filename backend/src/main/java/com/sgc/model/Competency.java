package com.sgc.model;

import com.sgc.model.enums.Category;
import com.sgc.model.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Competency {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "competency_id_sequence")
    @SequenceGenerator(name = "competency_id_sequence", sequenceName = "competency_id_sequence", allocationSize = 1)
    private Long id;

    @Length(min = 1, max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String description;

    @Column(length = 14, nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(length = 8, nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;
}
