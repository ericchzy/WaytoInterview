package com.company.DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class FilterByCriteriaV2 {
    public static <AnyType> List<AnyType> filter(List<AnyType> list, CriteriaV2<AnyType> criteria) {
        ArrayList<AnyType> result = new ArrayList<>();
        for (AnyType object : list) {
            if (criteria.meetCriteria(object)) {
                result.add(object);
            }
        }
        return result;
    }
}
