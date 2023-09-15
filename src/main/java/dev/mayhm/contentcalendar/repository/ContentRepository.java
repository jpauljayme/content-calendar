package dev.mayhm.contentcalendar.repository;

import dev.mayhm.contentcalendar.model.Content;
import dev.mayhm.contentcalendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    //Query derivation off by method name --> turned into actual code at runtime by the method signature
    //OR
    //Manual-defined Query
    List<Content> findAllByTitleContains(String keyword);

    @Query("""
            SELECT * FROM Content 
                WHERE status = :status
            """)
    List<Content> findAllByStatus(Status status);

}
