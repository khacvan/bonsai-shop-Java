package com.bonsai.client;


import com.bonsai.client.product.ProductService;
import com.bonsai.common.entity.Category;
import com.bonsai.common.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.bonsai.client.category.CategoryService;
import java.util.List;

@Controller
public class MainController {

	@Autowired
	private CategoryService categoryService;

	@Autowired

	private ProductService productService;



	@GetMapping("")
	public String viewHomePage(Model model) {
		List<Category> listCategories = categoryService.listNoChildrenCategories();
		model.addAttribute("listCategories", listCategories);

		List<Product> latestProducts = productService.findLatestProducts();
		model.addAttribute("latestProducts", latestProducts);
		return "index";
	}

	@GetMapping("/login")
	public String viewLoginPage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login1";
		}

		return "redirect:/";
	}
}
