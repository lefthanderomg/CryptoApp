package andrey.murzin.screen_currency.flow.di.provider

interface CurrencyFlowHolder {
    fun getCurrentFlowProvider(): CurrencyFlowProvider
}