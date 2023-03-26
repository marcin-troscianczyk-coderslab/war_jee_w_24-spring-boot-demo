package pl.coderslab.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    //@Query("select distinct b from Book b left join fetch b.publisher left join fetch b.authors")
    List<Book> findAll();

    @Override
    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    //@Query("select distinct b from Book b left join fetch b.publisher left join fetch b.authors where b.id = :id")
    Optional<Book> findById(@Param("id") Long id);

    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    @Query("select b from Book b where b.title = :title")
    List<Book> findByTitle(@Param("title") String title);

    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    @Query("select b from Book b where b.category = :category")
    List<Book> findByCategory(@Param("category") Category category);

    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    List<Book> findByCategoryId(Long id);

/*
metodę wyszukującą książki dla zadanego tytułu.
metodę wyszukującą książki dla zadanej kategorii
 */
}
