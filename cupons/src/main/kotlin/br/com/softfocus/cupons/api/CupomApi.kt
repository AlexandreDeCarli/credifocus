package br.com.softfocus.cupons.api

import br.com.softfocus.cupons.exception.CupomNotFoundException
import br.com.softfocus.cupons.model.Cupom
import br.com.softfocus.cupons.repository.CupomRepository
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal


@RestController
@RequestMapping("")
class CupomApi {

    private var repository: CupomRepository? = null

    fun CupomApi(repository: CupomRepository?) {
        this.repository = repository
    }
    @PostMapping
    fun save(@RequestParam("desconto") desconto: BigDecimal): Cupom? {
        val cupom = Cupom(desconto)
        return repository?.save(cupom)
    }

    @GetMapping
    fun findAll(): MutableIterable<Cupom>? {
        return repository?.findAll()
    }

    @GetMapping
    fun findById(@PathVariable("id") id: String): Cupom? {
        return repository?.findById(id)?.orElseThrow { CupomNotFoundException("Cupom id: $id não encontrado") }
    }
}