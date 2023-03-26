package pl.coderslab.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Author;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.service.AuthorService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public void save(Author author) {
        authorRepository.save(author);
    }

    @Override
    public Author findById(Long authorId) {
        return authorRepository.findById(authorId).get();
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public void update(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteById(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}
