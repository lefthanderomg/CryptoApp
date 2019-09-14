package andrey.murzin.cryptoapp.tools.launcher

import andrey.murzin.core.utils.Launcher
import andrey.murzin.cryptoapp.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class AppLauncher @Inject constructor(
    private val router: Router
) : Launcher {
    override fun coldStart() {
        router.newRootScreen(Screens.BottomNavigationFlow)
    }

}