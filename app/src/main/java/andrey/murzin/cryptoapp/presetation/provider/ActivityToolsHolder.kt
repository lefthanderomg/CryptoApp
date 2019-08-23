
package andrey.murzin.cryptoapp.presetation.provider

import andrey.murzin.cryptoapp.presetation.feature.main.di.provider.MainToolsProvider

interface ActivityToolsHolder {
    fun getActivityToolsProvider(): MainToolsProvider
}