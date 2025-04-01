package fioshi.com.github.muralis_tec.cliente.repository;

import fioshi.com.github.muralis_tec.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.nome LIKE %:value% OR c.cpf LIKE %:value%")
    List<Cliente> searchByNomeOrCpf(@Param("value") String value);

}
