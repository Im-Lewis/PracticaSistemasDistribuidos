package es.ssdd.practica.Shop;

import es.ssdd.practica.Products.Product;
import es.ssdd.practica.Products.ProductController;
import es.ssdd.practica.Products.ProductService;
import es.ssdd.practica.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Controller
public class ShopController {

    @Autowired
    private ShopService shopService;
    @Autowired
    private ProductService productService;

    @GetMapping("/view/shops")
    public String viewShops(Model model){
        model.addAttribute("shops", shopService.getAll());
        return "view_new_shop";
    }

    @PostMapping("/shop/added")
    public String addedShop(Model model, Shop shop){
        shopService.createShop(shop);
        return "added_new_shop";
    }

    @GetMapping("/shop/{num}")
    public String viewShop(Model model, @PathVariable Long num){
        Shop shop = shopService.getShopById(num).get();
        model.addAttribute("shop", shop);
        model.addAttribute("indice", num);
        model.addAttribute("products", shopService.getShopById(num).get().getProducts());
        model.addAttribute("listproducts", productService.getAll());
        return "view_shop";
    }

    @GetMapping("/shop/{num}/deleted")
    public String shopDeleted(Model model, @PathVariable Long num){
        Shop shop = shopService.deleteShop(num);
        model.addAttribute("shop", shop);
        return "deleted_shop";
    }

    @GetMapping("/shop/{idshop}/added/{idproduct}")
    public String shopAddedProduct(Model model, @PathVariable Long idshop, @PathVariable Long idproduct){
        Product product = productService.getProductById(idproduct);
        Shop shop = shopService.getShopById(idshop).get();
        if (shopService.containsProduct(idshop, product)){
            return "error_add_new_product";
        }
        shop.setProduct(product);
        shopService.editShop(idshop, shop);


        return "added_product_shop";
        /*if (shopService.containsProduct(idshop, product)){
            return "error_add_new_product";
        }
        else{
            shop.setProduct(product);
            shopService.editShop(idshop, shop);
            return "added_new_product";
        }*/
    }
}
