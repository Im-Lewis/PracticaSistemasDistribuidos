package es.ssdd.practica;

public class Product {

    private String nombre;
    private String etiqueta;
    private double precio;
    private String descripcion;
    private int id = -1;

    public Product(String name, String tag, double price, String description){
        this.nombre = name;
        this.etiqueta = tag;
        this.precio = price;
        this.descripcion = description;
    }

    public String getNombre(){return nombre;}

    public String getEtiqueta(){return etiqueta;}

    public double getPrecio(){return precio;}

    public int getId(){return id;}

    public String getDescripcion(){return descripcion;}

    public void setNombre(String name){this.nombre = name;}

    public void setTag(String tag){this.etiqueta = tag;}

    public void setPrice(double price){this.precio = price;}

    public void setDescription(String description){this.descripcion = description;}

    public void setId(int id){this.id = id;}

}
