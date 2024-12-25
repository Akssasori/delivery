package com.lucas.delivery.controller;

import com.lucas.delivery.model.Delivery;
import com.lucas.delivery.service.DeliveryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("delivery", new Delivery());
        return "form";
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveDelivery(@RequestBody Delivery delivery) {
        deliveryService.save(delivery);
//        attributes.addAttribute("message", "Entrega cadastrada com sucesso!");
        return ResponseEntity.ok("Entrega cadastrada com sucesso!");
    }

    @GetMapping("/list")
    public String listDeliveries(Model model) {
        model.addAttribute("deliveries", deliveryService.findAll());
        return "list";
    }

    @PostMapping("/update/{id}")
    public String updateStatus(@PathVariable Long id, @RequestParam("status") Delivery.Status status) {
        deliveryService.updateStatus(id, status);
        return "redirect:/list";
    }

}
