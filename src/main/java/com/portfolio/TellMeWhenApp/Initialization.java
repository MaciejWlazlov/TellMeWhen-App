package com.portfolio.TellMeWhenApp;

import com.portfolio.TellMeWhenApp.Model.ProductEntity;
import com.portfolio.TellMeWhenApp.Repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Initialization {

    public static final Logger LOGGER = LogManager.getLogger(Initialization.class);

    public Initialization(ProductRepository productRepository) {
        ProductEntity testEntity1 = new ProductEntity();
        testEntity1.setProductName("Milk");
        testEntity1.setProductType("Dairy and eggs");
        testEntity1.setPlaceOfStorage("Fridge");

        ProductEntity testEntity2 = new ProductEntity();
        testEntity2.setProductName("Tuna");
        testEntity2.setProductType("Fish");
        testEntity2.setPlaceOfStorage("Freezer");

        ProductEntity testEntity3 = new ProductEntity();
        testEntity3.setProductName("Beans");
        testEntity3.setProductType("Canned");
        testEntity3.setPlaceOfStorage("Pantry");

        ProductEntity testEntity4 = new ProductEntity();
        testEntity4.setProductName("Beets");
        testEntity4.setProductType("Fruits and vegetables");
        testEntity4.setPlaceOfStorage("Pantry");

        ProductEntity testEntity5 = new ProductEntity();
        testEntity5.setProductName("Canned mandarins");
        testEntity5.setProductType("Canned");
        testEntity5.setPlaceOfStorage("Pantry");

        ProductEntity testEntity6 = new ProductEntity();
        testEntity6.setProductName("Frozen vegetables");
        testEntity6.setProductType("Frozen");
        testEntity6.setPlaceOfStorage("Freezer");

        ProductEntity testEntity7 = new ProductEntity();
        testEntity7.setProductName("30% cream");
        testEntity7.setProductType("Dairy");
        testEntity7.setPlaceOfStorage("Pantry");

        ProductEntity testEntity8 = new ProductEntity();
        testEntity8.setProductName("Strawberry jam");
        testEntity8.setProductType("Preserve");
        testEntity8.setPlaceOfStorage("Fridge");

        ProductEntity testEntity9 = new ProductEntity();
        testEntity9.setProductName("Cola");
        testEntity9.setProductType("Drinks");
        testEntity9.setPlaceOfStorage("Fridge");

        ProductEntity testEntity10 = new ProductEntity();
        testEntity10.setProductName("Kitchen cleaner");
        testEntity10.setProductType("Household Chemicals");
        testEntity10.setPlaceOfStorage("Pantry");


        productRepository.save(testEntity1);
        productRepository.save(testEntity2);
        productRepository.save(testEntity3);
        productRepository.save(testEntity4);
        productRepository.save(testEntity5);
        productRepository.save(testEntity6);
        productRepository.save(testEntity7);
        productRepository.save(testEntity8);
        productRepository.save(testEntity9);
        productRepository.save(testEntity10);

        LOGGER.info(">>> Successfully initialized test entities into database <<<");

    }
}
