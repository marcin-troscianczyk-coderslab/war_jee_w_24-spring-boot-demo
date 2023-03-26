package pl.coderslab.service;

import pl.coderslab.entity.Publisher;

import java.util.List;

public interface PublisherService {
    void save(Publisher publisher);

    Publisher findById(Long id);

    List<Publisher> findAll();

    void update(Publisher publisher);

    void deleteById(Long id);
}
