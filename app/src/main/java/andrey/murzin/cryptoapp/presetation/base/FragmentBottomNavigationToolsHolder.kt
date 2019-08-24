package andrey.murzin.cryptoapp.presetation.base

import andrey.murzin.cryptoapp.presetation.feature.bottomnavigation.di.provider.BottomNavigationToolsProvider

interface FragmentBottomNavigationToolsHolder {
    fun getBottomNavigationToolsProvider() : BottomNavigationToolsProvider
}