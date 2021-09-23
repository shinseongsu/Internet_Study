package com.example.mvc.controller.get

import com.example.mvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class GetApiController {

    @GetMapping(path=["/hello","/abcd"])
    fun hello():String {
        return "hello kotlin"
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"] )
    fun requestMapping(): String {
        return "Request - Get Mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(@PathVariable name:String, @PathVariable age:Int): String {
        println("$name : $age ")
        return name + " : " + age
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}")
    fun pathVariable2(@PathVariable(value = "name") _name:String, @PathVariable(name="age") age:Int): String {
        val name = "Kotlin"

        println("$_name : $age")
        return _name + " : " + age
    }

    @GetMapping("get-mapping/query-param")
    fun queryParam(
        @RequestParam(value="name") myName:String,
        @RequestParam(value="age") age:Int
    ): String {
        println("$myName , $age")
        return "$myName , $age"
    }

    @GetMapping("get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map:Map<String, Any>): Map<String, Any> {
        val phoneNumber = map.get("phone-number")
        println("$map $phoneNumber")
        return map
    }

}