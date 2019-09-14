
package andrey.murzin.core.di.holder

import andrey.murzin.core.di.provider.MainToolsProvider

interface ActivityToolsHolder {
    fun getActivityToolsProvider(): MainToolsProvider
}