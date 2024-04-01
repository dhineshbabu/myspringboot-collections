package com.performance.jpa.repositories;

import com.performance.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {

    // update author a set a.age = 22 where a.id = 1
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

    // update all authors
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    int updateAllAuthors(int age);

    // using named query
    @Transactional
    List<Author> findByNamedQuery(@Param("age") int age);

    // update NamedQuery
    @Transactional
    @Modifying
    void updateByNamedQuery(@Param("age") int age);

    // select * from author where first_name=''
    List<Author> findAllByFirstName(String fn);

    // select * from author where first_name='al'
    List<Author> findAllByFirstNameIgnoreCase(String fn);

    // select * from author where first_name='%al%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

    // select * from author where first_name='al%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

    // select * from author where first_name='%al'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);

    // select * from author where first_name in ('al', 'perf')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> fn);
}
