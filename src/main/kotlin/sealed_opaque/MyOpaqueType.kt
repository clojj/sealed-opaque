package sealed_opaque

sealed class MyOpaqueType {
    companion object {
        fun create(name: String): MyOpaqueType =
            when (val theName = name.toLowerCase()) {
                "one" -> One(theName, 1)
                "two" -> Two(theName)
                "three" -> Three(theName)
                else -> TODO()
        }
    }
}

data class One internal constructor(val name: String, val i: Int): MyOpaqueType()
class Two internal constructor(val name: String): MyOpaqueType()
class Three internal constructor(val name: String): MyOpaqueType()
