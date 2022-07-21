package src.main.java.com.ironhack.accountservice.repository;

import com.ironhack.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//NO SÉ POR QUÉ ME DA FALLO EL JPA SI ESTÁ INSTALADA LA DEPENDENCIA Y EN LOS DEMÁS FUNCIONA
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

}
