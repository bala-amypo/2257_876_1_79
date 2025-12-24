package com.example.demo.service;

import com.example.demo.entity.Location;

import java.util.List;

public interface LocationService {

    Location save(Location location);

    List<Location> getAll();

    Location getById(Long id);
}
