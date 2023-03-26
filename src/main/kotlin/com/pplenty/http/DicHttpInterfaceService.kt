package com.pplenty.http

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import reactor.core.publisher.Mono

@Service
interface DicHttpInterfaceService {

    @GetExchange("/api/v1/contents/list")
    fun getContents(@RequestParam size: Int): Map<String, Any>

    @GetExchange("/api/v1/cps/list?cpKey={cpKey}")
    fun getCps(@PathVariable cpKey: String): Mono<Map<String, Any>>
}
