package br.com.project.restwithspringboot.repositories;

import br.com.project.restwithspringboot.data.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
