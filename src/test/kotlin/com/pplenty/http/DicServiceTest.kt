package com.pplenty.http

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory


@SpringBootTest
class DicServiceTest @Autowired constructor(
    val dicRestTemplateService: DicRestTemplateService,
    val dicHttpClientService: DicHttpClientService,
    val dicFeignService: DicFeignService,
//    val dicHttpInterfaceService: DicHttpInterfaceService,
) {

    @Test
    fun `RestTemplate 딕 요청`() {
        val resp = dicRestTemplateService.getContents()
        println(getTitle(resp))
    }

    @Test
    fun `HttpClient 딕 요청`() {
        val resp = dicHttpClientService.getContents().block()
        println(getTitle(resp))
    }

    @Test
    fun `Feign 딕 요청`() {
        val resp = dicFeignService.getContents(1)
        println(resp)
        println(getTitle(resp))
    }

    @Test
    fun `Http interface 딕 요청`() {
        val webClient = WebClient.builder()
            .baseUrl("http://api.dic.harmony.dev.daumkakao.io")
            .codecs { it.defaultCodecs().maxInMemorySize(-1) } // to unlimited memory size
            .build()

        val httpServiceProxyFactory = HttpServiceProxyFactory
            .builder(WebClientAdapter.forClient(webClient))
            .build()
        val dicApiInterface = httpServiceProxyFactory.createClient(DicHttpInterfaceService::class.java)

        val contents = dicApiInterface.getContents(1)
        println(getTitle(contents))

        val cp = dicApiInterface.getCps("ohmynews")
        println(cp.block())


    }

    private fun getTitle(resp: Map<*, *>?) =
        (((resp?.get("result") as Map<*, *>)["contents"] as List<*>).first() as Map<*, *>)["title"] as String

}