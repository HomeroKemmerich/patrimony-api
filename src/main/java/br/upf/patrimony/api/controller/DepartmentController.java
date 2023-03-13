package br.upf.patrimony.api.controller;

import br.upf.patrimony.domain.model.Department;
import br.upf.patrimony.domain.repository.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.beans.Beans;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    /**
     * "@Autowired" - Injeta automaticamente o repositório
     */
    @Autowired
    private DepartmentRepository repository;

    /**
     *"@ResponseStatus" - define o código HTTP
     * @return {List<Department>} Lista de departamentos
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Department> findAll(){
        return repository.findAll();
    }

    /**
     * ResponseEntity<T> Retorna o objeto desejado na forma de resposta HTTP
     * @param departmentId
     * @return
     */
    @GetMapping("/{departmentId}")
    public ResponseEntity<?> findById(@PathVariable Long departmentId){
        //Não trata valores nulos
        //Department department = repository.findById(departmentId).get();

        /**
         * Pode retornar valores nulos
         * Exige validação
         */
        Optional<Department> department = repository.findById(departmentId);

        //Verifica se o departamento foi encontrado
        //Se sim, retorna o objeto encontrado
        //Se não, retorna erro 404
        if(department.isPresent()){
            return ResponseEntity.ok(department.get());
        } else {
            //Retorna o código 404 juntamente com a resposta de erro
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * "@RequestBody" - Mapeia o body para o método
     * @param department
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Department save(@RequestBody Department department){
        return repository.save(department);
    }

    /**
     * PUT vs. PATCH - https://www.notion.so/homero-kemmerich/Patrimony-API-02722c527df0455d9dff81136e2095b0?pvs=4#0b59adc7b576405bb90aac7004c55670
     * @param departmentId
     * @param department
     * @return
     */
    @PutMapping("/{departmentId}")
    public ResponseEntity<?> update(@PathVariable Long departmentId, @RequestBody Department department){
        Optional<Department> departmentOptional = repository.findById(departmentId);

        /*
        Verifica se o objeto foi encontrado
        Se sim, atualiza o objeto,
        Se não, retorna erro
         */
        if(departmentOptional.isPresent()){
            Department currentDepartment = departmentOptional.get();

            //Copia as propriedades de um objeto para o outro, ignorando o ID
            BeanUtils.copyProperties(department, currentDepartment, "id");

            return ResponseEntity.ok(repository.save(currentDepartment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<?> delete(@PathVariable Long departmentId){
        repository.deleteById(departmentId);

        return ResponseEntity.noContent().build();
    }
}
