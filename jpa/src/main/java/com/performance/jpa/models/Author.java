package com.performance.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@NamedQueries({
        @NamedQuery(
                name = "Author.findByNamedQuery",
                query = "select a from Author a where a.age >= :age"
        ),
        @NamedQuery(
                name = "Author.updateByNamedQuery",
                query = "update Author a set a.age = :age"
        )
})

@Entity
public class Author extends BaseEntity{

    @Column(
            name = "f_name",
            length = 35
    )
    private String firstName;
    private String lastName;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    private int age;
    @ManyToMany(mappedBy = "authors",fetch = FetchType.EAGER)
    private List<Course> courses;

}
