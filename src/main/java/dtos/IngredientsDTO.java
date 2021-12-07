package dtos;

import entities.WeeklyPlan;

import java.util.List;

public class IngredientsDTO {
    private int id;
    private String originalString;

    public IngredientsDTO(int id, String originalString) {
        this.id = id;
        this.originalString = originalString;

    }

    public IngredientsDTO(List<WeeklyPlan> weeklyPlanList) {

    }
}
