package com.portfolio.tellmewhenapp;

import com.portfolio.tellmewhenapp.shoppingList.entity.ShoppingProduct;
import com.portfolio.tellmewhenapp.shoppingList.repository.ShoppingProductRepository;
import com.portfolio.tellmewhenapp.storageProduct.model.Entity.StorageProduct;
import com.portfolio.tellmewhenapp.storageProduct.repository.StorageProductRepository;
import com.portfolio.tellmewhenapp.user.entity.User;
import com.portfolio.tellmewhenapp.user.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Configuration
public class Initialization {
    private static final Logger LOGGER = LogManager.getLogger(Initialization.class);
    private static final LocalDate NOW = LocalDate.now();

    Initialization(StorageProductRepository storageProductRepository, ShoppingProductRepository shoppingProductRepository,
                           UserRepository userRepository, PasswordEncoder passwordEncoder) {

        LocalDate date = NOW;
        StorageProduct testEntity1 = new StorageProduct();
        testEntity1.setProductName("Milk");
        testEntity1.setProductType("Dairy and eggs");
        testEntity1.setPlaceOfStorage("Fridge");
        testEntity1.setPurchaseDate(date.minus(10, ChronoUnit.DAYS));
        testEntity1.setExpiryDate(date.plus(2, ChronoUnit.MONTHS).plus(2, ChronoUnit.DAYS));

        StorageProduct testEntity2 = new StorageProduct();
        testEntity2.setProductName("Tuna");
        testEntity2.setProductType("Fish");
        testEntity2.setPlaceOfStorage("Freezer");
        testEntity2.setPurchaseDate(date.minus(5, ChronoUnit.DAYS));
        testEntity2.setExpiryDate(date.plus(5, ChronoUnit.MONTHS).plus(1, ChronoUnit.DAYS));

        StorageProduct testEntity3 = new StorageProduct();
        testEntity3.setProductName("Beans");
        testEntity3.setProductType("Canned");
        testEntity3.setPlaceOfStorage("Pantry");
        testEntity3.setPurchaseDate(date);
        testEntity3.setExpiryDate(date.plus(12, ChronoUnit.MONTHS));

        StorageProduct testEntity4 = new StorageProduct();
        testEntity4.setProductName("Beets");
        testEntity4.setProductType("Fruits and vegetables");
        testEntity4.setPlaceOfStorage("Pantry");
        testEntity4.setPurchaseDate(date.minus(10, ChronoUnit.DAYS));
        testEntity4.setExpiryDate(date.plus(1, ChronoUnit.DAYS));

        StorageProduct testEntity5 = new StorageProduct();
        testEntity5.setProductName("Canned mandarins");
        testEntity5.setProductType("Canned");
        testEntity5.setPlaceOfStorage("Pantry");
        testEntity5.setPurchaseDate(date.minus(7, ChronoUnit.DAYS));
        testEntity5.setExpiryDate(date.plus(2, ChronoUnit.DAYS));

        ShoppingProduct testEntity6 = new ShoppingProduct();
        testEntity6.setProductName("Frozen vegetables");
        testEntity6.setProductType("Frozen");

        ShoppingProduct testEntity7 = new ShoppingProduct();
        testEntity7.setProductName("30% cream");
        testEntity7.setProductType("Dairy");

        ShoppingProduct testEntity8 = new ShoppingProduct();
        testEntity8.setProductName("Strawberry jam");
        testEntity8.setProductType("Preserve");

        ShoppingProduct testEntity9 = new ShoppingProduct();
        testEntity9.setProductName("Cola");
        testEntity9.setProductType("Drinks");

        ShoppingProduct testEntity10 = new ShoppingProduct();
        testEntity10.setProductName("Kitchen cleaner");
        testEntity10.setProductType("Household chemicals");

        storageProductRepository.save(testEntity1);
        storageProductRepository.save(testEntity2);
        storageProductRepository.save(testEntity3);
        storageProductRepository.save(testEntity4);
        storageProductRepository.save(testEntity5);

        LOGGER.info(("================================ Successfully initialized storage products into database ==============================").toUpperCase());

        shoppingProductRepository.save(testEntity6);
        shoppingProductRepository.save(testEntity7);
        shoppingProductRepository.save(testEntity8);
        shoppingProductRepository.save(testEntity9);
        shoppingProductRepository.save(testEntity10);

        LOGGER.info(("================================ Successfully initialized shopping products into database =============================").toUpperCase());

        User admin = new User();
        admin.setUsername("Admin");
        admin.setPassword(passwordEncoder.encode("Admin1"));
        admin.setEmail(("admin@gmail.com").toUpperCase());
        admin.setRole("ADMIN");
        admin.setEnabled(true);
        userRepository.save(admin);

        User testUser = new User();
        testUser.setUsername("User");
        testUser.setPassword(passwordEncoder.encode("User1"));
        testUser.setEmail(("user@gmail.com").toUpperCase());
        testUser.setRole("USER");
        testUser.setEnabled(true);
        userRepository.save(testUser);
        LOGGER.info(("================================ Successfully initialized test user/admin accounts ====================================").toUpperCase());
    }
}
