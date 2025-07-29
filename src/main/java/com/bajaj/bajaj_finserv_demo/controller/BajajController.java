package com.bajaj.bajaj_finserv_demo.controller;

import com.bajaj.bajaj_finserv_demo.controller.model.BajajRequest;
import com.bajaj.bajaj_finserv_demo.controller.model.BajajResponse;
import com.bajaj.bajaj_finserv_demo.service.BajajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bfhl")
public class BajajController {

    @Autowired
    private BajajService bajajService;

    public BajajResponse processData(@RequestBody BajajRequest request){
        return bajajService.processData(request);
    }
}
