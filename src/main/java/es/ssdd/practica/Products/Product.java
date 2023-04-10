package es.ssdd.practica.Products;

public class Product {

    private String nombre;
    private String etiqueta;
    private String precio;
    private String descripcion;
    private String url;
    private int id = -1;

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

    public int getId(){return id;}

    public String getDescripcion(){return descripcion;}

    public String getUrl(){return url;}

    public void setNombre(String name){this.nombre = name;}

    public void setEtiqueta(String tag){this.etiqueta = tag;}

    public void setPrecio(String price){this.precio = price;}

    public void setDescripcion(String description){this.descripcion = description;}

    public void setUrl(String url){this.url=url;}

    public void setId(int id){this.id = id;}

}
