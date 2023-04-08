package es.ssdd.practica;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private List<Product> listProducts = new ArrayList<>();

    public ProductController(){
        Product p1 = new Product("Pala pro", "Pala", "20", "Mola mucho esta pala");
        Product p2 = new Product("Mesa palatronix", "Mesa", "200", "No dudes en llevarte esta maravillosa pala");
        listProducts.add(p1);
        listProducts.add(p2);
    }

    @PostMapping("/product/added")
    public String addedProduct(Model model, Product product) {
        try{
            double num = Double.parseDouble(product.getPrecio());
            listProducts.add(product);
            return "added_product";
        }catch (NumberFormatException e) {
            return "error_add_new_product";
        }

    }

    @GetMapping("/view/products")
    public String viewProducts(Model model){
        model.addAttribute("products", listProducts);
        return "view_new_products";
    }

    @GetMapping("/product{num}")
    public String viewProduct(Model model, @PathVariable int num){
        Product product = listProducts.get(num-1);
        model.addAttribute("product", product);
        return "view_product";
    }

    @GetMapping("caca")
    public String cacador(Model model){
        return "added_product";
    }

}