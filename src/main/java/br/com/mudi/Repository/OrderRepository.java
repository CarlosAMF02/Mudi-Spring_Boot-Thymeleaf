package br.com.mudi.Repository;

import br.com.mudi.Model.Order;
import br.com.mudi.Model.Status;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Cacheable("orders")
    List<Order> findByStatus(Status status, Pageable pageable);

    @Query("select o from Order o join o.user u where u.username = :username")
    List<Order> findAllByUser(@Param("username") String username);

    @Query("select o from Order o join o.user u where u.username = :username and o.status = :status")
    List<Order> findAllByUserAndStatus(@Param("username") String username, @Param("status") Status status);
}
