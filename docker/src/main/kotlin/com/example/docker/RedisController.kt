package com.example.docker

import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/redis")
class RedisController(private val stringRedisTemplate: StringRedisTemplate) {
    @RequestMapping(value = ["/add"], method = [RequestMethod.GET])
    fun add(@RequestParam(value = "key") key: String, @RequestParam(value = "value") value: String): String {
        val ops = stringRedisTemplate.opsForValue()
        ops[key] = value
        return "success"
    }

    @RequestMapping(value = ["/get"], method = [RequestMethod.GET])
    operator fun get(@RequestParam(value = "key") key: String): String? {
        val ops = stringRedisTemplate.opsForValue()
        return ops[key]
    }
}