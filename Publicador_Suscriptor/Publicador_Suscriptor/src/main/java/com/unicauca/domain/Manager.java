package com.unicauca.domain;

public class Manager {

    private LevelOne levelOne;
    private LevelTwo levelTwo;

    public void createAthentionFlow() {
        levelOne = new LevelOne("");
        levelTwo = new LevelTwo("");
        // Crea los enlaces
        levelOne.setNextHandler(levelTwo);
    }

    public LevelOne getLevelOne() {
        return levelOne;
    }

    public void setLevelOne(LevelOne levelOne) {
        this.levelOne = levelOne;
    }

    public LevelTwo getLevelTwo() {
        return levelTwo;
    }

    public void setLevelTwo(LevelTwo levelTwo) {
        this.levelTwo = levelTwo;
    }
}
