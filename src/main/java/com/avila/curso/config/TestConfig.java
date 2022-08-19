package com.avila.curso.config;

import com.avila.curso.entities.Category;
import com.avila.curso.entities.Order;
import com.avila.curso.entities.Users;
import com.avila.curso.entities.enums.OrderStatus;
import com.avila.curso.repositories.CategoryRepository;
import com.avila.curso.repositories.OrderRepository;
import com.avila.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Users u1 = new Users(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Users u2 = new Users(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1,u2));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1);
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        Category c1 = new Category(null,"Informatica");
        Category c2 = new Category(null,"Limpeza");
        Category c3 = new Category(null,"Mooveis");
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));

    }
}
