package com.pplenty.http

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import reactor.core.publisher.Mono

@FeignClient(name = "dicFeignService", url = "http://api.dic.harmony.dev.daumkakao.io")
interface DicFeignService {

    @RequestMapping(method = [RequestMethod.GET], value = ["/api/v1/contents/list"])
    fun getContents(@RequestParam size: Int): Map<String, Any>

    @GetMapping("/api/v1/cps/list?cpKey={cpKey}")
    fun getCps(@PathVariable cpKey: String): Mono<Map<String, Any>>
}
