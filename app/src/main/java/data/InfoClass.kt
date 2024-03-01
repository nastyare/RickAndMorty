package data

data class InfoClass(
    val results: List<Character>
)
data class Character(
    val id: Int,
    val name: String,
    val species: String,
    val image: String,

) {
    fun getType(): Int {
        return when (species.toLowerCase()) {
            "human" -> TYPE_IMAGE // Возвращаем URL изображения для человека
            "alien" -> TYPE_NAME  // Возвращаем имя для инопланетянина
            else -> TYPE_SPECIES  // В противном случае возвращаем вид персонажа
        }
    }

    companion object {
        const val TYPE_IMAGE = 2
        const val TYPE_NAME = 0
        const val TYPE_SPECIES = 1
    }
}

