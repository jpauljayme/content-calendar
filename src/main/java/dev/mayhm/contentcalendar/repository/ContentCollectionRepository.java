package dev.mayhm.contentcalendar.repository;

import dev.mayhm.contentcalendar.model.Content;
import dev.mayhm.contentcalendar.model.Status;
import dev.mayhm.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//In memory record for testing
//@Repository
public class ContentCollectionRepository {

    private List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf( c -> c.getId().equals(content.getId()));
        contentList.add(content);
    }

    @PostConstruct
    private void init(){
        Content c = new Content(1,
                "First Blog Post",
                "First blog post !!!",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");

        contentList.add(c);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.getId().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf( c -> c.getId().equals(id));
    }
}
