package com.keks.randominit;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author smykola
 */
@Controller
@Slf4j
public class TestController {

    @Value("${log.message}")
    public String defaultLogMessage;

    /**
     * Some description
     */
    @ApiOperation("get IP of machine where app is running")
    @GetMapping
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
    @PostMapping
    public ResponseEntity<String> post(@RequestBody String body) {
        log.error(defaultLogMessage);
        log.info("Received message from outside world: \"{}\"", body);
        return ResponseEntity.ok("ECHO: \"" + body + "\"");
    }

}
