package andrey.murzin.core.utils

open class SingletonHolder<out T : Any, in A>(creator: (A) -> T) {
    private var creator: ((A) -> T)? = creator
    @Volatile
    private var instance: T? = null

    fun init(arg: A): T =
        instance ?: run {
            synchronized(this) {
                instance ?: run {
                    creator!!(arg).also {
                        instance = it
                    }
                }
            }
        }

    fun clearInstance() {
        instance = null
    }

}