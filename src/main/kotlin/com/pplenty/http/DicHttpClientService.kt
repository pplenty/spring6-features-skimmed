package com.pplenty.http

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class DicHttpClientService {
    fun getContents(): Mono<Map<*, *>> {
        val client: WebClient = WebClient.create("http://api.dic.harmony.dev.daumkakao.io")
        return client.get().uri("/api/v1/contents/list").retrieve().bodyToMono(Map::class.java)
    }
}
