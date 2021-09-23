package com.example.mvc.controller.put

import com.example.mvc.model.http.UserRequest
import org.springframework.boot.context.properties.bind.BindResult
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping():String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path=["/request-mapping"])
    fun requestMapping(): String {
        return "request - Put Mapping"
    }

    @PutMapping(path = ["/put-mapping/object"])
    fun putMappingObject(@Valid @RequestBody userRequest: UserRequest, bindResult: BindingResult): ResponseEntity<String> {

        if(bindResult.hasErrors()) {
            val msg = StringBuilder();
            bindResult.allErrors.forEach {
                val filed = it as FieldError
                val message = it.defaultMessage
                msg.append(filed.field + " : " + message + "\n")
            }
            return ResponseEntity.badRequest().body(msg.toString())
        }
        return ResponseEntity.ok("")

    }

}