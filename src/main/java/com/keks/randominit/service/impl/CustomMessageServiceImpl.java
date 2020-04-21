package com.keks.randominit.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.keks.randominit.model.CustomMessage;
import com.keks.randominit.repository.CustomMessageRepository;
import com.keks.randominit.service.CustomMessageService;
import lombok.AllArgsConstructor;

/**
 * @author smykola
 */
@Service
@AllArgsConstructor
public class CustomMessageServiceImpl implements CustomMessageService {
    private final CustomMessageRepository repository;

    @Override
    public CustomMessage add(CustomMessage customMessage) {
        return repository.save(customMessage);
    }

    @Override
    public List<CustomMessage> getAll() {
        final List<CustomMessage> result = Lists.newArrayList();
        repository.findAll().forEach(result::add);
        return result;
    }
}
