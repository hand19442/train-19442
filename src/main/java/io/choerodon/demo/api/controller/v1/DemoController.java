package io.choerodon.demo.api.controller.v1;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;

@RestController
@RequestMapping("v1/demo")
public class DemoController {

    @Value("${user.username}")
    private String username;
    @Value("${user.number}")
    private String number;
    @GetMapping("/hello")
    @Permission(level = ResourceLevel.SITE, permissionPublic = true)
    @ApiOperation(value = "demo")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("hello,"+username+","+number, HttpStatus.OK);
    }
}
