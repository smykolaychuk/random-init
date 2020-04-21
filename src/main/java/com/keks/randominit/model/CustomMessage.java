package com.keks.randominit.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

/**
 * @author smykola
 */
@RedisHash
@Data
public class CustomMessage {

    @Id
    private Long id;
    private String message;

}
