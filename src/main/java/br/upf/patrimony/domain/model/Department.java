package br.upf.patrimony.domain.model;

import jakarta.persistence.*;

/**
 * @Entity - Entidade Departamento
 * @Table - Define o nome da tabela atribuída à classe
 */
@Entity
@Table(name = "tb_department")
public class Department {
    /**
     * ID do departamento
     * @Id - Define o atributo id como coluna de chave primária da tabela
     * @GeneratedValue - Gera o valor automaticamente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do departamento
     * @Column - configura as opções de coluna para o atributo
     */
    @Column(name = "dep_name", length = 60)
    private String name;


}
