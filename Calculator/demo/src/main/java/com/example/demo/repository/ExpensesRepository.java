package com.example.demo.repository;

import com.example.demo.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses,Long> {

    public Expenses findByName(String name);
}
