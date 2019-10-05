package andrey.murzin.repository.mapper

import andrey.murzin.core.model.Coin
import andrey.murzin.core.model.Url
import andrey.murzin.network.model.UrlModel
import andrey.murzin.repository.entity.UrlEntity
import javax.inject.Inject

class UrlMapper @Inject constructor() :BaseMapper<UrlModel, Url>(){

    override fun toEntity(
        data: UrlModel,
        coin: Coin
    ): Url =
        UrlEntity(
            data.name,
            data.url
        )
}