package es.ssdd.practica;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private List<Product> listProducts = new ArrayList<>();

    public ProductController(){
        Product p1 = new Product("Pala pro", "Pala", 20, "Mola mucho esta pala");
        Product p2 = new Product("Mesa palatronix", "Mesa", 200, "No dudes en llevarte esta maravillosa pala");
        listProducts.add(p1);
        listProducts.add(p2);
    }

    @GetMapping("/productos/nuevos")
    public String productosNuevos(Model model){
        model.addAttribute("productos", listProducts);
        return "productos_nuevos";
    }

    @PostMapping("/product/creado")
    public String productoNuevo(Model model, Product product){
        listProducts.add(product);
        model.addAttribute("products", listProducts);
        return "added_new_product";
    }

    @GetMapping("caca")
    public String cacador(Model model){
        return "caca_template";
    }
}
