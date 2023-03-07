package br.upf.patrimony.domain.repository;

import br.upf.patrimony.domain.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface não implementa código, apenas define um contrato
 * "@Repository" - define a interface como um repositório
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
