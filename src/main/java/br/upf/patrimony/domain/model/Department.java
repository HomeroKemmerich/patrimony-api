package br.upf.patrimony.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * "@Entity" - Entidade Departamento
 * "@Table" - Define o nome da tabela atribuída à classe
 * "@Data" - Get e Set automáticos
 * "@NoArgsConstructor" - Gera um construtor vazio
 */
@Entity
@Table(name = "tb_department")
@Data
@NoArgsConstructor
public class Department {
    /**
     * ID do departamento
     * "@Id" - Define o atributo id como coluna de chave primária da tabela
     * "@GeneratedValue" - Gera o valor automaticamente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do departamento
     * "@Column" - configura as opções de coluna para o atributo
     */
    @Column(name = "name", length = 60)
    private String name;


}
