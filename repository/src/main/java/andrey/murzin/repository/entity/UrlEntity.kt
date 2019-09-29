package andrey.murzin.repository.entity

import andrey.murzin.core.model.Url

data class UrlEntity(
    override val name: String?,
    override val urls: List<String>?
) : Url