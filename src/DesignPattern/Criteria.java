package DesignPattern;

import java.util.List;

/**
 * Criteria不应只可以过滤人的对象，应该使用泛型
 */
public interface Criteria {
    List<Person> meetCriteria(List<Person> persons);
}


