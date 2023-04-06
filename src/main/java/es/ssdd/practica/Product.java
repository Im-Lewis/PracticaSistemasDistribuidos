package es.ssdd.practica;

public class Product {

    private String nombre;
    private String etiqueta;
    private double precio;
    private String descripcion;

    public Product(String name, String tag, float price, String description){
        this.nombre = name;
        this.etiqueta = tag;
        this.precio = price;
        this.descripcion = description;
    }

    public String getNombre(){return nombre;}

    public String getEtiqueta(){return etiqueta;}

    public double getPrecio(){return precio;}

    public String getDescripcion(){return descripcion;}

    public void setNombre(String name){this.nombre = name;}

    public void setTag(String tag){this.etiqueta = tag;}

    public void setPrice(float price){this.precio = price;}

    public void setDescription(String description){this.descripcion = description;}

}
