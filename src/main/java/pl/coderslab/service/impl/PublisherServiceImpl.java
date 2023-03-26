package pl.coderslab.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.PublisherRepository;
import pl.coderslab.service.PublisherService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Override
    public void save(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public Publisher findById(Long id) {
        return publisherRepository.findById(id).get();
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public void update(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    @Override
    public void deleteById(Long id) {
        publisherRepository.deleteById(id);
    }
}
