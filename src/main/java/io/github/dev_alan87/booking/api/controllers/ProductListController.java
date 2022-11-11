package io.github.dev_alan87.booking.api.controllers;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.github.dev_alan87.booking.domain.entities.Product;
import io.github.dev_alan87.booking.domain.repositories.ProductRepository;

@Scope(value = "session")
@Component(value = "productList")
@ELBeanName(value = "productList")
@Join(path = "/", to = "product-list.jsf")
public class ProductListController {

	@Autowired
	private ProductRepository repository;
	
	private List<Product> products;
	
	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		products = repository.findAll();
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
}
