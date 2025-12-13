package com.example.legocollection;

import java.util.ArrayList;
import java.util.List;

public class LegoRepository {
    private List<LegoSet> legoSets;
    private int nextId;

    public LegoRepository() {
        this.legoSets = new ArrayList<>();
        this.nextId = 1;
    }

    public void create(LegoSet legoSet) {
        legoSet.setId(nextId++);
        legoSets.add(legoSet);
    }

    public List<LegoSet> readAll() {
        return new ArrayList<>(legoSets);
    }

    public LegoSet readById(int id) {
        return legoSets.stream()
                .filter(set -> set.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void update(int id, LegoSet updatedSet) {
        for (int i = 0; i < legoSets.size(); i++) {
            if (legoSets.get(i).getId() == id) {
                updatedSet.setId(id);
                legoSets.set(i, updatedSet);
                break;
            }
        }
    }

    public void delete(int id) {
        legoSets.removeIf(set -> set.getId() == id);
    }
}