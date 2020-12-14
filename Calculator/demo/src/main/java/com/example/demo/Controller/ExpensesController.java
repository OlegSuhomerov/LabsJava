package com.example.demo.Controller;

import com.example.demo.model.Expenses;
import com.example.demo.service.ExpensesService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ExpensesController {

    private final ExpensesService expensesService;

    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }

    @PostMapping("/expenses")
    public ResponseEntity<Expenses> saveModule(@RequestBody Expenses expenses) {
        try {
            expensesService.save(expenses);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/expenses/getAll")
    public ResponseEntity<List<Expenses>> getAll() {
        return ResponseEntity.ok(expensesService.getAll());
    }

    @GetMapping("/expenses")
    public ResponseEntity<Expenses> getByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(expensesService.getByName(name));
    }

    @DeleteMapping("/expenses")
    public ResponseEntity<String> deleteById(@RequestParam("expenses_id") Long expensesId) throws Exception {
            expensesService.deleteById(expensesId);
        return ResponseEntity.ok("delete expenses by id");
    }
}
