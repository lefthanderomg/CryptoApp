package andrey.murzin.screen_main.tools.launcher

import andrey.murzin.core.utils.Launcher
import andrey.murzin.screen_main.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class AppLauncher @Inject constructor(
    private val router: Router
) : Launcher {
    override fun coldStart() {
        router.newRootChain(Screens.BottomNavigationFlow)
    }
}