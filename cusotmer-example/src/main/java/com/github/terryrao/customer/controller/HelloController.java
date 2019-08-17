package com.github.terryrao.customer.controller;

import com.github.terryrao.customer.api.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author raowei
 * @date 2019-08-17
 */
@RestController
public class HelloController {
    @Autowired
    private ProviderService providerService;
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/echo-feign/{str}", method = RequestMethod.GET)
    public String feign(@PathVariable String str) {
        return providerService.echo(str);
    }
    @RequestMapping(value = "/echo-rest/{str}", method = RequestMethod.GET)
    public String rest(@PathVariable String str) {
        return restTemplate.getForObject("http://provider/echo/" + str,
                String.class);
    }
}
