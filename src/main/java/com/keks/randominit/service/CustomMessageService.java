package com.keks.randominit.service;

import java.util.List;

import com.keks.randominit.model.CustomMessage;

/**
 * @author smykola
 */
public interface CustomMessageService {

    CustomMessage add(CustomMessage customMessage);

    List<CustomMessage> getAll();
}
