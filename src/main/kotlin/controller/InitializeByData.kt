package controller

/**
 * Necessário para função ViewUtils.loadAndSwitchView
 */
abstract class InitializeByData<D> {
    abstract fun onDataReceive(data: D)
}