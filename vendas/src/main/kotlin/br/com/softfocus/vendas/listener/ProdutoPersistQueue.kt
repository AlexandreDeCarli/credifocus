package br.com.softfocus.vendas.listener


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.softfocus.vendas.model.Produto;
import br.com.softfocus.vendas.repository.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
class ProdutoPersistQueue {
    private val LOGGER: Logger = LoggerFactory.getLogger(ProdutoPersistQueue::class.java)

    private var objectMapper: ObjectMapper? = null

    private lateinit var produtoRepository: ProdutoRepository

    fun ProdutoPersistQueue(objectMapper: ObjectMapper?, produtoRepository: ProdutoRepository?) {
        this.objectMapper = objectMapper
        if (produtoRepository != null) {
            this.produtoRepository = produtoRepository
        }
    }

    @JmsListener(destination = "queue.produto.persist", containerFactory = "jsaFactory")
    fun onReceiverTopic(json: String?) {
        try {
            val produto: Produto? = objectMapper?.readValue(json, Produto::class.java)
            produto?.let {
                produtoRepository.save(it)
            }
        } catch (e: JsonProcessingException) {
            LOGGER.error("Não foi possivel criar uma nova instancia do produto com base no json recebido", e)
        }
    }
}