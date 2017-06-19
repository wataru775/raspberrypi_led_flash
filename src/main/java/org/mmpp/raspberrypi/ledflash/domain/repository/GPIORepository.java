package org.mmpp.raspberrypi.ledflash.domain.repository;

import org.mmpp.raspberrypi.ledflash.domain.model.GPIO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GPIORepository extends JpaRepository<GPIO, Long> {
}
