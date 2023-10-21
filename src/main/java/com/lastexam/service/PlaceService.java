package com.lastexam.service;

import com.lastexam.model.Place;
import com.lastexam.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }
    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    public void savePlace(Place place) {
        placeRepository.save(place);
    }
}
