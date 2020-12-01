package br.com.softfocus.vendas.model

import java.io.Serializable
import java.math.BigDecimal
import java.util.*
import org.springframework.lang.NonNull;
import javax.persistence.*

@Entity
@Table(name = "PRODUTO")
class Produto : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    val id: Long? = null

    @Column(name = "DESCRICAO", nullable = false, length = 100)
    var descricao: String? = null
        private set

    @Column(name = "VALOR", nullable = false, scale = 10, precision = 2)
    var valor: BigDecimal? = null
        private set

    constructor() {
    }

    init {

    }

    private constructor(@NonNull descricao: String, @NonNull valor: BigDecimal) {
        setDescricao(descricao)
        setValor(valor)
    }

    fun setDescricao(@NonNull descricao: String) {
        this.descricao = Objects.requireNonNull(descricao, "descricao não pode ser nula")
    }

    fun setValor(@NonNull valor: BigDecimal) {
        this.valor = Objects.requireNonNull(valor, "valor não pode ser nulo")
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val produto = o as Produto
        return id == produto.id
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }
}