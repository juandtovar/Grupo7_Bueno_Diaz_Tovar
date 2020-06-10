package Equipo7_Bueno_Diaz_Tovar.data;

import java.io.FileInputStream;
import java.io.Serializable;
import java.text.Normalizer;
import java.util.*;

public class Plan implements Serializable {

    private String nombre;
    private int n_semestres;
    private ArrayList<Materia>[] semestres;
    private ArrayList<Materia> optativas;
    private ArrayList<Materia>[] materiasVistas;
    private AVLTree<Identificador> identificadores;
    private int creditosDiscp;
    private int creditosFund;
    private int creditosElect;
    private int creditosTotales;
    private double PAPA;
    private int maxMaterias;
    private int nMaterias;

    public Plan(String nombre, int creditosDiscp, int creditosFund, int creditosElect, int n_semestres, int maxMaterias, int nMaterias) {
        this.nombre = nombre;
        this.creditosDiscp = creditosDiscp;
        this.creditosFund = creditosFund;
        this.creditosElect = creditosElect;
        this.creditosTotales = this.creditosDiscp + this.creditosFund + this.creditosElect;
        this.n_semestres = n_semestres;
        this.semestres = new ArrayList[n_semestres];
        this.optativas = new ArrayList<>();
        this.identificadores = new AVLTree();
        this.materiasVistas = new ArrayList[n_semestres];
        for (int i = 0; i < n_semestres; i++) {
            this.materiasVistas[i] = new ArrayList<>();
        }
        this.maxMaterias = maxMaterias;
        this.nMaterias = nMaterias;
    }

    public void cargarMaterias(FileInputStream file) {
        try (Scanner readFile = new Scanner(file)) {
            readFile.useDelimiter("/ ");
            readFile.nextLine();
            do {
                Materia materia = new Materia(readFile.nextInt(), Normalizer.normalize(readFile.next(), Normalizer.Form.NFD),
                        readFile.nextInt(), readFile.next(), readFile.next(), readFile.nextInt());
                readFile.nextLine();
                int semestre = materia.getSemestre();
                if (semestre == 0) {
                    this.optativas.add(materia);
                } else {
                    if (semestres[semestre - 1] == null) {
                        ArrayList<Materia> semestreLista = new ArrayList<>();
                        this.semestres[semestre - 1] = semestreLista;
                        semestreLista.add(materia);
                    } else {
                        semestres[semestre - 1].add(materia);
                    }
                    Identificador identificador = new Identificador(materia.getCodigo(), materia.getSemestre(),
                            this.semestres[materia.getSemestre() - 1].size() - 1);
                    this.identificadores.add(identificador);
                }

            } while (readFile.hasNext());
        }
    }

    public AVLTree getIdentificadores() {
        return identificadores;
    }

    public void setIdentificadores(AVLTree identificadores) {
        this.identificadores = identificadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getN_semestres() {
        return n_semestres;
    }

    public void setN_semestres(int n_semestres) {
        this.n_semestres = n_semestres;
    }

    public ArrayList<Materia>[] getSemestres() {
        return semestres;
    }

    public void setSemestres(ArrayList<Materia>[] semestres) {
        this.semestres = semestres;
    }

    public ArrayList<Materia> getOptativas() {
        return optativas;
    }

    public void setOptativas(ArrayList<Materia> optativas) {
        this.optativas = optativas;
    }

    public int getCreditosDiscp() {
        return creditosDiscp;
    }

    public void setCreditosDiscp(int creditosDiscp) {
        this.creditosDiscp = creditosDiscp;
    }

    public int getCreditosFund() {
        return creditosFund;
    }

    public void setCreditosFund(int creditosFund) {
        this.creditosFund = creditosFund;
    }

    public int getCreditosElect() {
        return creditosElect;
    }

    public void setCreditosElect(int creditosElect) {
        this.creditosElect = creditosElect;
    }

    public int getCreditosTotales() {
        return creditosTotales;
    }

    public void setCreditosTotales(int creditosTotales) {
        this.creditosTotales = creditosTotales;
    }

    public double getPAPA() {
        return PAPA;
    }

    public void setPAPA(double PAPA) {
        this.PAPA = PAPA;
    }

    public ArrayList<Materia>[] getMateriasVistas() {
        return materiasVistas;
    }

    public void setMateriasVistas(ArrayList<Materia>[] vistas) {
        this.materiasVistas = vistas;
    }

    public int getMaxMaterias() {
        return this.maxMaterias;
    }

    public void setMaxMaterias(int maxMaterias) {
        this.maxMaterias = maxMaterias;
    }

    public int getnMaterias() {
        return nMaterias;
    }

    public void setnMaterias(int nMaterias) {
        this.nMaterias = nMaterias;
    }

    @Override
    public String toString() {
        String s = "", sAux;
        for (int i = 0; i < n_semestres; i++) {
            if (materiasVistas.length != 0) {
                sAux = materiasVistas[i].toString();
                s += sAux;
            }
        }
        return s;
    }

}
