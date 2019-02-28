package solmedia.ec.kodo.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Todo(
    @Column(name = "MESSAGE")
    @NotBlank
    var message: String? = null,

    var priority: Int = 10,

    @Id @GeneratedValue val id: Long? = null
) {
    val style: String
        get() = when (message?.length) {
            in 0 until 30 -> "text-short"
            in 31 until 60 -> "text-medium"
            in 61 until 120 -> "text-long"
            else -> "text-longest"
        }
}