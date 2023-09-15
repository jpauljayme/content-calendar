package dev.mayhm.contentcalendar.controller;

import dev.mayhm.contentcalendar.model.Content;
import dev.mayhm.contentcalendar.model.Status;
import dev.mayhm.contentcalendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin()
public class ContentController {

    private final ContentRepository contentRepository;

//    @Autowired
    public ContentController(ContentRepository contentRepository){

        this.contentRepository = contentRepository;
    }

    @GetMapping("")
    public List<Content> findAll(){
        return contentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return contentRepository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Content Not Found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        contentRepository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Content content, @PathVariable Integer id){

        if(!contentRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Content Not Found");
        }

        contentRepository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){

        if(!contentRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Content Not Found");
        }

        contentRepository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword){
        return contentRepository
                .findAllByTitleContains(keyword);
//                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//                        "Content Not Found"));
    }

    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status){
        return contentRepository
                .findAllByStatus(status);
//                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
//                        "Content Not Found"));
    }
}
