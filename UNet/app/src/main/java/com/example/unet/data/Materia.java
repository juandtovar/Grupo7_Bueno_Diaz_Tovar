package com.example.unet.data;

public class Materia {

    private String name;
    private int codigo;
    private int creditos;
    private String tipologia;
    private int semestre;
    private Chain<Integer> nota;
    private String prerrequisitos;

    public Materia(int codigo, String name, int creditos, String tipologia, String prerrequisitos) {
        this.name = name;
        this.codigo = codigo;
        this.creditos = creditos;
        this.tipologia = tipologia;
        this.prerrequisitos = prerrequisitos;
        this.nota = new Chain<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Chain<Integer> getNota() {
        return this.nota;
    }

    public Integer getLastNota() {
        return this.nota.getTail().getElement();
    }

    public void setNota(int nota) {
        this.nota.add(nota, this.nota.getSize());
    }

    public String getPrerrequisitos() {
        return prerrequisitos;
    }

    public void setPrerrequisitos(String prerrequisitos) {
        this.prerrequisitos = prerrequisitos;
    }

    @Override
    public String toString() {
        return "Materia{" + "name=" + name + ", codigo=" + codigo + ", creditos=" + creditos + ", tipologia=" + tipologia + ", semestre=" + semestre + ", nota=" + nota + ", prerrequisitos=" + prerrequisitos + '}' + '\n';
    }

}
