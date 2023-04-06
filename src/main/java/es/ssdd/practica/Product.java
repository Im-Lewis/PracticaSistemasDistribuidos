package es.ssdd.practica;

public class Product {

    private String name;
    private String tag;
    private float price;
    private String description;

    public Product(String name, String tag, float price, String description){
        this.name = name;
        this.tag = tag;
        this.price = price;
        this.description = description;
    }

    public String getName(){return name;}

    public String getTag(){return tag;}

    public float getPrice(){return price;}

    public String getDescription(){return description;}

    public void setNombre(String name){this.name = name;}

    public void setTag(String tag){this.tag = tag;}

    public void setPrice(float price){this.price = price;}

    public void setDescription(String description){this.description = description;}

}
