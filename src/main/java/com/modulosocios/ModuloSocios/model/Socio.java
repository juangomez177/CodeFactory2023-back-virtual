package com.modulosocios.ModuloSocios.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "socio" )
@Data
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column (name = "id" )
    private Integer id;
    
    @Column (name = "nombre" )
    private String nombre;
    
    @Column (name = "correoelectronico" )
    private String correoElectronico;
    
    @Column (name = "telefono" )
    private String telefono;

    @Column (name = "ciudad" )
    private String ciudad;
    
    @Column (name = "licenciaconducir" )
    private String licenciaConducir;
    
    @Column (name = "documentoidentidad" )
    private String documentoIdentidad;
    
    @Column (name = "estadoverificacion" )
    private String estadoVerificacion;
    
    @Column (name = "fecharegistro" )
    private Date fechaRegistro;
    
    @Column (name = "fechaverificacion" )
    private Date fechaVerificacion;
    
    @Column (name = "fechasuspension" )
    private Date fechaSuspension;
    
    @Column (name = "motivosuspension" )
    private String motivoSuspension;
    
    @Column(name = "pendientedeverificacion")
    private Boolean pendientedeVerificacion;
    
    @Column (name = "correo_notificacion" )
    private String correoNotificacion;
    
    @Column (name = "administradorid" )
    private Integer administradorId;
    
    @Column (name = "contrasena" )
    private String contrasena;

    @Column(name = "pasadojudicial")
    private String pasadoJudicial;

    @Column(name = "foto")
    private String foto;

    
    @OneToOne(mappedBy = "socio", cascade = CascadeType.ALL)
    private Vehiculo vehiculo;
    
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "administradorid", insertable = false, updatable = false, nullable = true)
    @JsonIgnore
    private Administrador administrador;

    @OneToMany(mappedBy = "socio", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Suspension> suspensiones;

}