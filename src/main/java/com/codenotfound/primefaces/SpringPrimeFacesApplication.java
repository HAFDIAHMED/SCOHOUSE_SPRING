package com.codenotfound.primefaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPrimeFacesApplication {

  public static void main(String[] args) {
    
    Context.setContext(SpringApplication.run(SpringPrimeFacesApplication.class, args)) ;
  
    /* CategoryRepository carRepo = Context.getContext().getBean(CategoryRepository.class);
    carRepo.save(new Category("Achraf"));
    carRepo.save(new Category("Mouad"));
   carRepo.save(new Category("Pants"));
    */
    
  }
}
