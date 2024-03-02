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
            "human" -> imageType
            "alien" -> nameType
            else -> speciesType
        }
    }

    companion object {
        const val nameType = 0
        const val speciesType = 1
        const val imageType = 2
    }
}

