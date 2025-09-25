package com.example.springbootdemo.services;

import com.example.springbootdemo.models.Items;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private List<Items> items = new ArrayList<>();

    public ItemService() {
        items.add(new Items(1L, "Device1", "Description1", 500.0));
        items.add(new Items(2L, "Device2", "Description2", 1200.0));
        items.add(new Items(3L, "Device3", "Description3", 150.0));
    }

    public List<Items> getItems() {
        return items;
    }
}