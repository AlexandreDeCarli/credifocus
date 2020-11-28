package br.com.softfocus.produtos.api

import br.com.softfocus.produtos.model.Produto
import br.com.softfocus.produtos.repository.ProdutoRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.core.JmsTemplate
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("")
class ProdutoApi {
    @Autowired
    private lateinit var repository: ProdutoRepository

    @Autowired
    private lateinit var jmsTemplate: JmsTemplate
    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @GetMapping
    fun all(): MutableList<Produto?> {
        return repository.findAll()
    }

    @GetMapping("{id}")
    fun one(@PathVariable("id") id: Long): Optional<Produto?> {
        return repository.findById(id)
    }

    @PostMapping
    fun insert(@RequestBody produto: Produto): Produto? {

        var produtoJson = objectMapper.writeValueAsString(produto)

        jmsTemplate.convertAndSend("queue.produto.insert", produtoJson)

        return repository.save(produto)
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable("id") id: Long?) {
        repository.deleteById(id!!)
    }
}
