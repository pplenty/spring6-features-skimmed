package com.pplenty.http

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class DicRestTemplateService {

    private val template = RestTemplate()

    fun getContents(): Map<*, *>? {
        return template.getForObject("http://api.dic.harmony.dev.daumkakao.io/api/v1/contents/list", Map::class.java)
    }
}
