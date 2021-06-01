package com.company.services;

import com.company.models.RoomType;
import com.company.models.Type;
import com.company.repository.RoomTypeRepository;
import com.company.utils.Inputs;

import java.io.IOException;
import java.util.ArrayList;

public class RoomTypeService {
    Inputs<Object> inputs = new Inputs<>();
    RoomTypeRepository roomTypeRepository = RoomTypeRepository.getInstance();

    public RoomTypeService() throws IOException {
    }

}
