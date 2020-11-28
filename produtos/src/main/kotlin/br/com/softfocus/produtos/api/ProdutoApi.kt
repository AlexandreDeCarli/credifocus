package br.com.softfocus.produtos.api

import br.com.softfocus.produtos.model.Produto
import br.com.softfocus.produtos.repository.ProdutoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping("")
class ProdutoApi {
    @Autowired
    private lateinit var repository: ProdutoRepository

    @GetMapping
    fun all(): MutableList<Produto?> {
        return repository.findAll()
    }

    @GetMapping("{id}")
    fun one(@PathVariable("id") id: Long): Optional<Produto?> {
        return repository.findById(id)
    }
}
