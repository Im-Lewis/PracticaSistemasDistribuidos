package es.ssdd.practica.Products;
import es.ssdd.practica.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping("/product/added")
    public String addedProduct(Model model, Product product) {
        try{
            double num = Double.parseDouble(product.getPrecio());
            productService.createProduct(product);
            return "added_new_product";
        }catch (NumberFormatException e) {
            return "error_add_new_product";
        }

    }

    @GetMapping("/view/products")
    public String viewProducts(Model model){
        model.addAttribute("products", productService.getAll());
        return "view_new_products";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("products", productService.getAll());
        return "shop";
    }

    @GetMapping("/product/{num}")
    public String viewProduct(Model model, @PathVariable Long num){
        Product product = productService.getProductById(num);
        model.addAttribute("product", product);
        model.addAttribute("indice", num);
        return "view_product";
    }

    @GetMapping("/product/{num}/deleted")
    public String productDeleted(Model model, @PathVariable Long num){
        Product product = productService.getProductById(num);
        productService.deleteProduct(num);
        model.addAttribute("product", product);
        return "deleted_product";
    }

    @GetMapping("/product/{num}/edit")
    public String editProduct(Model model, @PathVariable Long num){
        model.addAttribute("indice", num);
        Product product = productService.getProductById(num);
        model.addAttribute("product", product);
        return "edit_product";
    }

    @PostMapping("/product/{num}/edited")
    public String productEdited (Model model, @PathVariable Long num, Product product){
        try{
            double number = Double.parseDouble(product.getPrecio());
            productService.getProductById(num).replace(product);
            return "added_new_product";
        }catch (NumberFormatException e) {
            return "error_add_new_product";
        }
    }

}