package com.phangil.houseutils.repository;

import com.phangil.houseutils.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author triple
 */
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}
