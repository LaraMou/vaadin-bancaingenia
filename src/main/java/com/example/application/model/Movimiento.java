package com.example.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Movimiento extends AbstractEntity {



    @Column(name="importe" , nullable = false)
    private Double importe;

    @Column(name="fecha" , nullable = false)
    private LocalDateTime fecha;

    @Column(name="fecha_valor" , nullable = false)
    private LocalDate fechaValor;

    @Column(name="descripcion")
    private String descripcion;
    @Column(name="concepto")
    private String concepto;

    /**
     * Relación Categorias y movimientos n-1
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    @JsonIgnore
     private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta")
    private Cuenta cuenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tarjeta")
    private Tarjeta tarjeta;


    public Movimiento() {
    }

    public Movimiento(Double importe, LocalDateTime fecha, LocalDate fechaValor, String descripcion, String concepto) {
        this.importe = importe;
        this.fecha = fecha;
        this.fechaValor = fechaValor;
        this.descripcion = descripcion;
        this.concepto = concepto;
    }


    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFechaValor() {
        return fechaValor;
    }

    public void setFechaValor(LocalDate fechaValor) {
        this.fechaValor = fechaValor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "importe=" + importe +
                ", fechaValor=" + fechaValor +
                ", descripcion='" + descripcion + '\'' +
                ", concepto='" + concepto + '\'' +
                '}';
    }
}
