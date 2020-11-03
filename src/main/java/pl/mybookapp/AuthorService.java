package pl.mybookapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/authors")
    public ResponseEntity getAuthor() throws JsonProcessingException {
        List<Author> authors = authorRepository.findAll();
        return ResponseEntity.ok(objectMapper.writeValueAsString(authors));
    }
    @PostMapping("/authors")
    public ResponseEntity addAuthor (@RequestBody Author author) {
        Author savedAuthor = authorRepository.save(author);
        return ResponseEntity.ok(savedAuthor);
    }
}
