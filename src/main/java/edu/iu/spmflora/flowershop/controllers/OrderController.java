package edu.iu.spmflora.flowershop.controllers;

import edu.iu.spmflora.flowershop.model.Order;
import edu.iu.spmflora.flowershop.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public int add(@RequestBody Order order) {
        String username = getTheCurrentLoggedInCustomer();
        order.setCustomerUserName(username);
        return orderService.add(order);
    }

    private String getTheCurrentLoggedInCustomer() {
        Object principal = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        String username = "";
        if(principal instanceof Jwt) {
            username = ((Jwt) principal).getSubject();
        }
        return username;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAllByCustomer() {
        String username = getTheCurrentLoggedInCustomer();
        System.out.println(username);
        if(username.trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        List<Order> orders = orderService.findAllByCustomer(username);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Order>> search(@RequestBody Order order) {
        String username = getTheCurrentLoggedInCustomer();
        System.out.println(username);
        if(username.trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            order.setCustomerUserName(username);
        }
        List<Order> orders = orderService.search(order);
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }


}
