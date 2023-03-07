package br.upf.patrimony;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController - Define a classe como um controlador de requisição REST
 * @RequestMapping - define o a URI como /teste
 */
@RestController
@RequestMapping("/teste")
public class TesteController {
    /**
     * @GetMapping - Define o método como GET e adiciona "/hello_word" à URI
     * @return {String} Hello world
     */
    @GetMapping("/hello_world")
    public String helloWorld(){
        return "Hello world!";
    }
}
