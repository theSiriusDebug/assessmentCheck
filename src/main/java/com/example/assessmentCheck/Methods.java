package com.example.assessmentCheck;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Methods {
    public double find(List<Integer>list){
        double averageRating = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(Double.NaN);

        return averageRating;
    }
}
