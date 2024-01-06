package com.stormramsland;

class Task {
    String name;
    String description;

    Task(String name,String description) {
        this.name = name;
        this.description = description;
    }
    String getName() {
        return this.name;
    }

    String getDescription() {
        return this.description;
    }
}
