
package com.example.touristservice.controller;

import com.example.touristservice.model.tourist;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tourists")
public class touristcontroller {

    @GetMapping
    public List<tourist> getTourists() {
        return Arrays.asList(
            new tourist(1, "Taj Mahal", "Agra", 5000.0),
            new tourist(2, "Charminar", "Hyderabad", 2000.0),
            new tourist(3, "Tirupati Temple", "Tirupati", 1500.0)
        );
    }

    @GetMapping("/{id}")
    public tourist getTouristById(@PathVariable int id) {
        return getTourists()
            .stream()
            .filter(t -> t.getId() == id)
            .findFirst()
            .orElse(null);
    }
}
