package com.portfolio.TellMeWhenApp;

import com.portfolio.TellMeWhenApp.Model.ProductEntity;
import com.portfolio.TellMeWhenApp.Repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Configuration
public class Initialization {

    public static final Logger LOGGER = LogManager.getLogger(Initialization.class);

    public Initialization(ProductRepository productRepository) {
        LocalDate date = LocalDate.now();
        ProductEntity testEntity1 = new ProductEntity();
        testEntity1.setProductName("Milk");
        testEntity1.setProductType("Dairy and eggs");
        testEntity1.setPlaceOfStorage("Fridge");
        testEntity1.setPurchaseDate(date.minus(10, ChronoUnit.DAYS));
        testEntity1.setExpiryDate(date.plus(2,ChronoUnit.MONTHS));

        ProductEntity testEntity2 = new ProductEntity();
        testEntity2.setProductName("Tuna");
        testEntity2.setProductType("Fish");
        testEntity2.setPlaceOfStorage("Freezer");
        testEntity2.setPurchaseDate(date.minus(5, ChronoUnit.DAYS));
        testEntity2.setExpiryDate(date.plus(5,ChronoUnit.MONTHS));

        ProductEntity testEntity3 = new ProductEntity();
        testEntity3.setProductName("Beans");
        testEntity3.setProductType("Canned");
        testEntity3.setPlaceOfStorage("Pantry");
        testEntity3.setPurchaseDate(date);
        testEntity3.setExpiryDate(date.plus(12,ChronoUnit.MONTHS));

        ProductEntity testEntity4 = new ProductEntity();
        testEntity4.setProductName("Beets");
        testEntity4.setProductType("Fruits and vegetables");
        testEntity4.setPlaceOfStorage("Pantry");
        testEntity4.setPurchaseDate(date);
        testEntity4.setExpiryDate(date.plus(1,ChronoUnit.MONTHS));

        ProductEntity testEntity5 = new ProductEntity();
        testEntity5.setProductName("Canned mandarins");
        testEntity5.setProductType("Canned");
        testEntity5.setPlaceOfStorage("Pantry");
        testEntity5.setPurchaseDate(date.minus(1, ChronoUnit.DAYS));
        testEntity5.setExpiryDate(date.plus(24,ChronoUnit.MONTHS));

        ProductEntity testEntity6 = new ProductEntity();
        testEntity6.setProductName("Frozen vegetables");
        testEntity6.setProductType("Frozen");
        testEntity6.setPlaceOfStorage("Freezer");
        testEntity6.setPurchaseDate(date.minus(2, ChronoUnit.DAYS));
        testEntity6.setExpiryDate(date.plus(100,ChronoUnit.MONTHS));

        ProductEntity testEntity7 = new ProductEntity();
        testEntity7.setProductName("30% cream");
        testEntity7.setProductType("Dairy");
        testEntity7.setPlaceOfStorage("Pantry");
        testEntity7.setPurchaseDate(date.minus(25, ChronoUnit.DAYS));
        testEntity7.setExpiryDate(date.plus(11,ChronoUnit.MONTHS));

        ProductEntity testEntity8 = new ProductEntity();
        testEntity8.setProductName("Strawberry jam");
        testEntity8.setProductType("Preserve");
        testEntity8.setPlaceOfStorage("Fridge");
        testEntity8.setPurchaseDate(date);
        testEntity8.setExpiryDate(date.plus(3,ChronoUnit.MONTHS));

        ProductEntity testEntity9 = new ProductEntity();
        testEntity9.setProductName("Cola");
        testEntity9.setProductType("Drinks");
        testEntity9.setPlaceOfStorage("Fridge");
        testEntity9.setPurchaseDate(date);
        testEntity9.setExpiryDate(date.plus(5,ChronoUnit.MONTHS));

        ProductEntity testEntity10 = new ProductEntity();
        testEntity10.setProductName("Kitchen cleaner");
        testEntity10.setProductType("Household Chemicals");
        testEntity10.setPlaceOfStorage("Pantry");
        testEntity10.setPurchaseDate(date.minus(100, ChronoUnit.DAYS));
        testEntity10.setExpiryDate(date.plus(24,ChronoUnit.MONTHS));


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
