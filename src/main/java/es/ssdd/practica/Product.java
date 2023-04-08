package es.ssdd.practica;

public class Product {

    private String nombre;
    private String etiqueta;
    private String precio;
    private String descripcion;
    private int id = -1;

    public Product(String name, String tag, String price, String description){
        this.nombre = name;
        this.etiqueta = tag;
        this.precio = price;
        this.descripcion = description;
    }

    public String getNombre(){return nombre;}

    public String getEtiqueta(){return etiqueta;}

    public String getPrecio(){return precio;}

    public int getId(){return id;}

    public String getDescripcion(){return descripcion;}

    public void setNombre(String name){this.nombre = name;}

    public void setEtiqueta(String tag){this.etiqueta = tag;}

    public void setPrecio(String price){this.precio = price;}

    public void setDescripcion(String description){this.descripcion = description;}

    public void setId(int id){this.id = id;}

}
