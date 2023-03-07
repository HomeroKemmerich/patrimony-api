package br.upf.patrimony.api.controller;

import br.upf.patrimony.domain.model.Department;
import br.upf.patrimony.domain.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * "@RequestBody" - Mapeia o body para o método
     * @param department
     */
    @PostMapping
    public Department save(@RequestBody Department department){
        return repository.save(department);
    }
}
