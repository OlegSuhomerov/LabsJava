package com.example.demo.service;

import com.example.demo.model.Expenses;
import com.example.demo.repository.ExpensesRepository;
import javassist.NotFoundException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ExpensesService {
    private final ExpensesRepository expensesRepository;

    public ExpensesService(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    public Expenses save(Expenses expenses) {
        return expensesRepository.save(expenses);
    }

    public List<Expenses> getAll() {
        return expensesRepository.findAll();
    }

    public Expenses getByName(String name) {
        return expensesRepository.findByName(name);
    }

    @SneakyThrows
    public void deleteById(Long id) throws Exception {
        Expenses expenses = expensesRepository.findById(id).orElse(null);
        if (Objects.isNull(expenses)) {
            throw new NotFoundException("expenses not found!");
        }
        expensesRepository.deleteById(id);
    }

}
