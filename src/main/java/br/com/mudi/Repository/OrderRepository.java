package br.com.mudi.Repository;

import br.com.mudi.Model.Order;
import br.com.mudi.Model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(Status status);
}
