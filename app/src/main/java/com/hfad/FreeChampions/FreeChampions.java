package com.hfad.FreeChampions;

import java.util.List;

public class FreeChampions {
    private List<Integer> freeChampionIds;
    private List<Integer> freeChampionIdsForNewPlayers;
    private int maxNewPlayerLevel;

    public FreeChampions(){

    }

    public List<Integer> getFreeChampionIds() {
        return freeChampionIds;
    }

    public void setFreeChampionIds(List<Integer> freeChampionIds) {
        this.freeChampionIds = freeChampionIds;
    }


    public List<Integer> getFreeChampionIdsForNewPlayers() {
        return freeChampionIdsForNewPlayers;
    }

    public void setFreeChampionIdsForNewPlayers(List<Integer> freeChampionIdsForNewPlayers) {
        this.freeChampionIdsForNewPlayers = freeChampionIdsForNewPlayers;
    }


    public int getMaxNewPlayerLevel() {
        return maxNewPlayerLevel;
    }

    public void setMaxNewPlayerLevel(int maxNewPlayerLevel) {
        this.maxNewPlayerLevel = maxNewPlayerLevel;
    }

    @Override
    public String toString() {
        return "FreeChampions{" +
                "freeChampionIds=" + freeChampionIds +
                ", freeChampionIdsForNewPlayers=" + freeChampionIdsForNewPlayers +
                ", maxNewPlayerLevel=" + maxNewPlayerLevel +
                '}';
    }
}
