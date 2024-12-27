package com.lucas.delivery.controller;

import com.lucas.delivery.dto.DeliveryRequestDTO;
import com.lucas.delivery.enums.StatusEnum;
import com.lucas.delivery.model.Delivery;
import com.lucas.delivery.service.DeliveryService;
import jakarta.validation.Valid;
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
    public ResponseEntity<String> saveDelivery(@RequestBody @Valid DeliveryRequestDTO delivery) {
        deliveryService.save(delivery);
        return ResponseEntity.ok("Entrega cadastrada com sucesso!");
    }

    @GetMapping("/list")
    public String listDeliveries(Model model) {
        model.addAttribute("deliveries", deliveryService.findAll());
        return "list";
    }

    @PostMapping("/update/{id}")
    public String updateStatus(@PathVariable Long id, @RequestParam("status") StatusEnum status) {
        deliveryService.updateStatus(id, status);
        return "redirect:/list";
    }

}
