package com.example.legocollection;

import java.util.List;

public class LegoController {
    private LegoRepository repository;

    public LegoController(LegoRepository repository) {
        this.repository = repository;
    }

    public void addLegoSet(LegoSet legoSet) {
        validateLegoSet(legoSet);
        repository.create(legoSet);
    }

    public List<LegoSet> getAllLegoSets() {
        return repository.readAll();
    }

    public LegoSet getLegoSetById(int id) {
        return repository.readById(id);
    }

    public void updateLegoSet(int id, LegoSet updatedSet) {
        validateLegoSet(updatedSet);
        repository.update(id, updatedSet);
    }

    public void deleteLegoSet(int id) {
        repository.delete(id);
    }

    private void validateLegoSet(LegoSet legoSet) {
        if (legoSet.getName() == null || legoSet.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (legoSet.getTheme() == null || legoSet.getTheme().trim().isEmpty()) {
            throw new IllegalArgumentException("Theme cannot be empty");
        }
        if (legoSet.getPieces() <= 0) {
            throw new IllegalArgumentException("Pieces must be greater than 0");
        }
        if (legoSet.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
    }
}
