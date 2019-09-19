package andrey.murzin.screen_currency.screen.flow.di.provider

interface CurrencyFlowHolder {
    fun getCurrentFlowProvider(): CurrencyFlowProvider
}