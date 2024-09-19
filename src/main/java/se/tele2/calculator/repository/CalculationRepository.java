package se.tele2.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.tele2.calculator.model.Calculation;

import java.util.List;

/**
 * Repository interface for managing Calculation entities.
 * Extends CrudRepository to provide basic CRUD functionality.
 */
@Repository
public interface CalculationRepository extends JpaRepository<Calculation, Long> {

    /**
     * Find all Calculation entities.
     *
     * @return An iterable list of all Calculation entities.
     */
    @Override
    List<Calculation> findAll();
}
