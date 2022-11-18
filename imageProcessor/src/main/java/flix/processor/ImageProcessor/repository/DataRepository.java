package flix.processor.ImageProcessor.repository;

import flix.processor.ImageProcessor.entity.Data;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface DataRepository extends JpaRepository<Data,Integer> {
}
