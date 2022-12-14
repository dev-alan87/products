package io.github.dev_alan87.booking.api.controllers;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.github.dev_alan87.booking.domain.entities.Product;
import io.github.dev_alan87.booking.domain.repositories.ProductRepository;

@Scope(value = "session")
@Component(value = "productController")
@ELBeanName(value = "productController")
@Join(path = "/product", to = "/product-form.jsf")
public class ProductController {

	@Autowired
	private ProductRepository repository;
	
	private Product product = new Product();
	
	public String save() {
		repository.save(product);
		product = new Product();
		return "/product-list.xhtml?faces-redirect=true";
	}
	
	public Product getProduct() {
		return product;
	}
	
}
