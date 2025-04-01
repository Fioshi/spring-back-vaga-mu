package fioshi.com.github.muralis_tec.contato.repository;

import fioshi.com.github.muralis_tec.contato.domain.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

    List<Contato> findAllByCliente_Id(Long id);

    void deleteAllByCliente_Id(Long id);
}
