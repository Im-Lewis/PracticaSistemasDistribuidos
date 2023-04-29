package es.ssdd.practica.Shop;

import es.ssdd.practica.Products.Product;
import es.ssdd.practica.Products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShopController {

    @Autowired
    ShopService shopService;

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
        Shop shop = shopService.getShopById(num);
        model.addAttribute("shop", shop);
        model.addAttribute("indice", num);
        model.addAttribute("products", shopService.getShopById(num).getProducts());
        model.addAttribute("listproducts", ProductService.getAll());
        return "view_shop";
    }

    @GetMapping("/shop/{num}/deleted")
    public String shopDeleted(Model model, @PathVariable Long num){
        Shop shop = shopService.deleteShop(num);
        model.addAttribute("shop", shop);
        return "deleted_shop";
    }

}
