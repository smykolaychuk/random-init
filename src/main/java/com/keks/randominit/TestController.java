package com.keks.randominit;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.keks.randominit.model.CustomMessage;
import com.keks.randominit.service.CustomMessageService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author smykola
 */
@RestController
@Slf4j
public class TestController {

    @Value("${log.message}")
    private String defaultLogMessage;

    @Autowired
    private CustomMessageService service;

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;


    /**
     * Some description
     */
    @ApiOperation("get IP of machine where app is running")
    @GetMapping("/hello")
    public ResponseEntity<String> get() throws UnknownHostException {
        log.info("Somebody asked me");
        log.error(defaultLogMessage);
//        System.out.println(InetAddress.getLocalHost().getHostName());
//        System.out.println(InetAddress.getLoopbackAddress().getHostName());
//        System.out.println(InetAddress.getLocalHost().getHostAddress());
//        System.out.println( InetAddress.getLoopbackAddress().getHostAddress());

//        String hostName = InetAddress.getLocalHost().getHostName();
        return ResponseEntity.ok("Workin on: " + InetAddress.getLocalHost().getHostAddress());
    }

    @ApiOperation("Echo - returns what you send")
    @PostMapping("/message")
    public ResponseEntity<String> post(@RequestBody CustomMessage customMessage) {
        log.error(defaultLogMessage);
        log.info("Received message from outside world: \"{}\"", customMessage);
        service.add(customMessage);
        return ResponseEntity.ok("ECHO: \"" + customMessage.getMessage() + "\"");
    }

    @ApiOperation("returns all messages")
    @GetMapping("/message")
    public ResponseEntity<List<CustomMessage>> getAll() {
        log.info("redis host: {}", jedisConnectionFactory.getHostName());
        log.info("redis port: {}", jedisConnectionFactory.getPort());
        log.info("Retrieving all mesages");
        return ResponseEntity.ok(service.getAll());
    }
}
