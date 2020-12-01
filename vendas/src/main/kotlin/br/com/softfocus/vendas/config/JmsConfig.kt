package br.com.softfocus.vendas.config

import org.apache.activemq.ActiveMQConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import org.springframework.jms.config.JmsListenerContainerFactory
import org.springframework.jms.core.JmsTemplate
import javax.jms.ConnectionFactory

@Configuration
class JmsConfig {
    @Value("\${spring.activemq.broker-url}")
    private val brokerUrl: String? = null

    @Value("\${spring.activemq.user}")
    private val userName: String? = null

    @Value("\${spring.activemq.password}")
    private val password: String? = null
    @Bean
    fun connectionFactory(): ConnectionFactory {
        val connectionFactory = ActiveMQConnectionFactory()
        connectionFactory.brokerURL = brokerUrl
        connectionFactory.userName = userName
        connectionFactory.password = password
        return connectionFactory
    }

    @Bean
    fun jsaFactory(connectionFactory: ConnectionFactory?,
                   configurer: DefaultJmsListenerContainerFactoryConfigurer): JmsListenerContainerFactory<*> {
        val factory = DefaultJmsListenerContainerFactory()
        configurer.configure(factory, connectionFactory)
        return factory
    }

    @Bean
    fun jmsTemplate(): JmsTemplate {
        val template = JmsTemplate()
        template.connectionFactory = connectionFactory()
        return template
    }
}