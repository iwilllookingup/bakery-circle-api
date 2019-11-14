package com.project.controller;

import com.project.dto.*;
import com.project.error.ResourceNotFoundException;
import com.project.model.BakeryTable;
import com.project.model.Menu;
import com.project.model.Orders;
import com.project.model.Transaction;
import com.project.repository.BakeryTableRepository;
import com.project.repository.MenuRepository;
import com.project.repository.OrderRepository;
import com.project.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class BakeryController {

  @Autowired TransactionRepository transactionRepository;
  @Autowired MenuRepository menuRepository;
  @Autowired OrderRepository orderRepository;
  @Autowired BakeryTableRepository bakeryTableRepository;

  @GetMapping("/menus")
  public List<Menu> getProductList() {
    return menuRepository.findAll();
  }

  @GetMapping("/transaction/{table_id}")
  public Transaction getActiveTransaction(@PathVariable(name = "table_id") Integer tableID) {
    if (!transactionRepository.findTransactionByTableIDAndAndTotalPriceIsNull(tableID).isEmpty()) {
      return transactionRepository.findTransactionByTableIDAndAndTotalPriceIsNull(tableID).get(0);
    } else {
      throw new ResourceNotFoundException();
    }
  }

  @PutMapping("/transaction/{transaction_id}")
  public void updateTransaction(@PathVariable(name = "transaction_id") Integer transactionID) {
    Transaction transaction = transactionRepository.getOne(transactionID);

    List<Orders> orders = orderRepository.getOrdersByTransactionID(transactionID);
    int totalPrice =
        orders.stream()
            .map(order -> order.getMenuPrice() * order.getQuantity())
            .collect(Collectors.summingInt(Integer::intValue));

    transaction.setTotalPrice(totalPrice);
    transactionRepository.save(transaction);
  }

  @GetMapping("/menus/bakery")
  public List<Menu> getBakeryList() {
    return menuRepository.findByType("bakery");
  }

  @GetMapping("/menus/drink")
  public List<Menu> getCoffeeList() {
    return menuRepository.findByType("drink");
  }

  @GetMapping("/order/{transaction_id}")
  public List<Orders> getOrderByTransaction(
      @PathVariable(name = "transaction_id") int transactionID) {
    return orderRepository.getOrdersByTransactionID(transactionID);
  }

  @PostMapping("/menu")
  public void createMenu(@Valid @RequestBody CreateMenuRequest createMenuRequest) {
    Menu menu = new Menu();

    menu.setImageURI(createMenuRequest.getImageURI())
        .setDescription(createMenuRequest.getDescription())
        .setMenuName(createMenuRequest.getMenuName())
        .setPrice(createMenuRequest.getPrice())
        .setType(createMenuRequest.getType());

    menuRepository.save(menu);
  }

  @PostMapping("/order")
  public void createOrder(@Valid @RequestBody CreateOrderRequest createOrderRequest) {
    Orders order = new Orders();

    order
        .setQuantity(createOrderRequest.getQuantity())
        .setTransactionID(createOrderRequest.getTransactionID())
        .setCompleted(false)
        .setMenuID(createOrderRequest.getMenuID())
        .setMenuPrice(createOrderRequest.getMenuPrice())
        .setMenuName(createOrderRequest.getMenuName());

    orderRepository.save(order);
  }

  @PostMapping("/transaction")
  public void createTransaction(
      @Valid @RequestBody CreateTransactionRequest createTransactionRequest) {
    Transaction transaction = new Transaction();
    transaction.setTableID(createTransactionRequest.getTableID());

    transactionRepository.save(transaction);
  }

  // TODO
  //  @PostMapping
  public void login() {}

  @GetMapping("/transactions")
  public List<Transaction> getTransaction() {
    return transactionRepository.findAll();
  }

  @GetMapping("/tables")
  public List<BakeryTable> getBakeryTable() {
    return bakeryTableRepository.findAll();
  }

  @PutMapping("/table/{table_id}")
  public void updateTableStatus(
      @PathVariable(name = "table_id") Integer tableID,
      @Valid @RequestBody UpdateTableStatusRequest updateTableStatusRequest) {
    BakeryTable table = bakeryTableRepository.getOne(tableID);
    table.setStatus(updateTableStatusRequest.getStatus());

    bakeryTableRepository.save(table);
  }

  @PutMapping("/menu/{menu_id}/update")
  public void updateMenu(
      @PathVariable(name = "menu_id") int menuID,
      @RequestBody UpdateMenuRequest updateMenuRequest) {
    Menu menu = menuRepository.getOne(menuID);

    if (updateMenuRequest.getDescription() != null) {
      menu.setDescription(updateMenuRequest.getDescription());
    }
    if (updateMenuRequest.getImageURI() != null) {
      menu.setImageURI(updateMenuRequest.getImageURI());
    }
    if (updateMenuRequest.getMenuName() != null) {
      menu.setMenuName(updateMenuRequest.getMenuName());
    }
    if (updateMenuRequest.getPrice() != null) {
      menu.setPrice(updateMenuRequest.getPrice());
    }
    if (updateMenuRequest.getType() != null) {
      menu.setType(updateMenuRequest.getType());
    }

    menuRepository.save(menu);
  }

  @DeleteMapping("/menu/{menu_id}/delete")
  public void deleteMenu(@PathVariable(name = "menu_id") int menuID) {
    menuRepository.deleteById(menuID);
  }
}
