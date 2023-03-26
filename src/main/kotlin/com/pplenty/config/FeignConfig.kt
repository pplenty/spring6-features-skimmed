package com.pplenty.config

import feign.codec.Decoder
import feign.codec.Encoder
import org.springframework.beans.factory.ObjectFactory
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.cloud.openfeign.support.SpringDecoder
import org.springframework.cloud.openfeign.support.SpringEncoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class FeignConfig {

    val messageConverters: ObjectFactory<HttpMessageConverters> =
        ObjectFactory<HttpMessageConverters> { HttpMessageConverters() }

    @Bean
    fun feignDecoder(): Decoder {
        return SpringDecoder(messageConverters)
    }

    @Bean
    fun feignEncoder(): Encoder {
        return SpringEncoder(messageConverters)
    }
}