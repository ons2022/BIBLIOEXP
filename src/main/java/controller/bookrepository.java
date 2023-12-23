package controller;

import entity.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface bookrepository extends JpaRepository<book,Long>{

}
