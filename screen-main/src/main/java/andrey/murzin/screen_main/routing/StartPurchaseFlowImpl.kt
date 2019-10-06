package andrey.murzin.screen_main.routing

import andrey.murzin.core.routing.StartPurchaseFlow
import andrey.murzin.screen_main.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class StartPurchaseFlowImpl @Inject constructor(
    private val router: Router
) : StartPurchaseFlow {

    override fun start(id: Int) {
        router.navigateTo(Screens.PurchaseFlow(id))
    }
}