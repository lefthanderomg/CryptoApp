package andrey.murzin.cryptoapp.presetation.feature.currency.flow.di.provider

interface CurrencyFlowHolder {
    fun getCurrentFlowProvider(): CurrencyFlowProvider
}