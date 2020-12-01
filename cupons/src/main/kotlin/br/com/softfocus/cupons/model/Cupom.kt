package br.com.softfocus.cupons.model

import org.apache.commons.lang.RandomStringUtils
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.lang.NonNull
import java.math.BigDecimal
import java.util.*

@RedisHash(value = "cupom", timeToLive = 60 * 60)
class Cupom(desconto: BigDecimal) {


    @Id
    private var id: String? = null

    private var desconto: BigDecimal? = null

    fun Cupom(@NonNull desconto: BigDecimal?) {
        this.desconto = Objects.requireNonNull(desconto, "desconto não pode ser nulo")
        id = RandomStringUtils.randomAlphanumeric(5)
    }

    fun getId(): String? {
        return id
    }

    fun getDesconto(): BigDecimal? {
        return desconto
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val cupom = o as Cupom
        return Objects.equals(id, cupom.id)
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }

    override fun toString(): String {
        return "Cupom{" +
                "id=" + id +
                ", desconto=" + desconto +
                '}'
    }
}