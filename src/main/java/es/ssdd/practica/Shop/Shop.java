package es.ssdd.practica.Shop;

import es.ssdd.practica.Products.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shop {

    private long id;
    private String name;
    private String ubication;
    private String url;
    private ArrayList<Product> products;

    public Shop(String name, String ubication, String url){
        this.name = name;
        this.ubication = ubication;
        this.url = url;
        products = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public String getUbication(){
        return ubication;
    }

    public String getUrl(){
        return url;
    }

    public Collection<Product> getProducts(){
        return products;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setUbication(String ubication){
        this.ubication = ubication;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void setProduct(Product p){
        products.add(p);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
