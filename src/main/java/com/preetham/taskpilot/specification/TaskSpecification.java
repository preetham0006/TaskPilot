package com.preetham.taskpilot.specification;

import com.preetham.taskpilot.entity.Task;
import com.preetham.taskpilot.enums.Category;
import com.preetham.taskpilot.enums.Priority;
import com.preetham.taskpilot.enums.Status;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecification {

    public static Specification<Task> hasStatus(Status status) {

    return (root, query, criteriaBuilder) ->

            criteriaBuilder.equal(root.get("status"), status);  //criteriaBuilder is just like SQL builder
}

    public static Specification<Task> hasPriority(Priority priority) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("priority"), priority);
}

    public static Specification<Task> hasCategory(Category category) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("category"), category);
}
    public static Specification<Task> titleContains(String keyword) {

    return (root, query, criteriaBuilder) ->

            criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("title")),
                    "%" + keyword.toLowerCase() + "%"
            );
}

}