package com.upt.lp.Equipa7.DTO;

import java.util.List;

public class CategoryDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Float orcamento;
    private List<Float> gastos;

    public CategoryDTO() {}

    public CategoryDTO(Long id, String nome, String descricao, Float orcamento, List<Float> gastos) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.orcamento = orcamento;
        this.gastos = gastos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Float orcamento) {
        this.orcamento = orcamento;
    }

    public List<Float> getGastos() {
        return gastos;
    }

    public void setGastos(List<Float> gastos) {
        this.gastos = gastos;
    }
}