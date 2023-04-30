package es.ssdd.practica.Products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Product {

    private String nombre;
    private String etiqueta;
    private String precio;
    private String descripcion;
    private String url;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Product(String name, String tag, String price, String description, String url){
        this.nombre = name;
        this.etiqueta = tag;
        this.precio = price;
        this.descripcion = description;
        this.url = url;
    }

    public String getNombre(){return nombre;}

    public String getEtiqueta(){return etiqueta;}

    public String getPrecio(){return precio;}


    public String getDescripcion(){return descripcion;}

    public String getUrl(){return url;}

    public void setNombre(String name){this.nombre = name;}

    public void setEtiqueta(String tag){this.etiqueta = tag;}

    public void setPrecio(String price){this.precio = price;}

    public void setDescripcion(String description){this.descripcion = description;}

    public void setUrl(String url){this.url=url;}

    public void replace(Product p){
        this.nombre = p.getNombre();
        this.etiqueta = p.getEtiqueta();
        this.precio = p.getPrecio();
        this.descripcion = p.getDescripcion();
        this.url = p.getUrl();
    }

}
