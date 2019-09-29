package andrey.murzin.repository.mapper

abstract class BaseMapper<FROM,TO> {

    abstract fun toEntity(data: FROM): TO
}