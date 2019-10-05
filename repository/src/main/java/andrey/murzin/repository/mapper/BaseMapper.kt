package andrey.murzin.repository.mapper

import andrey.murzin.core.model.Coin

abstract class BaseMapper<FROM,TO> {

    abstract fun toEntity(data: FROM, coin: Coin): TO
}