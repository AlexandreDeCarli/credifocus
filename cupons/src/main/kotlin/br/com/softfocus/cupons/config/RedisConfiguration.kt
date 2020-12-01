package br.com.softfocus.cupons.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory

@Configuration
class RedisConfiguration {


    @Value("\${spring.redis.host}")
    private val host: String? = null

    @Value("\${spring.redis.port}")
    private val port: Int? = null

    @Bean
    fun redisConnectionFactory(): JedisConnectionFactory? {
        val config = RedisStandaloneConfiguration(host!!, port!!)
        return JedisConnectionFactory(config)
    }

}